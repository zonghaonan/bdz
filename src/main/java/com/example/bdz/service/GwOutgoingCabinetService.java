package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwOutgoingCabinet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-28
 */
public interface GwOutgoingCabinetService extends IService<GwOutgoingCabinet> {

    Result getOcList(Long id);

    Result info(Long id);
}
