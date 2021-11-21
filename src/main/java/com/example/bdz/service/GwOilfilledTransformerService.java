package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwModel;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-19
 */
public interface GwOilfilledTransformerService extends IService<GwOilfilledTransformer> {

    GwModel getByOftName(String modelName);

    Result info(Long id);

    Result getModelList(Long id);

    Result addOft(GwOilfilledTransformer gwOilfilledTransformer);

    Result updateOft(Long id, GwOilfilledTransformer gwOilfilledTransformer);
}
