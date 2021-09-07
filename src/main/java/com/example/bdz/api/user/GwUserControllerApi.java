package com.example.bdz.api.user;

import com.example.bdz.common.lang.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author zhn
 * @Date 2021/9/1 20:59
 * @Version 1.0
 */
@Api(description  =  "用户接口")
public interface GwUserControllerApi {
    @ApiOperation("用户列表接口")
    public Result getUserList();
}
