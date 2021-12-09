package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwHighVoltageShuntReactorMapper;
import com.example.bdz.pojo.GwHighVoltageShuntReactor;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwHighVoltageShuntReactorService;
import com.example.bdz.service.GwModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-11-27
 */
@Service
public class GwHighVoltageShuntReactorServiceImpl extends ServiceImpl<GwHighVoltageShuntReactorMapper, GwHighVoltageShuntReactor> implements GwHighVoltageShuntReactorService {

    @Autowired
    GwModelService gwModelService;

    @Override
    public Result getHvsrList(Long id) {
        List<GwHighVoltageShuntReactor> gwHighVoltageShuntReactors = list(new QueryWrapper<GwHighVoltageShuntReactor>());
        return Result.success(gwHighVoltageShuntReactors);
    }

    @Override
    public Result info(Long id) {
        GwHighVoltageShuntReactor gwHighVoltageShuntReactor = getById(id);
        org.springframework.util.Assert.notNull(gwHighVoltageShuntReactor,"找不到该设备");
        return Result.success(gwHighVoltageShuntReactor);
    }
}
