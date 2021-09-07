package com.example.bdz.controller;

import com.example.bdz.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhn
 * @Date 2021/9/3 20:12
 * @Version 1.0
 */
public class BaseController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    RedisUtil redisUtil;
}
