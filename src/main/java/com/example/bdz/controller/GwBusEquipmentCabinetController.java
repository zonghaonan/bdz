package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwBusEquipmentCabinetService;
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
 * @since 2021-11-28
 */
@RestController
@RequestMapping("gw/model/bec")
public class GwBusEquipmentCabinetController extends BaseController{

    @Autowired
    GwBusEquipmentCabinetService gwBusEquipmentCabinetService;

    @ApiOperation("获取35kV母线设备柜列表接口")
    @PreAuthorize("hasAuthority('gw:model:bec:list')")
    @GetMapping("/list")
    public Result List(Long id){return gwBusEquipmentCabinetService.getBecList(id);}

}

