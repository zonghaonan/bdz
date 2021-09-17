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
public class GwEquipController extends BaseController {

    @Autowired
    GwEquipService gwEquipService;
    @Autowired
    GwAreaService gwAreaService;
    @Autowired
    GwTypeService gwTypeService;
    @ApiOperation("根据id获取资产信息接口")
    @PreAuthorize("hasAuthority('gw:equip:list')")
    @GetMapping("/info/{equipId}")
    public Result info(@PathVariable("equipId") Long equipId){
        GwEquip gwEquip = gwEquipService.getById(equipId);
        Assert.notNull(gwEquip,"找不到该资产");
        GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
        gwEquip.setAreaName(gwArea.getAreaName());
        GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
        gwEquip.setAreaName(gwType.getTypeName());
        return Result.success(gwEquip);
    }
    @ApiOperation("获取资产列表接口")
    @PreAuthorize("hasAuthority('gw:equip:list')")
    @GetMapping("/list")
    public Result list(String equipName,int areaId,int typeId){
        Page<GwEquip> gwEquipPage=gwEquipService.page(getPage(),
                new QueryWrapper<GwEquip>()
                        .like(StrUtil.isNotBlank(equipName),"equip_name",equipName)
                        .eq(areaId!=0,"area_id",areaId)
                        .eq(typeId!=0,"type_id",typeId));
        for (GwEquip gwEquip : gwEquipPage.getRecords()) {
            GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
            gwEquip.setAreaName(gwArea.getAreaName());
            GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
            gwEquip.setTypeName(gwType.getTypeName());
        }
        return Result.success(gwEquipPage);
    }
    @ApiOperation("添加资产接口")
    @PreAuthorize("hasAuthority('gw:equip:save')")
    @PostMapping("/save")
    @Transactional
    public Result save(@Validated @RequestBody GwEquip gwEquip){
        gwEquipService.save(gwEquip);
        GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
        gwEquip.setAreaName(gwArea.getAreaName());
        GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
        gwEquip.setAreaName(gwType.getTypeName());
        return Result.success(gwEquip);
    }
    @ApiOperation("更新资产接口")
    @PreAuthorize("hasAuthority('gw:equip:update')")
    @PostMapping("/update/{equipId}")
    @Transactional
    public Result update(@PathVariable("equipId") Long equipId,@Validated @RequestBody GwEquip gwEquip){
        GwEquip preGwEquip = gwEquipService.getById(equipId);
        Assert.notNull(preGwEquip,"找不到该资产");
        gwEquip.setEquipId(equipId);
        gwEquipService.updateById(gwEquip);
        GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
        gwEquip.setAreaName(gwArea.getAreaName());
        GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
        gwEquip.setAreaName(gwType.getTypeName());
        return Result.success(gwEquip);
    }
    @ApiOperation("删除资产接口")
    @PreAuthorize("hasAuthority('gw:equip:delete')")
    @PostMapping("/delete/{equipId}")
    @Transactional
    public Result delete(@PathVariable("equipId") Long equipId){
        GwEquip gwEquip = gwEquipService.getById(equipId);
        Assert.notNull(gwEquip,"该资产不存在");
        gwEquipService.removeById(gwEquip);
        return Result.success(null);
    }
}

