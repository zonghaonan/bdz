package com.example.bdz.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwEquip;
import com.example.bdz.pojo.GwType;
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
public class GwTypeController extends BaseController {
    @Autowired
    GwTypeService gwTypeService;
    @ApiOperation("根据id获取分类信息接口")
    @PreAuthorize("hasAuthority('gw:type:list')")
    @GetMapping("/info/{id}")
    public Result info(@PathVariable("id") Integer id){
        return gwTypeService.info(id);
    }
    @ApiOperation("获取分类列表接口")
    @PreAuthorize("hasAuthority('gw:type:list')")
    @GetMapping("/list")
    public Result list(String name){
        return gwTypeService.getTypeList(name);
    }
    @ApiOperation("添加分类接口")
    @PreAuthorize("hasAuthority('gw:type:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwType gwType){
        return gwTypeService.addType(gwType);
    }
    @ApiOperation("更新分类接口")
    @PreAuthorize("hasAuthority('gw:type:update')")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") Integer id,@Validated @RequestBody GwType gwType){
        return gwTypeService.updateType(id,gwType);
    }
    @ApiOperation("删除分类接口")
    @PreAuthorize("hasAuthority('gw:type:delete')")
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        return gwTypeService.deleteType(id);
    }
}

