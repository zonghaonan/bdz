package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwFilterReactorMapper;
import com.example.bdz.pojo.GwFilterReactor;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwFilterReactorService;
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
public class GwFilterReactorServiceImpl extends ServiceImpl<GwFilterReactorMapper, GwFilterReactor> implements GwFilterReactorService {

    @Override
    public Result getFrList(Long id) {
        List<GwFilterReactor> gwFilterReactors = list(new QueryWrapper<GwFilterReactor>());
        return Result.success(gwFilterReactors);
    }

    @Override
    public Result info(Long id) {
        GwFilterReactor gwFilterReactor = getById(id);
        org.springframework.util.Assert.notNull(gwFilterReactor,"找不到该设备");
        return Result.success(gwFilterReactor);
    }
}
