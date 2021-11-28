package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwLightningArresterMapper;
import com.example.bdz.pojo.GwLightningArrester;
import com.example.bdz.service.GwLightningArresterService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-11-28
 */
@Service
public class GwLightningArresterServiceImpl extends ServiceImpl<GwLightningArresterMapper, GwLightningArrester> implements GwLightningArresterService {

    @Override
    public Result getLaList(Long id) {
        List<GwLightningArrester> gwLightningArresters = list(new QueryWrapper<GwLightningArrester>());
        return Result.success(gwLightningArresters);
    }
}
