package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.pojo.GwSeriesCompensationCapacitorCompleteSet;
import com.example.bdz.mapper.GwSeriesCompensationCapacitorCompleteSetMapper;
import com.example.bdz.service.GwSeriesCompensationCapacitorCompleteSetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class GwSeriesCompensationCapacitorCompleteSetServiceImpl extends ServiceImpl<GwSeriesCompensationCapacitorCompleteSetMapper, GwSeriesCompensationCapacitorCompleteSet> implements GwSeriesCompensationCapacitorCompleteSetService {

    @Override
    public Result getScccList(Long id) {
        List<GwSeriesCompensationCapacitorCompleteSet> gwSeriesCompensationCapacitorCompleteSets = list(new QueryWrapper<GwSeriesCompensationCapacitorCompleteSet>());
        return Result.success(gwSeriesCompensationCapacitorCompleteSets);
    }

    @Override
    public Result info(Long id) {
        GwSeriesCompensationCapacitorCompleteSet gwSeriesCompensationCapacitorCompleteSet = getById(id);
        org.springframework.util.Assert.notNull(gwSeriesCompensationCapacitorCompleteSet,"找不到该设备");
        return Result.success(gwSeriesCompensationCapacitorCompleteSet);
    }
}
