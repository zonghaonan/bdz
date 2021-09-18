package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
public interface GwRoleService extends IService<GwRole> {

    GwRole getByUserId(Long userId);

    Result info(Integer id);

    Result getRoleList(String name);

    Result addRole(GwRole gwRole);

    Result updateRole(Integer id, GwRole gwRole);

    Result deleteRole(Integer id);

    Result perm(Integer roleId, Integer[] menuIds);
}
