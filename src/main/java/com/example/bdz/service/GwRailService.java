package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwRail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-10-08
 */
public interface GwRailService extends IService<GwRail> {

    Result info(Long railId);

    Result getRailList(Long userId);

    Result addRail(GwRail gwRail);

    Result deleteRail(Long railId);
}
