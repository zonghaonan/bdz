package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwAdjustableCameraMapper;
import com.example.bdz.pojo.GwAdjustableCamera;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwAdjustableCameraService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-12-02
 */
@Service
public class GwAdjustableCameraServiceImpl extends ServiceImpl<GwAdjustableCameraMapper, GwAdjustableCamera> implements GwAdjustableCameraService {

    @Override
    public Result getAcList(Long id) {
        List<GwAdjustableCamera> gwAdjustableCameras = list(new QueryWrapper<GwAdjustableCamera>());
        return Result.success(gwAdjustableCameras);
    }

    @Override
    public Result info(Long id) {
        GwAdjustableCamera gwAdjustableCamera = getById(id);
        org.springframework.util.Assert.notNull(gwAdjustableCamera,"找不到该设备");
        return Result.success(gwAdjustableCamera);
    }
}
