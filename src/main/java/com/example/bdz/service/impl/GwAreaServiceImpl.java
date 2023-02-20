package com.example.bdz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwArea;
import com.example.bdz.mapper.GwAreaMapper;
import com.example.bdz.pojo.GwEquip;
import com.example.bdz.service.GwAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.service.GwEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-09
 */
@Service
public class GwAreaServiceImpl extends ServiceImpl<GwAreaMapper, GwArea> implements GwAreaService {

    @Autowired
    GwAreaMapper gwAreaMapper;
    @Autowired
    GwEquipService gwEquipService;
    @Override
    public GwArea getByAreaName(String areaName) {
        return getOne((new QueryWrapper<GwArea>().eq("area_name",areaName)));
    }

    //根据id获取区域信息
    @Override
    public Result info(Integer id) {
        GwArea gwArea = getById(id);
        Assert.notNull(gwArea,"找不到该区域");
        gwArea.setEquipCount(gwEquipService.count(new QueryWrapper<GwEquip>().eq("area_id",id)));
        return Result.success(gwArea);
    }

    //获取区域列表
    @Override
    public Result getAreaList(String name) {
        List<GwArea> gwAreas=list(new QueryWrapper<GwArea>().like(StrUtil.isNotBlank(name),"area_name",name));
        for (GwArea gwArea : gwAreas) {
            gwArea.setEquipCount(gwEquipService.count(new QueryWrapper<GwEquip>().eq("area_id",gwArea.getId())));
        }
        return Result.success(gwAreas);
    }

    //添加区域
    @Override
    public Result addArea(GwArea gwArea) {
        GwArea ga=getByAreaName(gwArea.getAreaName());
        if(ga!=null){
            return Result.fail("该区域已存在");
        }
        save(gwArea);
        return Result.success(gwArea);
    }

    //更新区域
    @Override
    public Result updateArea(Integer id, GwArea gwArea) {
        GwArea ga = getById(id);
        Assert.notNull(ga,"找不到该区域");
        gwArea.setId(id);
        if(ga.getAreaName().equals(gwArea.getAreaName())){
            return Result.success(gwArea);
        }
        GwArea ga1=getByAreaName(gwArea.getAreaName());
        if(ga1!=null){
            return Result.fail("该区域已存在");
        }
        updateById(gwArea);
        return Result.success(gwArea);
    }

    //删除区域
    @Override
    @Transactional
    public Result deleteArea(Integer id) {
        GwArea gwArea = getById(id);
        Assert.notNull(gwArea,"该区域不存在");
        int count = gwEquipService.count(new QueryWrapper<GwEquip>().eq("area_id", id));
        if(count>0){
            return Result.fail("该区域存在资产");
        }
        removeById(id);
        return Result.success(null);
    }


}
