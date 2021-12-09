package com.example.bdz.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.dto.GwMenuDto;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwUserMapper;
import com.example.bdz.pojo.GwMenu;
import com.example.bdz.mapper.GwMenuMapper;
import com.example.bdz.pojo.GwRole;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.service.GwRoleMenuService;
import com.example.bdz.service.GwUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
@Service
public class GwMenuServiceImpl extends ServiceImpl<GwMenuMapper, GwMenu> implements GwMenuService {

    @Autowired
    GwUserMapper gwUserMapper;
    @Autowired
    GwRoleMenuService gwRoleMenuService;
    @Autowired
    GwUserService gwUserService;

    //获取当前用户的权限列表
    @Override
    public Result menus(Principal principal) {
        GwUser gwUser=gwUserService.getByUsername(principal.getName());
        //获取权限信息
        String authority=gwUserService.getUserAuthorityInfo(gwUser.getUserId());
        String[] authorityArray= StringUtils.tokenizeToStringArray(authority,",");
        List<Integer> menuIds = gwUserMapper.getMenuIds(gwUser.getUserId());
        List<GwMenu> menus = this.listByIds(menuIds);
        return Result.success(MapUtil.builder()
                .put("authorities",authorityArray)
                .put("menus",menus)
                .map());
    }

    //根据id获取权限信息
    @Override
    public Result info(Integer id) {
        GwMenu gwMenu = getById(id);
        Assert.notNull(gwMenu,"找不到该权限");
        return Result.success(gwMenu);
    }
    @ApiOperation("获取隔离开关列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result getMenuList(String name){
        List<GwMenu> gwMenus=list(new QueryWrapper<GwMenu>().like(StrUtil.isNotBlank(name),"name",name));
        return Result.success(gwMenus);
    }

}
