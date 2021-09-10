package com.example.bdz.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bdz.api.user.GwUserControllerApi;
import com.example.bdz.common.dto.PasswordDto;
import com.example.bdz.common.lang.Const;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwRole;
import com.example.bdz.pojo.GwRoleMenu;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.pojo.GwUserRole;
import com.example.bdz.service.GwRoleService;
import com.example.bdz.service.GwUserRoleService;
import com.example.bdz.service.GwUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhn
 * @since 2021-09-03
 */
@RestController
@RequestMapping("/gw/user")
public class GwUserController extends BaseController {
    @Autowired
    GwUserService gwUserService;
    @Autowired
    GwRoleService gwRoleService;
    @Autowired
    GwUserRoleService gwUserRoleService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @GetMapping("/userInfo")  //查询当前用户
    @PreAuthorize("hasAuthority('gw:user')")
    @ApiOperation("查询当前用户接口")
    public Result getUserInfo(Principal principal) {
        GwUser userInfo = gwUserService.getByUsername(principal.getName());
        return Result.success(MapUtil.builder().
                put("userId",userInfo.getUserId()).
                put("username",userInfo.getUsername()).
                put("avatar",userInfo.getAvatar()).
                put("create",userInfo.getCreateTime()).
                map());
    }
    @GetMapping("/info/{userId}")
    @PreAuthorize("hasAuthority('gw:user')")
    @ApiOperation("根据用户id查询用户信息接口")
    public Result getUserList(@PathVariable("userId")Long userId) {
        GwUser gwUser = gwUserService.getById(userId);
        Assert.notNull(gwUser,"找不到该用户");
        GwRole gwRole=gwRoleService.getByUserId(userId);
        gwUser.setGwRole(gwRole);
        return Result.success(gwUser);
    }
    @GetMapping("/list")  //查询所有用户
    @PreAuthorize("hasAuthority('gw:user')")
    @ApiOperation("查询用户列表接口")
    public Result getUserList(String username) {
        Page<GwUser> gwUserPage=gwUserService.page(getPage(),new QueryWrapper<GwUser>().like(StrUtil.isNotBlank(username),"username",username));
        for (GwUser gwUser : gwUserPage.getRecords()) {
            gwUser.setGwRole(gwRoleService.getByUserId(gwUser.getUserId()));
        }
        return Result.success(gwUserPage);
    }
    @ApiOperation("添加用户接口")
    @PreAuthorize("hasAuthority('gw:user:save')")
    @PostMapping("/save")
    @Transactional
    public Result save(@Validated @RequestBody GwUser gwUser){
        GwUser u = gwUserService.getByUsername(gwUser.getUsername());
        if(u!=null){
            return Result.fail("用户名已存在");
        }
        gwUser.setStatus(Const.STATUS_ON);
        String password=passwordEncoder.encode(Const.DEFAULT_PASSWORD);
        gwUser.setPassword(password);
        gwUserService.save(gwUser);
        //默认分配普通用户角色
        GwUserRole userRole=new GwUserRole();
        userRole.setUserId(gwUser.getUserId());
        userRole.setRoleId(2);
        gwUserRoleService.save(userRole);
        return Result.success(gwUser);
    }
    @ApiOperation("更新用户接口")
    @PreAuthorize("hasAuthority('gw:user:update')")
    @PostMapping("/update/{userId}")
    public Result update(@PathVariable("userId") Long userId,@Validated @RequestBody GwUser gwUser){
        GwUser user = gwUserService.getById(userId);
        Assert.notNull(user,"该用户不存在");
        if(!user.getUsername().equals(gwUser.getUsername())){
            return Result.fail("用户名不能修改");
        }
        gwUser.setUserId(userId);
        gwUserService.updateById(gwUser);
        return Result.success(gwUser);
    }
    @ApiOperation("删除用户接口")
    @PreAuthorize("hasAuthority('gw:user:delete')")
    @PostMapping("/delete/{userId}")
    @Transactional
    public Result delete(@PathVariable("userId") Long userId){
        Assert.notNull(gwUserService.getById(userId),"该用户不存在");
        //清除缓存
        gwUserService.clearUserAuthorityInfo(userId);
        gwUserService.clearUserJwtByUserId(userId);
        //删除中间表
        gwUserRoleService.remove(new QueryWrapper<GwUserRole>().eq("user_id",userId));
        gwUserService.removeById(userId);
        return Result.success(null);
    }
    @ApiOperation("分配角色接口")
    @PreAuthorize("hasAuthority('gw:user:perm')")
    @PostMapping("/perm/{userId}/{roleId}")
    @Transactional
    public Result perm(@PathVariable("userId") Long userId,@PathVariable("roleId") Integer roleId){
        Assert.notNull(gwUserService.getById(userId),"该用户不存在");
        GwUserRole userRole=new GwUserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        gwUserRoleService.saveOrUpdate(userRole,new QueryWrapper<GwUserRole>().eq("user_id",userId));
        //删除缓存
        gwUserService.clearUserAuthorityInfo(userId);
        return Result.success(null);
    }
    @ApiOperation("重置密码接口")
    @PreAuthorize("hasAuthority('gw:user:repass')")
    @PostMapping("/repass/{userId}")
    public Result repass(@PathVariable("userId") Long userId){
        GwUser gwUser=gwUserService.getById(userId);
        Assert.notNull(gwUser,"该用户不存在");
        gwUser.setPassword(passwordEncoder.encode(Const.DEFAULT_PASSWORD));
        gwUserService.updateById(gwUser);
        return Result.success(null);
    }
    @ApiOperation("修改密码接口")
    @PostMapping("/updatePwd")
    public Result updatePwd(@Validated @RequestBody PasswordDto passwordDto,Principal principal){
        GwUser gwUser=gwUserService.getByUsername(principal.getName());
        boolean match=passwordEncoder.matches(passwordDto.getCurrentPwd(),gwUser.getPassword());
        if(!match){
            return Result.fail("旧密码不正确");
        }
        gwUser.setPassword(passwordEncoder.encode(passwordDto.getPwd()));
        gwUserService.updateById(gwUser);
        return Result.success(null);
    }
}

