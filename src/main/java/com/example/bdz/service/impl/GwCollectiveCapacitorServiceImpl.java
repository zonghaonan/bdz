package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwCollectiveCapacitorMapper;
import com.example.bdz.pojo.GwCollectiveCapacitor;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwCollectiveCapacitorService;
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
public class GwCollectiveCapacitorServiceImpl extends ServiceImpl<GwCollectiveCapacitorMapper, GwCollectiveCapacitor> implements GwCollectiveCapacitorService {

    @Override
    public Result getCcList(Long id) {
        List<GwCollectiveCapacitor> gwCollectiveCapacitors = list(new QueryWrapper<GwCollectiveCapacitor>());
        return Result.success(gwCollectiveCapacitors);
    }
    @Override
    public Result info(Long id) {
        GwCollectiveCapacitor gwCollectiveCapacitor = getById(id);
        org.springframework.util.Assert.notNull(gwCollectiveCapacitor,"找不到该设备");
        return Result.success(gwCollectiveCapacitor);
    }
}
