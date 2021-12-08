package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwIsolatingSwitchService;
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
 * @since 2021-11-28
 */
@RestController
@RequestMapping("gw/model/is")
public class GwIsolatingSwitchController extends BaseController {

    @Autowired
    GwIsolatingSwitchService gwIsolatingSwitchService;

    @ApiOperation("获取隔离开关列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result List(Long id){return gwIsolatingSwitchService.getIsList(id);}

    @ApiOperation("根据id获取隔离开关列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwIsolatingSwitchService.info(id);
    }
}

