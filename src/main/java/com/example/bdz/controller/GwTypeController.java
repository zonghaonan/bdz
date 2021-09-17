package com.example.bdz.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwArea;
import com.example.bdz.pojo.GwEquip;
import com.example.bdz.pojo.GwType;
import com.example.bdz.service.GwAreaService;
import com.example.bdz.service.GwEquipService;
import com.example.bdz.service.GwTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhn
 * @since 2021-09-16
 */
@RestController
@RequestMapping("/gw/type")
public class GwTypeController {
    @Autowired
    GwTypeService gwTypeService;
    @Autowired
    GwEquipService gwEquipService;
    @ApiOperation("根据id获取分类信息接口")
    @PreAuthorize("hasAuthority('gw:type:list')")
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        GwType gwType = gwTypeService.getById(id);
        Assert.notNull(gwType,"找不到该分类");
        gwType.setEquipCount(gwEquipService.count(new QueryWrapper<GwEquip>().eq("type_id",id)));
        return Result.success(gwType);
    }
    @ApiOperation("获取分类列表接口")
    @PreAuthorize("hasAuthority('gw:type:list')")
    @GetMapping("/list")
    public Result list(String name){
        List<GwType> gwTypes=gwTypeService.list(new QueryWrapper<GwType>().like(StrUtil.isNotBlank(name),"type_name",name));
        for (GwType gwType : gwTypes) {
            gwType.setEquipCount(gwEquipService.count(new QueryWrapper<GwEquip>().eq("type_id",gwType.getId())));
        }
        return Result.success(gwTypes);
    }
    @ApiOperation("添加分类接口")
    @PreAuthorize("hasAuthority('gw:type:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwType gwType){
        GwType gt=gwTypeService.getByTypeName(gwType.getTypeName());
        if(gt!=null){
            return Result.fail("该分类已存在");
        }
        gwTypeService.save(gwType);
        return Result.success(gwType);
    }
    @ApiOperation("更新分类接口")
    @PreAuthorize("hasAuthority('gw:type:update')")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer id,@Validated @RequestBody GwType gwType){
        GwType gt = gwTypeService.getById(id);
        Assert.notNull(gt,"找不到该分类");
        gwType.setId(id);
        if(gt.getTypeName().equals(gwType.getTypeName())){
            return Result.success(gwType);
        }
        GwType gt1=gwTypeService.getByTypeName(gwType.getTypeName());
        if(gt1!=null){
            return Result.fail("该分类已存在");
        }
        gwTypeService.updateById(gwType);
        return Result.success(gwType);
    }
    @ApiOperation("删除分类接口")
    @PreAuthorize("hasAuthority('gw:type:delete')")
    @PostMapping("/delete/{id}")
    @Transactional
    public Result delete(@PathVariable("id") Integer id){
        GwType gwType = gwTypeService.getById(id);
        Assert.notNull(gwType,"该分类不存在");
        int count = gwEquipService.count(new QueryWrapper<GwEquip>().eq("type_id", id));
        if(count>0){
            return Result.fail("该分类存在资产");
        }
        gwTypeService.removeById(id);
        return Result.success(null);
    }
}

