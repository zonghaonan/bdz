package com.example.bdz.service;

import com.example.bdz.pojo.GwType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-09-16
 */
public interface GwTypeService extends IService<GwType> {

    GwType getByTypeName(String typeName);
}
