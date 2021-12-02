package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwPoleBusArresterInValveHallMapper;
import com.example.bdz.pojo.GwPoleBusArresterInValveHall;
import com.example.bdz.service.GwPoleBusArresterInValveHallService;
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
public class GwPoleBusArresterInValveHallServiceImpl extends ServiceImpl<GwPoleBusArresterInValveHallMapper, GwPoleBusArresterInValveHall> implements GwPoleBusArresterInValveHallService {

    @Override
    public Result getPbaList(Long id) {
        List<GwPoleBusArresterInValveHall> gwPoleBusArresterInValveHalls = list(new QueryWrapper<GwPoleBusArresterInValveHall>());
        return Result.success(gwPoleBusArresterInValveHalls);
    }
}
