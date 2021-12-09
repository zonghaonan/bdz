package com.example.bdz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwHighVoltageShuntReactor;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-27
 */
public interface GwHighVoltageShuntReactorService extends IService<GwHighVoltageShuntReactor> {

    Result getHvsrList(Long id);

    Result info(Long id);
}
