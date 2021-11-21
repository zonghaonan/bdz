package com.example.bdz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwModelMapper;
import com.example.bdz.pojo.GwModel;
import com.example.bdz.service.GwModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-11-16
 */
@Service
public class GwModelServiceImpl extends ServiceImpl<GwModelMapper, GwModel> implements GwModelService {



    @Autowired
    HttpServletRequest request;


    //根据id获取类别
    @Override
    public Result info(Integer modelId) {
        GwModel gwModel = getById(modelId);
        Assert.notNull(gwModel,"找不到该设备类别");
//        gwModel.setAmount(gwOilfilledTransformerService.count(new QueryWrapper<GwOilfilledTransformer>().eq("model_id",gwModel.getModelId())));
        return Result.success(gwModel);
    }

    //获取设备类别列表------例如                                                其他实现的功能
    //                          id     设备类别名       总数                    //操作
    //                           1     油浸式变压器      2                      //编辑  查看该类别对应的所有设备
    @Override
    public Result getModelList(String modelName) {

        List<GwModel> gwModels= list(new QueryWrapper<GwModel>().like(StrUtil.isNotBlank(modelName),"model_name",modelName));
        return Result.success(gwModels);
    }

    //添加设备分类
    @Override
    public Result addModel(GwModel gwModel) {
        GwModel ge=getByModelName(gwModel.getModelName());
        if(ge!=null) {
            return Result.fail("该类别已存在");
        }
        save(gwModel);
      
        return Result.success(gwModel);
    }
    //根据类别名查询类别
    @Override
    public GwModel getByModelName(String modelName) {
        return getOne(new QueryWrapper<GwModel>().eq("model_name",modelName));
    }

    //更新类别
    @Override
    public Result updateModel(Integer modelId, GwModel gwModel) {
        GwModel preGwModel = getById(modelId);
        Assert.notNull(preGwModel,"找不到该类别");
        if(!preGwModel.getModelName().equals(gwModel.getModelName())){
            GwModel ge=getByModelName(gwModel.getModelName());
            if(ge!=null){
                return Result.fail("该类别已存在");
            }
        }
        gwModel.setModelId(modelId);
        updateById(gwModel);
        return Result.success(gwModel);


    }



    //获取分页
    public Page getPage(){
        int page= ServletRequestUtils.getIntParameter(request,"page",1);
        int size= ServletRequestUtils.getIntParameter(request,"size",10);
        return new Page(page,size);
    }
}
