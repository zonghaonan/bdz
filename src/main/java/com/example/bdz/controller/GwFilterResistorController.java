package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwFilterResistorService;
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
@RequestMapping("gw/model/fres")
public class GwFilterResistorController extends BaseController{

    @Autowired
    GwFilterResistorService gwFilterResistorService;

    @ApiOperation("获取滤波电阻器列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result List(Long id){return gwFilterResistorService.getFresList(id);}

    @ApiOperation("根据id获取滤波电阻器列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwFilterResistorService.info(id);
    }
}

