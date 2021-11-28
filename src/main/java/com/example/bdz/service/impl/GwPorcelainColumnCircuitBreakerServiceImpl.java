package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwPorcelainColumnCircuitBreakerMapper;
import com.example.bdz.pojo.GwPorcelainColumnCircuitBreaker;
import com.example.bdz.service.GwPorcelainColumnCircuitBreakerService;
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
public class GwPorcelainColumnCircuitBreakerServiceImpl extends ServiceImpl<GwPorcelainColumnCircuitBreakerMapper, GwPorcelainColumnCircuitBreaker> implements GwPorcelainColumnCircuitBreakerService {

    @Override
    public Result getPccbList(Long id) {
        List<GwPorcelainColumnCircuitBreaker> gwPorcelainColumnCircuitBreakers = list(new QueryWrapper<GwPorcelainColumnCircuitBreaker>());
        return Result.success(gwPorcelainColumnCircuitBreakers);
    }
}
