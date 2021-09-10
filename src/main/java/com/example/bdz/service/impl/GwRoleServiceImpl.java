package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.pojo.GwRole;
import com.example.bdz.mapper.GwRoleMapper;
import com.example.bdz.service.GwRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
@Service
public class GwRoleServiceImpl extends ServiceImpl<GwRoleMapper, GwRole> implements GwRoleService {
    @Override
    public GwRole getByUserId(Long userId) {
        return getOne(new QueryWrapper<GwRole>().inSql("id","select role_id from gw_user_role where user_id="+userId));
    }

}
