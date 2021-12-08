package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwFilterCapacitor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-12-02
 */
public interface GwFilterCapacitorService extends IService<GwFilterCapacitor> {

    Result getFcapList(Long id);

    Result info(Long id);
}
