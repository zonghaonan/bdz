package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwDcEarthingSwitchService;
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
 * @since 2021-12-02
 */
@RestController
@RequestMapping("gw/model/dces")
public class GwDcEarthingSwitchController extends BaseController{

    @Autowired
    GwDcEarthingSwitchService gwDcEarthingSwitchService;

    @ApiOperation("获取直流接地开关列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result List(Long id){return gwDcEarthingSwitchService.getDcesList(id);}

    @ApiOperation("根据id获取直流接地开关列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwDcEarthingSwitchService.info(id);
    }
}

