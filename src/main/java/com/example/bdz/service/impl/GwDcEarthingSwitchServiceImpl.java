package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwDcEarthingSwitchMapper;
import com.example.bdz.pojo.GwDcEarthingSwitch;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwDcEarthingSwitchService;
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
public class GwDcEarthingSwitchServiceImpl extends ServiceImpl<GwDcEarthingSwitchMapper, GwDcEarthingSwitch> implements GwDcEarthingSwitchService {

    @Override
    public Result getDcesList(Long id) {
        List<GwDcEarthingSwitch> gwDcEarthingSwitches = list(new QueryWrapper<GwDcEarthingSwitch>());
        return Result.success(gwDcEarthingSwitches);
    }

    @Override
    public Result info(Long id) {
        GwDcEarthingSwitch gwDcEarthingSwitch = getById(id);
        org.springframework.util.Assert.notNull(gwDcEarthingSwitch,"找不到该设备");
        return Result.success(gwDcEarthingSwitch);
    }
}
