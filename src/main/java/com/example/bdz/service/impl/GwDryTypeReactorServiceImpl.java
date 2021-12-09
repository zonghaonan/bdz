package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwDryTypeReactorMapper;
import com.example.bdz.pojo.GwDryTypeReactor;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwDryTypeReactorService;
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
public class GwDryTypeReactorServiceImpl extends ServiceImpl<GwDryTypeReactorMapper, GwDryTypeReactor> implements GwDryTypeReactorService {

    @Override
    public Result getDtrList(Long id) {
        List<GwDryTypeReactor> gwDryTypeReactors = list(new QueryWrapper<GwDryTypeReactor>());
        return Result.success(gwDryTypeReactors);
    }

    @Override
    public Result info(Long id) {
        GwDryTypeReactor gwDryTypeReactor = getById(id);
        org.springframework.util.Assert.notNull(gwDryTypeReactor,"找不到该设备");
        return Result.success(gwDryTypeReactor);
    }
}
