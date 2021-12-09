package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwBypassSwitchMapper;
import com.example.bdz.pojo.GwBypassSwitch;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwBypassSwitchService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-12-02
 */
@Service
public class GwBypassSwitchServiceImpl extends ServiceImpl<GwBypassSwitchMapper, GwBypassSwitch> implements GwBypassSwitchService {

    @Override
    public Result getBsList(Long id) {
        List<GwBypassSwitch> gwBypassSwitches = list(new QueryWrapper<GwBypassSwitch>());
        return Result.success(gwBypassSwitches);
    }

    @Override
    public Result info(Long id) {
        GwBypassSwitch gwBypassSwitch = getById(id);
        org.springframework.util.Assert.notNull(gwBypassSwitch,"找不到该设备");
        return Result.success(gwBypassSwitch);
    }
}
