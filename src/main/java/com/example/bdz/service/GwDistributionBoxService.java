package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwDistributionBox;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2022-08-29
 */
public interface GwDistributionBoxService extends IService<GwDistributionBox> {
    Result getDbList();

    Result info(Long id);
}
