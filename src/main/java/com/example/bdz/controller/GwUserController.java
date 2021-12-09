package com.example.bdz.controller;


import cn.hutool.core.map.MapUtil;
import com.example.bdz.common.dto.PasswordDto;
import com.example.bdz.common.lang.Const;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwRoleService;
import com.example.bdz.service.GwUserRoleService;
import com.example.bdz.service.GwUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
public class GwUserController extends BaseController {
    @Autowired
    GwUserService gwUserService;
    @GetMapping("/userInfo")  //查询当前用户
    @PreAuthorize("hasAuthority('gw:user')")
    @ApiOperation("查询当前用户接口")
    public Result getUserInfo(Principal principal) {
        GwUser userInfo = gwUserService.getByUsername(principal.getName());
        return Result.success(MapUtil.builder().
                put("userId",userInfo.getUserId()).
                put("username",userInfo.getUsername()).
                put("avatar",userInfo.getAvatar()).
                put("create",userInfo.getCreateTime()).
                map());
    }
    @GetMapping("/info/{userId}")
    @PreAuthorize("hasAuthority('gw:user')")
    @ApiOperation("根据用户id查询用户信息接口")
    public Result info(@PathVariable("userId")Long userId) {
        return gwUserService.info(userId);
    }
    @GetMapping("/list")  //查询所有用户
    @PreAuthorize("hasAuthority('gw:user')")
    @ApiOperation("查询用户列表接口")
    public Result list(String username) {
        return gwUserService.getUserList(username);
    }
    @ApiOperation("添加用户接口")
    @PreAuthorize("hasAuthority('gw:user')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwUser gwUser){
        return gwUserService.addUser(gwUser);
    }

    @ApiOperation("更新用户接口")
    @PreAuthorize("hasAuthority('gw:user')")
    @PostMapping("/update/{userId}")
    public Result update(@PathVariable("userId") Long userId,@Validated @RequestBody GwUser gwUser){
        return gwUserService.updateUser(userId,gwUser);
    }
    @ApiOperation("删除用户接口")
    @PreAuthorize("hasAuthority('gw:user')")
    @PostMapping("/delete/{userId}")
    public Result delete(@PathVariable("userId") Long userId){
        return gwUserService.deleteUser(userId);
    }
    @ApiOperation("分配角色接口")
    @PreAuthorize("hasAuthority('gw:user')")
    @PostMapping("/perm/{userId}/{roleId}")
    public Result perm(@PathVariable("userId") Long userId,@PathVariable("roleId") Integer roleId){
        return gwUserService.perm(userId,roleId);
    }
    @ApiOperation("重置密码接口")
    @PreAuthorize("hasAuthority('gw:user')")
    @PostMapping("/repass/{userId}")
    public Result repass(@PathVariable("userId") Long userId){
        return gwUserService.repass(userId);
    }
    @ApiOperation("修改密码接口")
    @PostMapping("/updatePwd")
    public Result updatePwd(@Validated @RequestBody PasswordDto passwordDto,Principal principal){
        return gwUserService.updatePwd(passwordDto,principal);
    }
}

