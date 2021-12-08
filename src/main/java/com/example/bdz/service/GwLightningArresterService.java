package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwLightningArrester;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-28
 */
public interface GwLightningArresterService extends IService<GwLightningArrester> {

    Result getLaList(Long id);

    Result info(Long id);
}
