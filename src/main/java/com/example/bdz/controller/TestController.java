package com.example.bdz.controller;

import com.example.bdz.pojo.User;
import com.example.bdz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author zhn
 * @Date 2021/8/31 16:59
 * @Version 1.0
 */
@RestController
public class TestController {
    @Autowired
    public UserService userService;
    @GetMapping("/hello")
    public String helloWorld(){
        return "你好！";
    }
    @GetMapping("/userList")
    public List<User> getUserList(){
        List<User> userList = userService.getUserList();
        return userList;
    }
}
