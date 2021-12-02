package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwCompleteAndSetgroundingTransformerMapper;
import com.example.bdz.pojo.GwCompleteAndSetgroundingTransformer;
import com.example.bdz.service.GwCompleteAndSetgroundingTransformerService;
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
public class GwCompleteAndSetgroundingTransformerServiceImpl extends ServiceImpl<GwCompleteAndSetgroundingTransformerMapper, GwCompleteAndSetgroundingTransformer> implements GwCompleteAndSetgroundingTransformerService {

    @Override
    public Result getCastList(Long id) {
        List<GwCompleteAndSetgroundingTransformer> gwCompleteAndSetgroundingTransformers = list(new QueryWrapper<GwCompleteAndSetgroundingTransformer>());
        return Result.success(gwCompleteAndSetgroundingTransformers);
    }
}
