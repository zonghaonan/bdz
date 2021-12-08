package com.example.bdz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwThroughWallCasing;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-12-01
 */
public interface GwThroughWallCasingService extends IService<GwThroughWallCasing> {

    Result getTwcList(Long id);

    Result info(Long id);
}
