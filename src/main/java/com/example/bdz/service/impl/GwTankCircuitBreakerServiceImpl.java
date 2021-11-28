package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwTankCircuitBreakerMapper;
import com.example.bdz.pojo.GwTankCircuitBreaker;
import com.example.bdz.service.GwTankCircuitBreakerService;
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
public class GwTankCircuitBreakerServiceImpl extends ServiceImpl<GwTankCircuitBreakerMapper, GwTankCircuitBreaker> implements GwTankCircuitBreakerService {

    @Override
    public Result getTcbList(Long id) {
        List<GwTankCircuitBreaker> gwTankCircuitBreakers = list(new QueryWrapper<GwTankCircuitBreaker>());
        return Result.success(gwTankCircuitBreakers);
    }
}
