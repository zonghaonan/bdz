package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwDcWallBushingMapper;
import com.example.bdz.pojo.GwDcWallBushing;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwDcWallBushingService;
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
public class GwDcWallBushingServiceImpl extends ServiceImpl<GwDcWallBushingMapper, GwDcWallBushing> implements GwDcWallBushingService {

    @Override
    public Result getDcwbList(Long id) {
        List<GwDcWallBushing> gwDcWallBushings = list(new QueryWrapper<GwDcWallBushing>());
        return Result.success(gwDcWallBushings);
    }

    @Override
    public Result info(Long id) {
        GwDcWallBushing gwDcWallBushing = getById(id);
        org.springframework.util.Assert.notNull(gwDcWallBushing,"找不到该设备");
        return Result.success(gwDcWallBushing);
    }
}
