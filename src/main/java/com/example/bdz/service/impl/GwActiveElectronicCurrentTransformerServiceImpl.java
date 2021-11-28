package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwActiveElectronicCurrentTransformerMapper;
import com.example.bdz.pojo.GwActiveElectronicCurrentTransformer;
import com.example.bdz.service.GwActiveElectronicCurrentTransformerService;
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
public class GwActiveElectronicCurrentTransformerServiceImpl extends ServiceImpl<GwActiveElectronicCurrentTransformerMapper, GwActiveElectronicCurrentTransformer> implements GwActiveElectronicCurrentTransformerService {

    @Override
    public Result getAectList(Long id) {
        List<GwActiveElectronicCurrentTransformer> gwActiveElectronicCurrentTransformers = list(new QueryWrapper<GwActiveElectronicCurrentTransformer>());
        return Result.success(gwActiveElectronicCurrentTransformers);
    }
}
