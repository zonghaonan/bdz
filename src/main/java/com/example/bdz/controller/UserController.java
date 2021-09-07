package com.example.bdz.controller;

import com.example.bdz.api.user.UserControllerApi;
import com.example.bdz.pojo.User;
import com.example.bdz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhn
 * @Date 2021/8/31 16:59
 * @Version 1.0
 */
@RestController
public class UserController implements UserControllerApi {
    @Autowired
    public UserService userService;
    @Override
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/hello")
    public String helloWorld() {
        return "你好！";
    }

    @PreAuthorize("hasAuthority('gw:user:add')")
    @GetMapping("/hello2")
    public String helloWorld2() {
        return "你不好！";
    }
    @Override
    @GetMapping("/userList")  //查询所有用户
    public List<User> getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }
}
