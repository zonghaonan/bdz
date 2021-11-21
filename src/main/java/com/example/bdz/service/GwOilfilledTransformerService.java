package com.example.bdz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwOilfilledTransformer;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-19
 */
public interface GwOilfilledTransformerService extends IService<GwOilfilledTransformer> {

    GwOilfilledTransformer getByOftId(Long id);

    Result info(Long id);

    Result getOftList(Long id);

    Result addOft(GwOilfilledTransformer gwOilfilledTransformer);

    Result updateOft(Long id, GwOilfilledTransformer gwOilfilledTransformer);

    Result deleteOft(Long id);

}
