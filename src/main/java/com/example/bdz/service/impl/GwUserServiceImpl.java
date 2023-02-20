package com.example.bdz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bdz.common.dto.PasswordDto;
import com.example.bdz.common.lang.Const;
import com.example.bdz.common.lang.ErrorCode;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.*;
import com.example.bdz.mapper.GwUserMapper;
import com.example.bdz.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.utils.RedisUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-03
 */
@Service
public class GwUserServiceImpl extends ServiceImpl<GwUserMapper, GwUser> implements GwUserService {
    @Autowired
    GwRoleService gwRoleService;
    @Autowired
    GwUserMapper gwUserMapper;
    @Autowired
    GwMenuService gwMenuService;
    @Autowired
    GwUserRoleService gwUserRoleService;
    @Autowired
    GwPrefabsService gwPrefabsService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    HttpServletRequest request;
    @Override
    public GwUser getByUsername(String username) {
        return getOne(new QueryWrapper<GwUser>().eq("username",username));
    }

    @Override
    public String getUserAuthorityInfo(Long userId) {
        String authority="";
        if(redisUtil.hasKey("GrantedAuthority:"+userId)){
            //System.out.println((String) redisUtil.get("GrantedAuthority:"+userId));
            authority= (String) redisUtil.get("GrantedAuthority:"+userId);
        }else {
            //获取角色
            List<GwRole> roles = gwRoleService.list(new QueryWrapper<GwRole>().
                    inSql("id", "select role_id from gw_user_role where user_id=" + userId));

            if(roles.size()>0){
                String roleCodes = roles.stream().map(r->"ROLE_"+r.getCode()).collect(Collectors.joining(","));
                authority=roleCodes.concat(",");
            }
            //获取授权码
            List<Integer> menuIds = gwUserMapper.getMenuIds(userId);
            if(menuIds.size()>0){
                List<GwMenu> gwMenus = gwMenuService.listByIds(menuIds);
                String menuPerms = gwMenus.stream().map(m->m.getPerms()).collect(Collectors.joining(","));
                authority=authority.concat(menuPerms);
            }
            redisUtil.set("GrantedAuthority:"+userId,authority, Const.EXPIRE);
        }
        return authority;
    }

    //根据用户id查询用户信息
    @Override
    public Result info(Long userId) {
        GwUser gwUser = getById(userId);
        Assert.notNull(gwUser,"找不到该用户");
        GwRole gwRole=gwRoleService.getByUserId(userId);
        gwUser.setGwRole(gwRole);
        return Result.success(gwUser);
    }

    //查询用户列表
    @Override
    public Result getUserList(String username) {
        Page<GwUser> gwUserPage=page(getPage(),new QueryWrapper<GwUser>().like(StrUtil.isNotBlank(username),"username",username));
        for (GwUser gwUser : gwUserPage.getRecords()) {
            gwUser.setGwRole(gwRoleService.getByUserId(gwUser.getUserId()));
        }
        return Result.success(gwUserPage);
    }

    //添加用户
    @Override
    @Transactional
    public Result addUser(GwUser gwUser) {
        GwUser u = getByUsername(gwUser.getUsername());
        if(u!=null){
            return Result.fail("用户名已存在");
        }
        //校验邮箱
        if(!verifyEmail(gwUser.getEmail())){
            return Result.fail(ErrorCode.INVALIDPARAM.code(),"邮箱格式不正确",null);
        }
        //校验手机号
        if(!verifyPhone(gwUser.getPhone())){
            return Result.fail(ErrorCode.INVALIDPARAM.code(),"手机号格式不正确",null);
        }
        gwUser.setStatus(Const.STATUS_ON);
        String password=passwordEncoder.encode(Const.DEFAULT_PASSWORD);
        gwUser.setPassword(password);
        boolean re = save(gwUser);
        //默认分配普通用户角色
        GwUserRole userRole=new GwUserRole();
        userRole.setUserId(gwUser.getUserId());
        userRole.setRoleId(2);
        gwUserRoleService.save(userRole);
        gwUser.setGwRole(gwRoleService.getByUserId(gwUser.getUserId()));
        return Result.success(gwUser);
    }

