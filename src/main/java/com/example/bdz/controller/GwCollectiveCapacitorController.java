package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwCollectiveCapacitorService;
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
@RequestMapping("gw/model/cc")
public class GwCollectiveCapacitorController extends BaseController{
    @Autowired
    GwCollectiveCapacitorService gwCollectiveCapacitorService;

    @ApiOperation("获取集合式电容器列表接口")
    @PreAuthorize("hasAuthority('gw:model:cc:list')")
    @GetMapping("/list")
    public Result List(Long id){return gwCollectiveCapacitorService.getCcList(id);}

}

