package com.example.bdz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bdz.service.GwUserService;
import com.example.bdz.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

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
    @Autowired
    GwUserService gwUserService;
    public Page getPage(){
        int page= ServletRequestUtils.getIntParameter(request,"page",1);
        int size= ServletRequestUtils.getIntParameter(request,"size",10);
        return new Page(page,size);
    }
}
