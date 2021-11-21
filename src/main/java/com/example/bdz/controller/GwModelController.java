package com.example.bdz.controller;


import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwModel;
import com.example.bdz.service.GwModelService;
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
 * @since 2021-11-16
 */
@RestController
@RequestMapping("/gw/model")
public class GwModelController {
    @Autowired
    GwModelService gwModelService;
    @ApiOperation("根据id获取类别接口")
    @PreAuthorize("hasAuthority('gw:model:list')")
    @GetMapping("/info/{modelId}")
    public Result info(@PathVariable("modelId") Integer modelId){
        return gwModelService.info(modelId);
    }

    @ApiOperation("获取设备种类列表接口")
    @PreAuthorize("hasAuthority('gw:model:list')")
    @GetMapping("/list")
    public Result list(String modelName){
        return gwModelService.getModelList(modelName);
    }

    @ApiOperation("添加设备种类接口")
    @PreAuthorize("hasAuthority('gw:model:save')")
    @PostMapping("/save")
    public Result save(@Validated @RequestBody GwModel gwModel){
        return gwModelService.addModel(gwModel);
    }

    @ApiOperation("更新类别接口")
    @PreAuthorize("hasAuthority('gw:model:update')")
    @PostMapping("/update/{modelId}")
    public Result update(@PathVariable("modelId") Integer modelId,@Validated @RequestBody GwModel gwModel){
        return gwModelService.updateModel(modelId,gwModel);
    }

//    @ApiOperation("查看类别设备接口")
////    @PreAuthorize("hasAuthority('gw:model:show')")                         //数据库menu表还未添加
////    @PostMapping("/update/{modelId}")
////    public Result show(@PathVariable("modelId") Long modelId,@Validated @RequestBody GwModel gwModel){
////        return gwModelService.updateModel(modelId,gwModel);
////    }







//    @ApiOperation("删除资产接口")
//    @PreAuthorize("hasAuthority('gw:equip:delete')")
//    @PostMapping("/delete/{equipId}")
//    public Result delete(@PathVariable("equipId") Long equipId){      //模型种类是特定存在的    不能删除
//        return gwEquipService.deleteEquip(equipId);
//    }

//    @ApiOperation("获取资产故障列表接口")
//    @PreAuthorize("hasAuthority('gw:equip:badlist')")      //没有这个功能
//    @GetMapping("/badlist")
//    public Result badList(){
//        return gwEquipService.getEquipBadList();
//}
}

