package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwFrameCapacitorMapper;
import com.example.bdz.pojo.GwFrameCapacitor;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwFrameCapacitorService;
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
public class GwFrameCapacitorServiceImpl extends ServiceImpl<GwFrameCapacitorMapper, GwFrameCapacitor> implements GwFrameCapacitorService {

    @Override
    public Result getFcList(Long id) {
        List<GwFrameCapacitor> gwFrameCapacitors = list(new QueryWrapper<GwFrameCapacitor>());
        return Result.success(gwFrameCapacitors);
    }

    @Override
    public Result info(Long id) {
        GwFrameCapacitor gwFrameCapacitor = getById(id);
        org.springframework.util.Assert.notNull(gwFrameCapacitor,"找不到该设备");
        return Result.success(gwFrameCapacitor);
    }
}
