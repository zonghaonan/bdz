package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwCombinedElectricalApparatusGisMapper;
import com.example.bdz.pojo.GwCombinedElectricalApparatusGis;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwCombinedElectricalApparatusGisService;
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
public class GwCombinedElectricalApparatusGisServiceImpl extends ServiceImpl<GwCombinedElectricalApparatusGisMapper, GwCombinedElectricalApparatusGis> implements GwCombinedElectricalApparatusGisService {


    @Override
    public Result getGisList(Long id) {
        List<GwCombinedElectricalApparatusGis> gwCombinedElectricalApparatusGiss = list(new QueryWrapper<GwCombinedElectricalApparatusGis>());
        return Result.success(gwCombinedElectricalApparatusGiss);
    }

    @Override
    public Result info(Long id) {
        GwCombinedElectricalApparatusGis gwCombinedElectricalApparatusGis = getById(id);
        org.springframework.util.Assert.notNull(gwCombinedElectricalApparatusGis,"找不到该设备");
        return Result.success(gwCombinedElectricalApparatusGis);
    }
}
