package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwPrefabs;
import com.example.bdz.service.GwPrefabsService;
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
 * @since 2021-10-07
 */
@RestController
@RequestMapping("/gw/prefabs")
public class GwPrefabsController {
    @Autowired
    GwPrefabsService gwPrefabsService;
    @ApiOperation("根据id获取物体信息接口")
    @PreAuthorize("hasAuthority('gw:prefabs:list')")
    @GetMapping("/info/{prefabId}")
    public Result info(@PathVariable("prefabId") Long prefabId){
        return gwPrefabsService.info(prefabId);
    }
    @ApiOperation("获取用户物体列表接口")
    @PreAuthorize("hasAuthority('gw:prefabs:list')")
    @GetMapping("/list/{userId}")
    public Result list(@PathVariable("userId") Long userId,String prefabName,String type){
        return gwPrefabsService.getPrefabList(userId,prefabName,type);
    }
    @ApiOperation("添加物体接口")
    @PreAuthorize("hasAuthority('gw:prefabs:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwPrefabs gwPrefabs){
        return gwPrefabsService.addPrefab(gwPrefabs);
    }

    @ApiOperation("删除物体接口")
    @PreAuthorize("hasAuthority('gw:prefabs:delete')")
    @PostMapping("/delete/{prefabId}")
    public Result delete(@PathVariable("prefabId") Long prefabId){
        return gwPrefabsService.deletePrefab(prefabId);
    }
}

