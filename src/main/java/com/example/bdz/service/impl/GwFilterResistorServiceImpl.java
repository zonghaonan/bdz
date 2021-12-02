package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwFilterResistorMapper;
import com.example.bdz.pojo.GwFilterResistor;
import com.example.bdz.service.GwFilterResistorService;
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
public class GwFilterResistorServiceImpl extends ServiceImpl<GwFilterResistorMapper, GwFilterResistor> implements GwFilterResistorService {

    @Override
    public Result getFresList(Long id) {
        List<GwFilterResistor> gwFilterResistors = list(new QueryWrapper<GwFilterResistor>());
        return Result.success(gwFilterResistors);
    }
}
