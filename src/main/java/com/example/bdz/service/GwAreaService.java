package com.example.bdz.service;

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

    void updateCount(Integer areaId,int count);

    void updateCount(GwEquip preGwEquip, GwEquip gwEquip);

}
