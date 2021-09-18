package com.example.bdz.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * @since 2021-09-06
 */
@RestController
@RequestMapping("gw/equip")
public class GwEquipController extends BaseController{

    @Autowired
    GwEquipService gwEquipService;
    @ApiOperation("根据id获取资产信息接口")
    @PreAuthorize("hasAuthority('gw:equip:list')")
    @GetMapping("/info/{equipId}")
    public Result info(@PathVariable("equipId") Long equipId){
        return gwEquipService.info(equipId);
    }
    @ApiOperation("获取资产列表接口")
    @PreAuthorize("hasAuthority('gw:equip:list')")
    @GetMapping("/list")
    public Result list(String equipName,int areaId,int typeId){
        return gwEquipService.getEquipList(equipName,areaId,typeId);
    }
    @ApiOperation("添加资产接口")
    @PreAuthorize("hasAuthority('gw:equip:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwEquip gwEquip){
        return gwEquipService.addEquip(gwEquip);
    }
    @ApiOperation("更新资产接口")
    @PreAuthorize("hasAuthority('gw:equip:update')")
    @PostMapping("/update/{equipId}")
    public Result update(@PathVariable("equipId") Long equipId,@Validated @RequestBody GwEquip gwEquip){
        return gwEquipService.updateEquip(equipId,gwEquip);
    }
    @ApiOperation("删除资产接口")
    @PreAuthorize("hasAuthority('gw:equip:delete')")
    @PostMapping("/delete/{equipId}")
    public Result delete(@PathVariable("equipId") Long equipId){
        return gwEquipService.deleteEquip(equipId);
    }
}

