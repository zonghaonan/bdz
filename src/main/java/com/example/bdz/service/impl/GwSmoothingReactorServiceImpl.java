package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwSmoothingReactor;
import com.example.bdz.mapper.GwSmoothingReactorMapper;
import com.example.bdz.service.GwSmoothingReactorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class GwSmoothingReactorServiceImpl extends ServiceImpl<GwSmoothingReactorMapper, GwSmoothingReactor> implements GwSmoothingReactorService {

    @Override
    public Result getSrList(Long id) {
        List<GwSmoothingReactor> gwSmoothingReactors = list(new QueryWrapper<GwSmoothingReactor>());
        return Result.success(gwSmoothingReactors);
    }
}
