package com.example.bdz.service;

import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwPrefabs;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-10-07
 */
public interface GwPrefabsService extends IService<GwPrefabs> {

    Result info(Long prefabId);

    Result getPrefabList(Long userId, String prefabName, String type);

    Result addPrefab(GwPrefabs gwPrefabs);

    Result deletePrefab(Long prefabId);

}
