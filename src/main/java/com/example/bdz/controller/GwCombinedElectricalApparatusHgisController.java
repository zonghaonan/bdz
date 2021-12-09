package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.service.GwCombinedElectricalApparatusHgisService;
import com.example.bdz.service.GwOilfilledTransformerService;
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
@RequestMapping("gw/model/hgis")
public class GwCombinedElectricalApparatusHgisController extends BaseController {

    @Autowired
    GwCombinedElectricalApparatusHgisService gwCombinedElectricalApparatusHgisService;

    @ApiOperation("获取组合电器HGIS列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/list")
    public Result List(Long id){return gwCombinedElectricalApparatusHgisService.getHgisList(id);}

    GwOilfilledTransformerService gwOilfilledTransformerService;
    @ApiOperation("根据id组合电器HGIS列表接口")
    @PreAuthorize("hasAuthority('gw:scene')")
    @GetMapping("/info/{Id}")
    public Result info(@PathVariable("Id") Long id){
        return gwCombinedElectricalApparatusHgisService.info(id);
    }
}

