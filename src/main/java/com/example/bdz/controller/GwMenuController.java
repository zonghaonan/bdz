package com.example.bdz.controller;


import cn.hutool.core.map.MapUtil;
import com.example.bdz.common.dto.GwMenuDto;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwMenu;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwMenuService;
import com.example.bdz.service.GwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class GwMenuController {
    @Autowired
    GwMenuService gwMenuService;
    @Autowired
    GwUserService gwUserService;
    @GetMapping("/list")
    public Result menu(Principal principal){
        GwUser gwUser=gwUserService.getByUsername(principal.getName());
        //获取权限信息
        String authority=gwUserService.getUserAuthorityInfo(gwUser.getUserId());
        String[] authorityArray= StringUtils.tokenizeToStringArray(authority,",");
        List<GwMenuDto> navs=gwMenuService.getNavByUserId(gwUser.getUserId());
        return Result.success(MapUtil.builder()
                        .put("authorities",authorityArray)
                        .put("nav",navs)
                        .map());
    }
}

