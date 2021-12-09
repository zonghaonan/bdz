package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwSvcReactivePowerCompensationDeviceService;
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
@RequestMapping("gw/model/svc")
public class GwSvcReactivePowerCompensationDeviceController extends BaseController{

    @Autowired
    GwSvcReactivePowerCompensationDeviceService gwSvcReactivePowerCompensationDeviceService;

    @ApiOperation("获取SVC无功补偿装置列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result list(Long id){return gwSvcReactivePowerCompensationDeviceService.getSvcList(id);}

    @ApiOperation("根据id获取SVC无功补偿装置列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwSvcReactivePowerCompensationDeviceService.info(id);
    }
}

