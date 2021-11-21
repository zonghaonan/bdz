package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwOilfilledTransformerService;
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
 * @since 2021-11-19
 */
@RestController
@RequestMapping("/gw/model/oft")
public class GwOilfilledTransformerController extends BaseController {

    @Autowired
    GwOilfilledTransformerService gwOilfilledTransformerService;
    @ApiOperation("根据id获取油浸式变压器接口")
    @PreAuthorize("hasAuthority('gw:model:oilfilledtransformer:list')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwOilfilledTransformerService.info(id);
    }

    @ApiOperation("获取油浸式变压器列表接口")
    @PreAuthorize("hasAuthority('gw:model:oft:list')")
    @GetMapping("/list")
    public Result list(Long id){
        return gwOilfilledTransformerService.getModelList(id);
    }

    @ApiOperation("添加设备种类接口")
    @PreAuthorize("hasAuthority('gw:model:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwOilfilledTransformer gwOilfilledTransformer){
        return gwOilfilledTransformerService.addOft(gwOilfilledTransformer);
    }

    @ApiOperation("更新类别接口")
    @PreAuthorize("hasAuthority('gw:model:update')")
    @PostMapping("/update/{id}")
    public Result update(@PathVariable("id") Long id,@Validated @RequestBody GwOilfilledTransformer gwOilfilledTransformer) {
        return gwOilfilledTransformerService.updateOft(id, gwOilfilledTransformer);
    }
}

