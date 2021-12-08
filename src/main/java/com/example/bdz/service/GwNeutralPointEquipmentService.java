package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwNeutralPointEquipment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-28
 */
public interface GwNeutralPointEquipmentService extends IService<GwNeutralPointEquipment> {

    Result getNpeList(Long id);

    Result info(Long id);
}
