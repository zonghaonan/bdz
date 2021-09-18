package com.example.bdz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwArea;
import com.example.bdz.pojo.GwEquip;
import com.example.bdz.pojo.GwType;
import com.example.bdz.mapper.GwTypeMapper;
import com.example.bdz.service.GwEquipService;
import com.example.bdz.service.GwTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-16
 */
@Service
public class GwTypeServiceImpl extends ServiceImpl<GwTypeMapper, GwType> implements GwTypeService {

    @Autowired
    GwEquipService gwEquipService;
    @Override
    public GwType getByTypeName(String typeName) {
        return getOne((new QueryWrapper<GwType>().eq("type_name",typeName)));
    }

    //根据id获取分类信息
    @Override
    public Result info(Integer id) {
        GwType gwType = getById(id);
        Assert.notNull(gwType,"找不到该分类");
        gwType.setEquipCount(gwEquipService.count(new QueryWrapper<GwEquip>().eq("type_id",id)));
        return Result.success(gwType);
    }

    //获取分类列表
    @Override
    public Result getTypeList(String name) {
        List<GwType> gwTypes=list(new QueryWrapper<GwType>().like(StrUtil.isNotBlank(name),"type_name",name));
        for (GwType gwType : gwTypes) {
            gwType.setEquipCount(gwEquipService.count(new QueryWrapper<GwEquip>().eq("type_id",gwType.getId())));
        }
        return Result.success(gwTypes);
    }

    //添加分类
    @Override
    public Result addType(GwType gwType) {
        GwType gt=getByTypeName(gwType.getTypeName());
        if(gt!=null){
            return Result.fail("该分类已存在");
        }
        save(gwType);
        return Result.success(gwType);
    }

    //更新分类
    @Override
    public Result updateType(Integer id, GwType gwType) {
        GwType gt = getById(id);
        Assert.notNull(gt,"找不到该分类");
        gwType.setId(id);
        if(gt.getTypeName().equals(gwType.getTypeName())){
            return Result.success(gwType);
        }
        GwType gt1=getByTypeName(gwType.getTypeName());
        if(gt1!=null){
            return Result.fail("该分类已存在");
        }
        updateById(gwType);
        return Result.success(gwType);
    }

    //删除分类
    @Override
    @Transactional
    public Result deleteType(Integer id) {
        GwType gwType = getById(id);
        Assert.notNull(gwType,"该分类不存在");
        int count = gwEquipService.count(new QueryWrapper<GwEquip>().eq("type_id", id));
        if(count>0){
            return Result.fail("该分类存在资产");
        }
        removeById(id);
        return Result.success(null);
    }
}
