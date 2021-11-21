package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwOilfilledTransformerMapper;
import com.example.bdz.pojo.GwModel;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwModelService;
import com.example.bdz.service.GwOilfilledTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-11-19
 */
@Service
public class GwOilfilledTransformerServiceImpl extends ServiceImpl<GwOilfilledTransformerMapper, GwOilfilledTransformer> implements GwOilfilledTransformerService {

    @Autowired
    GwModelService gwModelService;
    @Override
    public GwModel getByOftName(String modelName) {
        return null;
    }

    @Override
    public Result info(Long id) {
        return null;
    }

    @Override
    public Result getModelList(Long id) {
        List<GwOilfilledTransformer> gwOilfilledTransformers= list(new QueryWrapper<GwOilfilledTransformer>());
        return Result.success(gwOilfilledTransformers);
    }

    @Override
    public Result addOft(GwOilfilledTransformer gwOilfilledTransformer) {
        return null;
    }

    @Override
    //这里要该两张表 一张是本类别的数据表 另一张是存放所有设备的表
    public Result updateOft(Long id, GwOilfilledTransformer gwOilfilledTransformer) {
        return null;
    }
}
