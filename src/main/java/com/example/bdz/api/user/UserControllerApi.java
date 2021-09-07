package com.example.bdz.api.user;

import com.example.bdz.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @Author zhn
 * @Date 2021/9/1 20:59
 * @Version 1.0
 */
@Api(description  =  "测试接口")
public interface UserControllerApi {
    @ApiOperation("hello接口")
    public String helloWorld();
    @ApiOperation("userList接口")
    public List<User> getUserList();
}
