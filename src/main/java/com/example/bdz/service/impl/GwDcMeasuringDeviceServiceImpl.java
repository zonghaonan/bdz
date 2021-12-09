package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwDcMeasuringDeviceMapper;
import com.example.bdz.pojo.GwDcMeasuringDevice;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwDcMeasuringDeviceService;
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
public class GwDcMeasuringDeviceServiceImpl extends ServiceImpl<GwDcMeasuringDeviceMapper, GwDcMeasuringDevice> implements GwDcMeasuringDeviceService {

    @Override
    public Result getDcmdList(Long id) {
        List<GwDcMeasuringDevice> gwDcMeasuringDevices = list(new QueryWrapper<GwDcMeasuringDevice>());
        return Result.success(gwDcMeasuringDevices);
    }

    @Override
    public Result info(Long id) {
        GwDcMeasuringDevice gwDcMeasuringDevice = getById(id);
        org.springframework.util.Assert.notNull(gwDcMeasuringDevice,"找不到该设备");
        return Result.success(gwDcMeasuringDevice);
    }
}
