package com.example.bdz.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwArea;
import com.example.bdz.service.GwAreaService;
import com.example.bdz.service.GwEquipService;
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
 * @since 2021-09-09
 */
@RestController
@RequestMapping("/gw/area")
public class GwAreaController extends BaseController {

    @Autowired
    GwAreaService gwAreaService;
    @Autowired
    GwEquipService gwEquipService;
    @ApiOperation("根据id获取区域信息接口")
    @PreAuthorize("hasAuthority('gw:area')")
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        GwArea gwArea = gwAreaService.getById(id);
        Assert.notNull(gwArea,"找不到该区域");
        return Result.success(gwArea);
    }
    @ApiOperation("获取区域列表接口")
    @PreAuthorize("hasAuthority('gw:area')")
    @GetMapping("/list")
    public Result list(String name){
        List<GwArea> gwAreas=gwAreaService.list(new QueryWrapper<GwArea>().like(StrUtil.isNotBlank(name),"area_name",name));
        return Result.success(gwAreas);
    }
    @ApiOperation("添加区域接口")
    @PreAuthorize("hasAuthority('gw:area:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwArea gwArea){
        gwAreaService.save(gwArea);
        gwArea.setEquipCount(0);
        gwArea.setEquipAllCount(0);
        return Result.success(gwArea);
    }
    @ApiOperation("更新区域接口")
    @PreAuthorize("hasAuthority('gw:area:update')")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer id,@Validated @RequestBody GwArea gwArea){
        GwArea ga = gwAreaService.getById(id);
        Assert.notNull(ga,"找不到该区域");
        gwArea.setId(id);
        gwAreaService.updateById(gwArea);
        gwArea.setEquipCount(ga.getEquipCount());
        gwArea.setEquipAllCount(ga.getEquipAllCount());
        return Result.success(gwArea);
    }
    @ApiOperation("删除区域接口")
    @PreAuthorize("hasAuthority('gw:area:delete')")
    @DeleteMapping("/delete/{id}")
    @Transactional
    public Result delete(@PathVariable("id") Integer id){
        GwArea gwArea = gwAreaService.getById(id);
        Assert.notNull(gwArea,"该区域不存在");
        if(gwArea.getEquipCount()>0){
            return Result.fail("该区域存在资产");
        }
        gwAreaService.removeById(id);
        return Result.success(null);
    }
}

