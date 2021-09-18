package com.example.bdz.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Const;
import com.example.bdz.common.lang.Result;
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
    @ApiOperation("根据id获取角色信息接口")
    @PreAuthorize("hasAuthority('gw:role:list')")
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        return gwRoleService.info(id);
    }
    @ApiOperation("获取角色列表接口")
    @PreAuthorize("hasAuthority('gw:role:list')")
    @GetMapping("/list")
    public Result list(String name){
        return gwRoleService.getRoleList(name);
    }
    @ApiOperation("添加角色接口")
    @PreAuthorize("hasAuthority('gw:role:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwRole gwRole){
        return gwRoleService.addRole(gwRole);
    }
    @ApiOperation("更新角色接口")
    @PreAuthorize("hasAuthority('gw:role:update')")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer id,@Validated @RequestBody GwRole gwRole){
        return gwRoleService.updateRole(id,gwRole);
    }
    @ApiOperation("删除角色接口")
    @PreAuthorize("hasAuthority('gw:role:delete')")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        return gwRoleService.deleteRole(id);
    }
    @ApiOperation("分配权限接口")
    @PreAuthorize("hasAuthority('gw:role:perm')")
    @PostMapping("/perm/{roleId}")
    public Result perm(@PathVariable("roleId") Integer roleId,@RequestBody Integer[] menuIds){
        return gwRoleService.perm(roleId,menuIds);
    }
}

