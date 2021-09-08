package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.pojo.GwMenu;
import com.example.bdz.pojo.GwRole;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.mapper.GwUserMapper;
import com.example.bdz.service.GwMenuService;
import com.example.bdz.service.GwRoleService;
import com.example.bdz.service.GwUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    RedisUtil redisUtil;
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
            redisUtil.set("GrantedAuthority:"+userId,authority,60*60);
        }
        return authority;
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
}
