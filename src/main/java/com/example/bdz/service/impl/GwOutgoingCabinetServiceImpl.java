package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwOutgoingCabinetMapper;
import com.example.bdz.pojo.GwOutgoingCabinet;
import com.example.bdz.service.GwOutgoingCabinetService;
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
public class GwOutgoingCabinetServiceImpl extends ServiceImpl<GwOutgoingCabinetMapper, GwOutgoingCabinet> implements GwOutgoingCabinetService {

    @Override
    public Result getOcList(Long id) {
        List<GwOutgoingCabinet> gwOutgoingCabinets = list(new QueryWrapper<GwOutgoingCabinet>());
        return Result.success(gwOutgoingCabinets);
    }
}
