package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwArea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bdz.pojo.GwEquip;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-09-09
 */
public interface GwAreaService extends IService<GwArea> {

    GwArea getByAreaName(String areaName);

    Result info(Integer id);

    Result getAreaList(String name);

    Result addArea(GwArea gwArea);

    Result updateArea(Integer id, GwArea gwArea);

    Result deleteArea(Integer id);
}
