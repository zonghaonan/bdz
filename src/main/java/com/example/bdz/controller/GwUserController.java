package com.example.bdz.controller;


import cn.hutool.core.map.MapUtil;
import com.example.bdz.api.user.GwUserControllerApi;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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
public class GwUserController implements GwUserControllerApi {
    @Autowired
    GwUserService gwUserService;
    @Override
    @GetMapping("/userList")  //查询所有用户
    public Result getUserList() {
        //List<GwUser> gwUsers = gwUserService.list(null);
        return Result.success(gwUserService.list(null));
    }
    @GetMapping("/userInfo")  //查询当前用户
    public Result getUserInfo(Principal principal) {
        GwUser userInfo = gwUserService.getByUsername(principal.getName());
        return Result.success(MapUtil.builder().
                put("userId",userInfo.getUserId()).
                put("username",userInfo.getUsername()).
                put("avatar",userInfo.getAvatar()).
                put("create",userInfo.getCreateTime()).
                map());
    }
}

