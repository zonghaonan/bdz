package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwVoltageTransformerMapper;
import com.example.bdz.pojo.GwVoltageTransformer;
import com.example.bdz.service.GwVoltageTransformerService;
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
public class GwVoltageTransformerServiceImpl extends ServiceImpl<GwVoltageTransformerMapper, GwVoltageTransformer> implements GwVoltageTransformerService {

    @Override
    public Result getVtList(Long id) {
        List<GwVoltageTransformer> gwVoltageTransformers = list(new QueryWrapper<GwVoltageTransformer>());
        return Result.success(gwVoltageTransformers);
    }
}
