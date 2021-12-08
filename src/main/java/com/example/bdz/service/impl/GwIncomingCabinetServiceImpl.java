package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwIncomingCabinetMapper;
import com.example.bdz.pojo.GwIncomingCabinet;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwIncomingCabinetService;
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
public class GwIncomingCabinetServiceImpl extends ServiceImpl<GwIncomingCabinetMapper, GwIncomingCabinet> implements GwIncomingCabinetService {

    @Override
    public Result getIcList(Long id) {
        List<GwIncomingCabinet> gwIncomingCabinets = list(new QueryWrapper<GwIncomingCabinet>());
        return Result.success(gwIncomingCabinets);
    }

    @Override
    public Result info(Long id) {
        GwIncomingCabinet gwIncomingCabinet = getById(id);
        org.springframework.util.Assert.notNull(gwIncomingCabinet,"找不到该设备");
        return Result.success(gwIncomingCabinet);
    }
}
