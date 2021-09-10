package com.example.bdz.service;

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
}
