package com.example.bdz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Const;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwRole;
import com.example.bdz.mapper.GwRoleMapper;
import com.example.bdz.pojo.GwRoleMenu;
import com.example.bdz.pojo.GwUserRole;
import com.example.bdz.service.GwRoleMenuService;
import com.example.bdz.service.GwRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.service.GwUserRoleService;
import com.example.bdz.service.GwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
@Service
public class GwRoleServiceImpl extends ServiceImpl<GwRoleMapper, GwRole> implements GwRoleService {
    @Autowired
    GwUserService gwUserService;
    @Autowired
    GwRoleMenuService gwRoleMenuService;
    @Autowired
    GwUserRoleService gwUserRoleService;
    @Override
    public GwRole getByUserId(Long userId) {
        return getOne(new QueryWrapper<GwRole>().inSql("id","select role_id from gw_user_role where user_id="+userId));
    }

    //根据id获取角色信息
    @Override
    public Result info(Integer id) {
        GwRole gwRole = getById(id);
        Assert.notNull(gwRole,"找不到该角色");
        List<GwRoleMenu> gwRoleMenus=gwRoleMenuService.list(new QueryWrapper<GwRoleMenu>().eq("role_id",id));
        List<Integer> menuIds = gwRoleMenus.stream().map(p -> p.getMenuId()).collect(Collectors.toList());
        gwRole.setMenuIds(menuIds);
        return Result.success(gwRole);
    }

    //获取角色列表
    @Override
    public Result getRoleList(String name) {
        List<GwRole> gwRoles=list(new QueryWrapper<GwRole>().like(StrUtil.isNotBlank(name),"name",name));
        return Result.success(gwRoles);
    }

    //添加角色
    @Override
    public Result addRole(GwRole gwRole) {
        gwRole.setStatus(Const.STATUS_ON);
        save(gwRole);
        return Result.success(gwRole);
    }

    //编辑角色
    @Override
    public Result updateRole(Integer id, GwRole gwRole) {
        Assert.notNull(getById(id),"找不到该角色");
        gwRole.setId(id);
        updateById(gwRole);
        //清除缓存
        gwUserService.clearUserAuthorityInfoByRoleId(gwRole.getId());
        return Result.success(gwRole);
    }

    //删除角色
    @Override
    @Transactional
    public Result deleteRole(Integer id) {
        //删除缓存（先删除缓存，不然删除中间表之后会找不到对应的id）
        gwUserService.clearUserAuthorityInfoByRoleId(id);
        //删除中间表
        gwUserRoleService.remove(new QueryWrapper<GwUserRole>().eq("role_id",id));
        gwRoleMenuService.remove(new QueryWrapper<GwRoleMenu>().eq("role_id",id));
        removeById(id);
        return Result.success(null);
    }

    //分配权限
    @Override
    @Transactional
    public Result perm(Integer roleId, Integer[] menuIds) {
        Assert.notNull(getById(roleId),"该角色不存在");
        List<GwRoleMenu> roleMenus=new ArrayList<>();
        for (Integer menuId : menuIds) {
            GwRoleMenu roleMenu=new GwRoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenus.add(roleMenu);
        }
        //先删除原来的记录，再保存
        gwRoleMenuService.remove(new QueryWrapper<GwRoleMenu>().eq("role_id",roleId));
        gwRoleMenuService.saveBatch(roleMenus);
        //删除缓存
        gwUserService.clearUserAuthorityInfoByRoleId(roleId);
        return Result.success(null);
    }

}
