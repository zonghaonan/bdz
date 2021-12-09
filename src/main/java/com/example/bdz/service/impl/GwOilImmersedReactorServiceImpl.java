package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwOilImmersedReactorMapper;
import com.example.bdz.pojo.GwOilImmersedReactor;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwOilImmersedReactorService;
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
public class GwOilImmersedReactorServiceImpl extends ServiceImpl<GwOilImmersedReactorMapper, GwOilImmersedReactor> implements GwOilImmersedReactorService {

    @Override
    public Result getOirList(Long id) {
        List<GwOilImmersedReactor> gwOilImmersedReactors = list(new QueryWrapper<GwOilImmersedReactor>());
        return Result.success(gwOilImmersedReactors);
    }

    @Override
    public Result info(Long id) {
        GwOilImmersedReactor gwOilImmersedReactor = getById(id);
        org.springframework.util.Assert.notNull(gwOilImmersedReactor,"找不到该设备");
        return Result.success(gwOilImmersedReactor);
    }
}
