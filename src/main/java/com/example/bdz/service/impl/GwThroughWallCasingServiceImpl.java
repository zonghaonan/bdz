package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwThroughWallCasingMapper;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.pojo.GwThroughWallCasing;
import com.example.bdz.service.GwThroughWallCasingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-12-01
 */
@Service
public class GwThroughWallCasingServiceImpl extends ServiceImpl<GwThroughWallCasingMapper, GwThroughWallCasing> implements GwThroughWallCasingService {

    @Override
    public Result getTwcList(Long id) {
        List<GwThroughWallCasing> gwThroughWallCasings = list(new QueryWrapper<GwThroughWallCasing>());
        return Result.success(gwThroughWallCasings);
    }

    @Override
    public Result info(Long id) {
        GwThroughWallCasing gwThroughWallCasing = getById(id);
        org.springframework.util.Assert.notNull(gwThroughWallCasing,"找不到该设备");
        return Result.success(gwThroughWallCasing);
    }
}
