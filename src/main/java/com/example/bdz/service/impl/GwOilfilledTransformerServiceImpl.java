package com.example.bdz.service.impl;

import cn.hutool.core.lang.Assert;
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
import org.springframework.transaction.annotation.Transactional;

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
    public GwOilfilledTransformer getByOftId(Long id) {
        return getOne(new QueryWrapper<GwOilfilledTransformer>().eq("id",id));
    }

    @Override
    public Result info(Long id) {
        GwOilfilledTransformer gwOilfilledTransformer = getById(id);
        org.springframework.util.Assert.notNull(gwOilfilledTransformer,"找不到该设备");
        return Result.success(gwOilfilledTransformer);
    }

    @Override
    public Result getOftList(Long id) {
        List<GwOilfilledTransformer> gwOilfilledTransformers = list(new QueryWrapper<GwOilfilledTransformer>());
        return Result.success(gwOilfilledTransformers);
    }


    @Override
    @Transactional    //加入 @Transactional 注解，使用默认配置，抛出异常之后，事务会自动回滚，数据不会插入到数据库
    //添加设备 添加设备时要使得类别<model>表里面的amount加一
    public Result addOft(GwOilfilledTransformer gwOilfilledTransformer) {

        save(gwOilfilledTransformer);
        //修改并更新一下model表
        GwModel gwModel=gwModelService.getById(gwOilfilledTransformer.getModelId());
        //添加一条设备数据后对应类别的总数加一
        gwModel.setAmount(gwModel.getAmount()+1);
        gwModelService.updateById(gwModel);
        return Result.success(gwOilfilledTransformer);
    }

    //根据设备名<equip_id>查询设备
    private GwOilfilledTransformer getByOftName(String equipId) {
        return getOne(new QueryWrapper<GwOilfilledTransformer>().eq("equip_id",equipId));
    }


    @Override
    //更新某一个id的设备
    public Result updateOft(Long id, GwOilfilledTransformer gwOilfilledTransformer) {
          //传入要修改的id与修改的信息
          GwOilfilledTransformer preGwOft = getById(id);
          Assert.notNull(preGwOft,"找不到该资产");
          //不为空则继续执行

          gwOilfilledTransformer.setEquipId(id);
          updateById(gwOilfilledTransformer);
          return Result.success(gwOilfilledTransformer);
    }

    @Override
    @Transactional
    //删除 删除同时还要类别表里面设置总数减一
    public Result deleteOft(Long id) {
        GwOilfilledTransformer gwOilfilledTransformer = getById(id);
        org.springframework.util.Assert.notNull(gwOilfilledTransformer,"该设备不存在");
        removeById(gwOilfilledTransformer);
        GwModel gwModel=gwModelService.getById(gwOilfilledTransformer.getModelId());
        //添加一条设备数据后对应类别的总数加一
        gwModel.setAmount(gwModel.getAmount()-1);
        gwModelService.updateById(gwModel);
        return Result.success(null);

    }


}





