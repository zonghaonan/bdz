package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwSvcReactivePowerCompensationDeviceMapper;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.pojo.GwSvcReactivePowerCompensationDevice;
import com.example.bdz.service.GwSvcReactivePowerCompensationDeviceService;
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
public class GwSvcReactivePowerCompensationDeviceServiceImpl extends ServiceImpl<GwSvcReactivePowerCompensationDeviceMapper, GwSvcReactivePowerCompensationDevice> implements GwSvcReactivePowerCompensationDeviceService {

    @Override
    public Result getSvcList(Long id) {
        List<GwSvcReactivePowerCompensationDevice> gwSvcReactivePowerCompensationDevices = list(new QueryWrapper<GwSvcReactivePowerCompensationDevice>());
        return Result.success(gwSvcReactivePowerCompensationDevices);
    }

    @Override
    public Result info(Long id) {
        GwSvcReactivePowerCompensationDevice gwSvcReactivePowerCompensationDevice = getById(id);
        org.springframework.util.Assert.notNull(gwSvcReactivePowerCompensationDevice,"找不到该设备");
        return Result.success(gwSvcReactivePowerCompensationDevice);
    }
}
