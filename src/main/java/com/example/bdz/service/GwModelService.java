package com.example.bdz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-16
 */
public interface GwModelService extends IService<GwModel> {

    GwModel getByModelName(String typeName);

    Result info(Integer id);

    Result getModelList(String modelName);

    Result addModel(GwModel gwModel);

    Result updateModel(Integer modelId, GwModel gwModel);


}
