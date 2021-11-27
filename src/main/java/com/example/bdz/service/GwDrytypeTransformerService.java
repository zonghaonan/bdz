package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwDrytypeTransformer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-27
 */
public interface GwDrytypeTransformerService extends IService<GwDrytypeTransformer> {

    Result getDttList(Long id);

}
