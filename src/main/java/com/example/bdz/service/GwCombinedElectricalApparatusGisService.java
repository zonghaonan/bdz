package com.example.bdz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwCombinedElectricalApparatusGis;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-11-28
 */
public interface GwCombinedElectricalApparatusGisService extends IService<GwCombinedElectricalApparatusGis> {

    Result getGisList(Long id);


    Result info(Long id);
}
