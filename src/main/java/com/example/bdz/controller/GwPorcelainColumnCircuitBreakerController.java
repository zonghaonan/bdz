package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwPorcelainColumnCircuitBreakerService;
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
@RequestMapping("gw/model/pccb")
public class GwPorcelainColumnCircuitBreakerController extends BaseController{

    @Autowired
    GwPorcelainColumnCircuitBreakerService gwPorcelainColumnCircuitBreakerService;

    @ApiOperation("获取瓷柱式断路器接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result List(Long id){return gwPorcelainColumnCircuitBreakerService.getPccbList(id);}

    @ApiOperation("根据id获取瓷柱式断路器接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwPorcelainColumnCircuitBreakerService.info(id);
    }
}

