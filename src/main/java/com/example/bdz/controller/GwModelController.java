package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwModel;
import com.example.bdz.service.GwModelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhn
 * @since 2021-11-16
 */
@RestController
@RequestMapping("/gw/model")
public class GwModelController {
    @Autowired
    GwModelService gwModelService;
    @ApiOperation("根据id获取类别接口")
    @PreAuthorize("hasAuthority('gw:model:list')")
    @GetMapping("/info/{modelName}")
    public Result info(@PathVariable("modelName") String modelName){
        return gwModelService.info(modelName);
    }

    @ApiOperation("获取设备种类列表接口")
    @PreAuthorize("hasAuthority('gw:model:list')")
    @GetMapping("/list")
    public Result list(String modelName){
        return gwModelService.getModelList(modelName);
    }

    @ApiOperation("添加设备种类接口")
    @PreAuthorize("hasAuthority('gw:model:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwModel gwModel){
        return gwModelService.addModel(gwModel);
    }

    @ApiOperation("更新类别接口")
    @PreAuthorize("hasAuthority('gw:model:update')")
    @PostMapping("/update/{modelId}")
    public Result update(@PathVariable("modelId") Integer modelId,@Validated @RequestBody GwModel gwModel){
        return gwModelService.updateModel(modelId,gwModel);
    }

}

