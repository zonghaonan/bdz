package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwDcDisconnector;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-12-02
 */
public interface GwDcDisconnectorService extends IService<GwDcDisconnector> {

    Result getDcdList(Long id);

    Result info(Long id);
}
