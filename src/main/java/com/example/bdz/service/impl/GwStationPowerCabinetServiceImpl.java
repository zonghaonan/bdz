package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwStationPowerCabinetMapper;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.pojo.GwStationPowerCabinet;
import com.example.bdz.service.GwStationPowerCabinetService;
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
public class GwStationPowerCabinetServiceImpl extends ServiceImpl<GwStationPowerCabinetMapper, GwStationPowerCabinet> implements GwStationPowerCabinetService {

    @Override
    public Result getSpcList(Long id) {
        List<GwStationPowerCabinet> gwStationPowerCabinets = list(new QueryWrapper<GwStationPowerCabinet>());
        return Result.success(gwStationPowerCabinets);
    }

    @Override
    public Result info(Long id) {
        GwStationPowerCabinet gwStationPowerCabinet = getById(id);
        org.springframework.util.Assert.notNull(gwStationPowerCabinet,"找不到该设备");
        return Result.success(gwStationPowerCabinet);
    }
}
