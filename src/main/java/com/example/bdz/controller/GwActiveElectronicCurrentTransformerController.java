package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwActiveElectronicCurrentTransformerService;
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
@RequestMapping("gw/model/aect")
public class GwActiveElectronicCurrentTransformerController extends BaseController {

    @Autowired
    GwActiveElectronicCurrentTransformerService gwActiveElectronicCurrentTransformerService;

    @ApiOperation("获取有源电子式电流互感器列表接口")
    @PreAuthorize("hasAuthority('gw:model:aect:list')")
    @GetMapping("/list")
    public Result List(Long id){return gwActiveElectronicCurrentTransformerService.getAectList(id);}
}

