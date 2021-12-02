package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwAdjustableCameraService;
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
@RequestMapping("gw/model/ac")
public class GwAdjustableCameraController extends BaseController{
    @Autowired
    GwAdjustableCameraService gwAdjustableCameraService;

    @ApiOperation("获取调相机列表接口")
    @PreAuthorize("hasAuthority('gw:model:ac:list')")
    @GetMapping("/list")
    public Result List(Long id){return gwAdjustableCameraService.getAcList(id);}

}

