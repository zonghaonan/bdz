package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwDrytypeTransformerService;
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
 * @since 2021-11-27
 */
@RestController
@RequestMapping("gw/model/dtt")
public class GwDrytypeTransformerController extends BaseController{
    @Autowired
    GwDrytypeTransformerService gwDrytypeTransformerService;

    @ApiOperation("获取油浸式变压器列表接口")
    @PreAuthorize("hasAuthority('gw:model:dtt:list')")
    @GetMapping("/list")
    public Result list(Long id){
        return gwDrytypeTransformerService.getDttList(id);
    }

}

