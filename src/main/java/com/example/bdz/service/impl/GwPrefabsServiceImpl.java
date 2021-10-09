package com.example.bdz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwPrefabs;
import com.example.bdz.mapper.GwPrefabsMapper;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwPrefabsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.service.GwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-10-07
 */
@Service
public class GwPrefabsServiceImpl extends ServiceImpl<GwPrefabsMapper, GwPrefabs> implements GwPrefabsService {

    @Autowired
    GwUserService gwUserService;
    @Override
    public Result info(Long prefabId) {
        GwPrefabs gwPrefabs=getById(prefabId);
        Assert.notNull(gwPrefabs,"找不到该物体");
        return Result.success(gwPrefabs);
    }

    @Override
    public Result getPrefabList(Long userId, String prefabName) {
        List<GwPrefabs> gwPrefabs=list(new QueryWrapper<GwPrefabs>()
                .eq(StrUtil.isNotBlank(prefabName),"prefab_name",prefabName)
                .eq("user_id",userId));
        return Result.success(gwPrefabs);
    }

    @Override
    public Result addPrefab(GwPrefabs gwPrefabs) {
        GwUser gwUser=gwUserService.getById(gwPrefabs.getUserId());
        Assert.notNull(gwUser,"找不到该用户");
        save(gwPrefabs);
        GwPrefabs gwPrefabs1=getById(gwPrefabs.getPrefabId());
        return Result.success(gwPrefabs1);
    }

    @Override
    public Result deletePrefab(Long prefabId) {
        GwPrefabs gwPrefabs=getById(prefabId);
        Assert.notNull(gwPrefabs,"该物体不存在");
        removeById(prefabId);
        return Result.success(null);
    }

}