    //更新用户
    @Override
    public Result updateUser(Long userId,GwUser gwUser) {
        GwUser user = getById(userId);
        Assert.notNull(user,"该用户不存在");
        if(!user.getUsername().equals(gwUser.getUsername())){
            return Result.fail("用户名不能修改");
        }
        //校验邮箱
        if(!verifyEmail(gwUser.getEmail())){
            return Result.fail(ErrorCode.INVALIDPARAM.code(),"邮箱格式不正确",null);
        }
        //校验手机号
        if(!verifyPhone(gwUser.getPhone())){
            return Result.fail(ErrorCode.INVALIDPARAM.code(),"手机号格式不正确",null);
        }
        gwUser.setUserId(userId);
        updateById(gwUser);
        gwUser.setGwRole(gwRoleService.getByUserId(userId));
        return Result.success(gwUser);
    }

    //删除用户
    @Override
    @Transactional
    public Result deleteUser(Long userId) {
        Assert.notNull(getById(userId),"该用户不存在");
        //清除缓存
        clearUserAuthorityInfo(userId);
        clearUserJwtByUserId(userId);
        //删除中间表
        gwUserRoleService.remove(new QueryWrapper<GwUserRole>().eq("user_id",userId));
        //删除预制体表
        gwPrefabsService.remove(new QueryWrapper<GwPrefabs>().eq("user_id",userId));
        removeById(userId);
        return Result.success(null);
    }

    //分配角色
    @Override
    @Transactional
    public Result perm(Long userId, Integer roleId) {
        Assert.notNull(getById(userId),"该用户不存在");
        GwUserRole userRole=new GwUserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        gwUserRoleService.saveOrUpdate(userRole,new QueryWrapper<GwUserRole>().eq("user_id",userId));
        //删除缓存
        clearUserAuthorityInfo(userId);
        return Result.success(null);
    }

    //重置密码
    @Override
    public Result repass(Long userId) {
        GwUser gwUser=getById(userId);
        Assert.notNull(gwUser,"该用户不存在");
        gwUser.setPassword(passwordEncoder.encode(Const.DEFAULT_PASSWORD));
        updateById(gwUser);
        return Result.success(null);
    }

    //修改密码
    @Override
    public Result updatePwd(PasswordDto passwordDto, Principal principal) {
        GwUser gwUser=getByUsername(principal.getName());
        boolean match=passwordEncoder.matches(passwordDto.getCurrentPwd(),gwUser.getPassword());
        if(!match){
            return Result.fail("旧密码不正确");
        }
        gwUser.setPassword(passwordEncoder.encode(passwordDto.getPwd()));
        updateById(gwUser);
        return Result.success(null);
    }

    @Override
    public Result addUser2(GwUser gwUser) {
        try {
            addUser(gwUser);
            System.out.println("添加用户成功");
        }catch (Exception e){
            System.out.println("添加用户异常");
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void clearUserAuthorityInfo(Long userId) {
        redisUtil.del("GrantedAuthority:"+userId);
    }

    @Override
    public void clearUserJwtByUserId(Long userId) {
        redisUtil.del("jwt:"+userId);
    }

    @Override
    public void clearUserAuthorityInfoByRoleId(Integer roleId) {
        List<GwUser> gwUsers = this.list(new QueryWrapper<GwUser>().
                inSql("user_id", "select user_id from gw_user_role where role_id=" + roleId));
        gwUsers.forEach(item->{
            clearUserAuthorityInfo(item.getUserId());
        });
    }

    @Override
    public void clearUserAuthorityInfoByMenuId(Integer menuId) {
        List<GwUser> gwUsers=gwUserMapper.listByMenuId(menuId);
        gwUsers.forEach(item->{
            clearUserAuthorityInfo(item.getUserId());
        });
    }

    //邮箱校验
    boolean verifyEmail(String email){
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }
    //手机号校验
    boolean verifyPhone(String phone){
        String check = "^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }

    //获取分页
    public Page getPage(){
        int page= ServletRequestUtils.getIntParameter(request,"page",1);
        int size= ServletRequestUtils.getIntParameter(request,"size",10);
        return new Page(page,size);
    }

}
