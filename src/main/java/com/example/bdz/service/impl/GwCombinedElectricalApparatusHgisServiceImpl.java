package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwCombinedElectricalApparatusHgisMapper;
import com.example.bdz.pojo.GwCombinedElectricalApparatusHgis;
import com.example.bdz.service.GwCombinedElectricalApparatusHgisService;
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
public class GwCombinedElectricalApparatusHgisServiceImpl extends ServiceImpl<GwCombinedElectricalApparatusHgisMapper, GwCombinedElectricalApparatusHgis> implements GwCombinedElectricalApparatusHgisService {

    @Override
    public Result getHgisList(Long id) {
        List<GwCombinedElectricalApparatusHgis> gwCombinedElectricalApparatusHgiss = list(new QueryWrapper<GwCombinedElectricalApparatusHgis>());
        return Result.success(gwCombinedElectricalApparatusHgiss);
    }
}
