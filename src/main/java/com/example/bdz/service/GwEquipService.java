package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwEquip;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
public interface GwEquipService extends IService<GwEquip> {

    Result info(Long equipId);

    Result getEquipList(String equipName, Integer areaId, Integer typeId);

    Result addEquip(GwEquip gwEquip);

    Result updateEquip(Long equipId, GwEquip gwEquip);

    Result deleteEquip(Long equipId);
}
