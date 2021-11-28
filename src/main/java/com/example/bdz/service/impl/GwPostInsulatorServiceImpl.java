package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwPostInsulatorMapper;
import com.example.bdz.pojo.GwPostInsulator;
import com.example.bdz.service.GwPostInsulatorService;
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
public class GwPostInsulatorServiceImpl extends ServiceImpl<GwPostInsulatorMapper, GwPostInsulator> implements GwPostInsulatorService {

    @Override
    public Result getPiList(Long id) {
        List<GwPostInsulator> gwPostInsulators = list(new QueryWrapper<GwPostInsulator>());
        return Result.success(gwPostInsulators);
    }
}
