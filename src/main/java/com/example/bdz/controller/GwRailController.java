package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwPrefabs;
import com.example.bdz.pojo.GwRail;
import com.example.bdz.service.GwRailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhn
 * @since 2021-10-08
 */
@RestController
@RequestMapping("/gw/rail")
public class GwRailController {

    @Autowired
    GwRailService gwRailService;
    @ApiOperation("根据id获取电子围栏信息接口")
    @PreAuthorize("hasAuthority('gw:rail:list')")
    @GetMapping("/info/{railId}")
    public Result info(@PathVariable("railId") Long railId){
        return gwRailService.info(railId);
    }
    @ApiOperation("获取用户电子围栏列表接口")
    @PreAuthorize("hasAuthority('gw:rail:list')")
    @GetMapping("/list/{userId}")
    public Result list(@PathVariable("userId") Long userId){
        return gwRailService.getRailList(userId);
    }
    @ApiOperation("添加电子围栏接口")
    @PreAuthorize("hasAuthority('gw:rail:save')")
    @PostMapping("/save")
    public Result save(@RequestBody GwRail gwRail){
        return gwRailService.addRail(gwRail);
    }

    @ApiOperation("删除电子围栏接口")
    @PreAuthorize("hasAuthority('gw:rail:delete')")
    @PostMapping("/delete/{railId}")
    public Result delete(@PathVariable("railId") Long railId){
        return gwRailService.deleteRail(railId);
    }
}

