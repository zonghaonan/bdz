package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwIsolatingSwitchMapper;
import com.example.bdz.pojo.GwIsolatingSwitch;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwIsolatingSwitchService;
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
public class GwIsolatingSwitchServiceImpl extends ServiceImpl<GwIsolatingSwitchMapper, GwIsolatingSwitch> implements GwIsolatingSwitchService {

    @Override
    public Result getIsList(Long id) {
        List<GwIsolatingSwitch> gwIsolatingSwitchs = list(new QueryWrapper<GwIsolatingSwitch>());
        return Result.success(gwIsolatingSwitchs);
    }

    @Override
    public Result info(Long id) {
        GwIsolatingSwitch gwIsolatingSwitch = getById(id);
        org.springframework.util.Assert.notNull(gwIsolatingSwitch,"找不到该设备");
        return Result.success(gwIsolatingSwitch);
    }
}
