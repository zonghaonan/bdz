package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwDcPostInsulator;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-12-02
 */
public interface GwDcPostInsulatorService extends IService<GwDcPostInsulator> {

    Result getDcpiList();

    Result info(Long id);
}
