package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwSeriesCompensationCapacitorCompleteSet;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-12-02
 */
public interface GwSeriesCompensationCapacitorCompleteSetService extends IService<GwSeriesCompensationCapacitorCompleteSet> {

    Result getScccList(Long id);

    Result info(Long id);
}
