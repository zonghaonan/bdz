package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwDistributionBox;
import com.example.bdz.mapper.GwDistributionBoxMapper;
import com.example.bdz.service.GwDistributionBoxService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2022-08-29
 */
@Service
public class GwDistributionBoxServiceImpl extends ServiceImpl<GwDistributionBoxMapper, GwDistributionBox> implements GwDistributionBoxService {
    @Override
    public Result getDbList() {
        List<GwDistributionBox> gwFilterReactors = list(new QueryWrapper<GwDistributionBox>());
        return Result.success(gwFilterReactors);
    }

    @Override
    public Result info(Long id) {
        GwDistributionBox gwDistributionBox = getById(id);
        org.springframework.util.Assert.notNull(gwDistributionBox,"找不到该设备");
        return Result.success(gwDistributionBox);
    }
}
