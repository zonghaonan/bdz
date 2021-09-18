package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
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

    Result info(Integer id);

    Result getTypeList(String name);

    Result addType(GwType gwType);

    Result updateType(Integer id, GwType gwType);

    Result deleteType(Integer id);
}
