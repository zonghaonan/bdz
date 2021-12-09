package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwHighVoltageShuntReactorService;
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
 * @since 2021-11-27
 */
@RestController
@RequestMapping("gw/model/hvsr")
public class GwHighVoltageShuntReactorController extends BaseController {
    @Autowired
    GwHighVoltageShuntReactorService gwHighVoltageShuntReactorService;

    @ApiOperation("获取高压并联电抗器列表")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result list(Long id){return gwHighVoltageShuntReactorService.getHvsrList(id);}

    @ApiOperation("根据id获取高压并联电抗器列表")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwHighVoltageShuntReactorService.info(id);
    }

}

