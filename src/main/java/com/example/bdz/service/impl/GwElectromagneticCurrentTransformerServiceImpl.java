package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwElectromagneticCurrentTransformerMapper;
import com.example.bdz.pojo.GwElectromagneticCurrentTransformer;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwElectromagneticCurrentTransformerService;
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
public class GwElectromagneticCurrentTransformerServiceImpl extends ServiceImpl<GwElectromagneticCurrentTransformerMapper, GwElectromagneticCurrentTransformer> implements GwElectromagneticCurrentTransformerService {

    @Override
    public Result getEctList(Long id) {
        List<GwElectromagneticCurrentTransformer> gwElectromagneticCurrentTransformers = list(new QueryWrapper<GwElectromagneticCurrentTransformer>());
        return Result.success(gwElectromagneticCurrentTransformers);
    }

    @Override
    public Result info(Long id) {
        GwElectromagneticCurrentTransformer gwElectromagneticCurrentTransformer = getById(id);
        org.springframework.util.Assert.notNull(gwElectromagneticCurrentTransformer,"找不到该设备");
        return Result.success(gwElectromagneticCurrentTransformer);
    }
}
