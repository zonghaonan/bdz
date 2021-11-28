package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwIncomingCabinetService;
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
@RequestMapping("gw/model/ic")
public class GwIncomingCabinetController extends BaseController{

    @Autowired
    GwIncomingCabinetService gwIncomingCabinetService;

    @ApiOperation("获取35kV进线柜列表接口")
    @PreAuthorize("hasAuthority('gw:model:ic:list')")
    @GetMapping("/list")
    public Result List(Long id){return gwIncomingCabinetService.getIcList(id);}
}

