package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwConverterTransformerMapper;
import com.example.bdz.pojo.GwConverterTransformer;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwConverterTransformerService;
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
public class GwConverterTransformerServiceImpl extends ServiceImpl<GwConverterTransformerMapper, GwConverterTransformer> implements GwConverterTransformerService {

    @Override
    public Result getCtList(Long id) {
        List<GwConverterTransformer> gwConverterTransformers = list(new QueryWrapper<GwConverterTransformer>());
        return Result.success(gwConverterTransformers);
    }

    @Override
    public Result info(Long id) {
        GwConverterTransformer gwConverterTransformer = getById(id);
        org.springframework.util.Assert.notNull(gwConverterTransformer,"找不到该设备");
        return Result.success(gwConverterTransformer);
    }
}
