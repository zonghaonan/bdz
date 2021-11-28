package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwZeroFluxCurrentTransformer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-28
 */
public interface GwZeroFluxCurrentTransformerService extends IService<GwZeroFluxCurrentTransformer> {

    Result getZfctList(Long id);
}
