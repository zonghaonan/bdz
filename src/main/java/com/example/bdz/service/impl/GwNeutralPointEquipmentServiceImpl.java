package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwNeutralPointEquipmentMapper;
import com.example.bdz.pojo.GwNeutralPointEquipment;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwNeutralPointEquipmentService;
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
public class GwNeutralPointEquipmentServiceImpl extends ServiceImpl<GwNeutralPointEquipmentMapper, GwNeutralPointEquipment> implements GwNeutralPointEquipmentService {

    @Override
    public Result getNpeList(Long id) {
        List<GwNeutralPointEquipment> gwNeutralPointEquipments = list(new QueryWrapper<GwNeutralPointEquipment>());
        return Result.success(gwNeutralPointEquipments);
    }

    @Override
    public Result info(Long id) {
        GwNeutralPointEquipment gwNeutralPointEquipment = getById(id);
        org.springframework.util.Assert.notNull(gwNeutralPointEquipment,"找不到该设备");
        return Result.success(gwNeutralPointEquipment);
    }
}
