package com.example.bdz.controller;


import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.dto.GwMenuDto;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwMenu;
import com.example.bdz.pojo.GwRoleMenu;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwMenuService;
import com.example.bdz.service.GwRoleMenuService;
import com.example.bdz.service.GwUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
@RestController
@RequestMapping("/gw/menu")
public class GwMenuController extends BaseController {
    @Autowired
    GwMenuService gwMenuService;
    @ApiOperation("获取当前用户的权限列表接口")
    @GetMapping("/menus")
    public Result menus(Principal principal){
        return gwMenuService.menus(principal);
    }
    @ApiOperation("根据id获取权限信息接口")
    @GetMapping("/info/{id}")
    @PreAuthorize("hasAuthority('gw:menu')")
    public Result info(@PathVariable("id") Integer id){
        return gwMenuService.info(id);
    }
    @ApiOperation("获取权限列表接口")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('gw:menu')")
    public Result list(String name){
        return gwMenuService.getMenuList(name);
    }

//    @ApiOperation("添加权限接口")
//    @PostMapping("/save")
//    @PreAuthorize("hasAuthority('gw:menu:save')")
//    public Result save(@Validated @RequestBody GwMenu gwMenu){
//        gwMenuService.save(gwMenu);
//        return Result.success(gwMenu);
//    }
//
//    @ApiOperation("更新权限接口")
//    @PostMapping("/update")
//    @PreAuthorize("hasAuthority('gw:menu:update')")
//    public Result update(@Validated @RequestBody GwMenu gwMenu){
//        gwMenuService.updateById(gwMenu);
//        //清除相关缓存
//        gwUserService.clearUserAuthorityInfoByMenuId(gwMenu.getId());
//        return Result.success(gwMenu);
//    }
//
//    @ApiOperation("删除权限接口")
//    @PostMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('gw:menu:delete')")
//    @Transactional
//    public Result delete(@PathVariable("id") Integer id){
//        int count=gwMenuService.count(new QueryWrapper<GwMenu>().eq("parent_id",id));
//        if(count>0)
//            return Result.fail("请先删除子菜单");
//        //清除相关缓存
//        System.out.println("id:"+id);
//        gwUserService.clearUserAuthorityInfoByMenuId(id);
//        //删除相关关联表信息
//        gwRoleMenuService.remove(new QueryWrapper<GwRoleMenu>().eq("menu_id",id));
//        gwMenuService.removeById(id);
//        return Result.success(null);
//    }
}

