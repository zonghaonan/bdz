package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwZeroFluxCurrentTransformerMapper;
import com.example.bdz.pojo.GwZeroFluxCurrentTransformer;
import com.example.bdz.service.GwZeroFluxCurrentTransformerService;
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
public class GwZeroFluxCurrentTransformerServiceImpl extends ServiceImpl<GwZeroFluxCurrentTransformerMapper, GwZeroFluxCurrentTransformer> implements GwZeroFluxCurrentTransformerService {

    @Override
    public Result getZfctList(Long id) {
        List<GwZeroFluxCurrentTransformer> gwZeroFluxCurrentTransformers = list(new QueryWrapper<GwZeroFluxCurrentTransformer>());
        return Result.success(gwZeroFluxCurrentTransformers);
    }
}
