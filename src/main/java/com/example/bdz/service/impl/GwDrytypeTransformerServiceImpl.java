package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwDrytypeTransformerMapper;
import com.example.bdz.pojo.GwDrytypeTransformer;
import com.example.bdz.service.GwDrytypeTransformerService;
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
public class GwDrytypeTransformerServiceImpl extends ServiceImpl<GwDrytypeTransformerMapper, GwDrytypeTransformer> implements GwDrytypeTransformerService {

    @Autowired
    GwModelService gwModelService;


    @Override
    public Result getDttList(Long id) {
        List<GwDrytypeTransformer> gwDrytypeTransformers = list(new QueryWrapper<GwDrytypeTransformer>());
        return Result.success(gwDrytypeTransformers);
    }
}
