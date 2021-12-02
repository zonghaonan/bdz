package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwDcTransferSwitchMapper;
import com.example.bdz.pojo.GwDcTransferSwitch;
import com.example.bdz.service.GwDcTransferSwitchService;
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
public class GwDcTransferSwitchServiceImpl extends ServiceImpl<GwDcTransferSwitchMapper, GwDcTransferSwitch> implements GwDcTransferSwitchService {

    @Override
    public Result getDctsList(Long id) {
        List<GwDcTransferSwitch> gwDcTransferSwitches = list(new QueryWrapper<GwDcTransferSwitch>());
        return Result.success(gwDcTransferSwitches);
    }
}
