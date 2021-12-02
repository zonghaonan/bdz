package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwConverterValveMapper;
import com.example.bdz.pojo.GwConverterValve;
import com.example.bdz.service.GwConverterValveService;
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
public class GwConverterValveServiceImpl extends ServiceImpl<GwConverterValveMapper, GwConverterValve> implements GwConverterValveService {

    @Override
    public Result getCvList(Long id) {
        List<GwConverterValve> gwConverterValves = list(new QueryWrapper<GwConverterValve>());
        return Result.success(gwConverterValves);
    }
}
