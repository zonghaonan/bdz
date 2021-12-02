package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwSmoothingReactorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("gw/model/sr")
public class GwSmoothingReactorController extends BaseController{

    @Autowired
    GwSmoothingReactorService gwSmoothingReactorService;

    @ApiOperation("获取平波电抗器列表接口")
    @PreAuthorize("hasAuthority('gw:model:sr:list')")
    @GetMapping("/list")
    public Result list(Long id){return gwSmoothingReactorService.getSrList(id);}
}

