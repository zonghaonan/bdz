package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwEarthingSwitchMapper;
import com.example.bdz.pojo.GwEarthingSwitch;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwEarthingSwitchService;
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
public class GwEarthingSwitchServiceImpl extends ServiceImpl<GwEarthingSwitchMapper, GwEarthingSwitch> implements GwEarthingSwitchService {

    @Override
    public Result getEsList(Long id) {
        List<GwEarthingSwitch> gwEarthingSwitches = list(new QueryWrapper<GwEarthingSwitch>());
        return Result.success(gwEarthingSwitches);
    }

    @Override
    public Result info(Long id) {
        GwEarthingSwitch gwEarthingSwitch = getById(id);
        org.springframework.util.Assert.notNull(gwEarthingSwitch,"找不到该设备");
        return Result.success(gwEarthingSwitch);
    }
}
