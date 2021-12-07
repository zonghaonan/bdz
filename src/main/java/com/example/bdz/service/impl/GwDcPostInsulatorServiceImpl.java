package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwDcPostInsulatorMapper;
import com.example.bdz.pojo.GwDcPostInsulator;
import com.example.bdz.pojo.GwDrytypeTransformer;
import com.example.bdz.service.GwDcPostInsulatorService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
public class GwDcPostInsulatorServiceImpl extends ServiceImpl<GwDcPostInsulatorMapper, GwDcPostInsulator> implements GwDcPostInsulatorService {

    @Override
    public Result getDcpiList() {
        List<GwDcPostInsulator> gwDcPostInsulators = list(new QueryWrapper<GwDcPostInsulator>());
        return Result.success(gwDcPostInsulators);
    }

    @Override
    public Result info(Long id) {
        GwDcPostInsulator gwDcPostInsulator = getById(id);
        Assert.notNull(gwDcPostInsulator,"找不到该设备");
        return Result.success(gwDcPostInsulator);
    }
}
