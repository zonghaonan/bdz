package com.example.bdz.service;

import com.example.bdz.common.dto.PasswordDto;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwUser;
import com.baomidou.mybatisplus.extension.service.IService;
import sun.rmi.runtime.Log;

import java.security.Principal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-09-03
 */
public interface GwUserService extends IService<GwUser> {

    GwUser getByUsername(String username);

    String getUserAuthorityInfo(Long userId);

    void clearUserAuthorityInfo(Long userId);
    void clearUserJwtByUserId(Long userId);
    void clearUserAuthorityInfoByRoleId(Integer roleId);
    void clearUserAuthorityInfoByMenuId(Integer menuId);

    Result info(Long userId);

    Result getUserList(String username);

    Result addUser(GwUser gwUser);

    Result updateUser(Long userId,GwUser gwUser);

    Result deleteUser(Long userId);

    Result perm(Long userId, Integer roleId);

    Result repass(Long userId);

    Result updatePwd(PasswordDto passwordDto, Principal principal);

    Result addUser2(GwUser gwUser);
}
