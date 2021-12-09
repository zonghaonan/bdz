package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwConverterTransformer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-12-02
 */
public interface GwConverterTransformerService extends IService<GwConverterTransformer> {

    Result getCtList(Long id);

    Result info(Long id);
}
