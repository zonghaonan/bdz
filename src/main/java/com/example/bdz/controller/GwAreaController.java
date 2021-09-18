package com.example.bdz.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwArea;
import com.example.bdz.pojo.GwEquip;
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
    @ApiOperation("根据id获取区域信息接口")
    @PreAuthorize("hasAuthority('gw:area:list')")
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        return gwAreaService.info(id);
    }
    @ApiOperation("获取区域列表接口")
    @PreAuthorize("hasAuthority('gw:area:list')")
    @GetMapping("/list")
    public Result list(String name){
        return gwAreaService.getAreaList(name);
    }
    @ApiOperation("添加区域接口")
    @PreAuthorize("hasAuthority('gw:area:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwArea gwArea){
        return gwAreaService.addArea(gwArea);
    }
    @ApiOperation("更新区域接口")
    @PreAuthorize("hasAuthority('gw:area:update')")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer id,@Validated @RequestBody GwArea gwArea){
        return gwAreaService.updateArea(id,gwArea);
    }
    @ApiOperation("删除区域接口")
    @PreAuthorize("hasAuthority('gw:area:delete')")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        return gwAreaService.deleteArea(id);
    }
}

