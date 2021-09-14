package com.example.bdz.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bdz.common.lang.Const;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwMenu;
import com.example.bdz.pojo.GwRole;
import com.example.bdz.pojo.GwRoleMenu;
import com.example.bdz.pojo.GwUserRole;
import com.example.bdz.service.GwRoleMenuService;
import com.example.bdz.service.GwRoleService;
import com.example.bdz.service.GwUserRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
@RestController
@RequestMapping("/gw/role")
public class GwRoleController extends BaseController {

    @Autowired
    GwRoleService gwRoleService;
    @Autowired
    GwRoleMenuService gwRoleMenuService;
    @Autowired
    GwUserRoleService gwUserRoleService;
    @ApiOperation("根据id获取角色信息接口")
    @PreAuthorize("hasAuthority('gw:role:list')")
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        GwRole gwRole = gwRoleService.getById(id);
        Assert.notNull(gwRole,"找不到该角色");
        List<GwRoleMenu> gwRoleMenus=gwRoleMenuService.list(new QueryWrapper<GwRoleMenu>().eq("role_id",id));
        List<Integer> menuIds = gwRoleMenus.stream().map(p -> p.getMenuId()).collect(Collectors.toList());
        gwRole.setMenuIds(menuIds);
        return Result.success(gwRole);
    }
    @ApiOperation("获取角色列表接口")
    @PreAuthorize("hasAuthority('gw:role:list')")
    @GetMapping("/list")
    public Result list(String name){
        List<GwRole> gwRoles=gwRoleService.list(new QueryWrapper<GwRole>().like(StrUtil.isNotBlank(name),"name",name));
        return Result.success(gwRoles);
    }
    @ApiOperation("添加角色接口")
    @PreAuthorize("hasAuthority('gw:role:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwRole gwRole){
        gwRole.setStatus(Const.STATUS_ON);
        gwRoleService.save(gwRole);
        return Result.success(gwRole);
    }
    @ApiOperation("更新角色接口")
    @PreAuthorize("hasAuthority('gw:role:update')")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer id,@Validated @RequestBody GwRole gwRole){
        Assert.notNull(gwRoleService.getById(id),"找不到该角色");
        gwRole.setId(id);
        gwRoleService.updateById(gwRole);
        //清除缓存
        gwUserService.clearUserAuthorityInfoByRoleId(gwRole.getId());
        return Result.success(gwRole);
    }
    @ApiOperation("删除角色接口")
    @PreAuthorize("hasAuthority('gw:role:delete')")
    @DeleteMapping("/delete/{id}")
    @Transactional
    public Result delete(@PathVariable("id") Integer id){
        //删除缓存（先删除缓存，不然删除中间表之后会找不到对应的id）
        gwUserService.clearUserAuthorityInfoByRoleId(id);
        //删除中间表
        gwUserRoleService.remove(new QueryWrapper<GwUserRole>().eq("role_id",id));
        gwRoleMenuService.remove(new QueryWrapper<GwRoleMenu>().eq("role_id",id));
        gwRoleService.removeById(id);
        return Result.success(null);
    }
    @ApiOperation("分配权限接口")
    @PreAuthorize("hasAuthority('gw:role:perm')")
    @PostMapping("/perm/{roleId}")
    @Transactional
    public Result perm(@PathVariable("roleId") Integer roleId,@RequestBody Integer[] menuIds){
        Assert.notNull(gwRoleService.getById(roleId),"该角色不存在");
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

