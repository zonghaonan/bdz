package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwDistributionBoxService;
import com.example.bdz.service.GwOilfilledTransformerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhn
 * @since 2022-08-29
 */
@RestController
@RequestMapping("/gw/model/db")
public class GwDistributionBoxController {
    @Autowired
    GwDistributionBoxService gwDistributionBoxService;
    @ApiOperation("根据id获取油浸式变压器接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwDistributionBoxService.info(id);
    }

    @ApiOperation("获取油浸式变压器列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result list(){
        return gwDistributionBoxService.getDbList();
    }
}

