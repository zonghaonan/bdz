package com.example.bdz.service;

import com.example.bdz.pojo.GwUser;
import com.baomidou.mybatisplus.extension.service.IService;
import sun.rmi.runtime.Log;

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
    void clearUserAuthorityInfoByRoleId(Integer roleId);
    void clearUserAuthorityInfoByMenuId(Integer menuId);
}
