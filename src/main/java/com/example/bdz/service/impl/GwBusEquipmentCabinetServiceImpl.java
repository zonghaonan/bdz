package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwBusEquipmentCabinetMapper;
import com.example.bdz.pojo.GwBusEquipmentCabinet;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwBusEquipmentCabinetService;
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
public class GwBusEquipmentCabinetServiceImpl extends ServiceImpl<GwBusEquipmentCabinetMapper, GwBusEquipmentCabinet> implements GwBusEquipmentCabinetService {

    @Override
    public Result getBecList(Long id) {
        List<GwBusEquipmentCabinet> gwBusEquipmentCabinets = list(new QueryWrapper<GwBusEquipmentCabinet>());
        return Result.success(gwBusEquipmentCabinets);
    }
    @Override
    public Result info(Long id) {
        GwBusEquipmentCabinet gwBusEquipmentCabinet = getById(id);
        org.springframework.util.Assert.notNull(gwBusEquipmentCabinet,"找不到该设备");
        return Result.success(gwBusEquipmentCabinet);
    }
}
