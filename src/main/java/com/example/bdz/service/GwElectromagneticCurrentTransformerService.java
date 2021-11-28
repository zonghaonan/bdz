package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwElectromagneticCurrentTransformer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-28
 */
public interface GwElectromagneticCurrentTransformerService extends IService<GwElectromagneticCurrentTransformer> {

    Result getEctList(Long id);
}
