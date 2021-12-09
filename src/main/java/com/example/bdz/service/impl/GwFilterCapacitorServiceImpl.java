package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwFilterCapacitorMapper;
import com.example.bdz.pojo.GwFilterCapacitor;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwFilterCapacitorService;
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
public class GwFilterCapacitorServiceImpl extends ServiceImpl<GwFilterCapacitorMapper, GwFilterCapacitor> implements GwFilterCapacitorService {

    @Override
    public Result getFcapList(Long id) {
        List<GwFilterCapacitor> gwFilterCapacitors = list(new QueryWrapper<GwFilterCapacitor>());
        return Result.success(gwFilterCapacitors);
    }

    @Override
    public Result info(Long id) {
        GwFilterCapacitor gwFilterCapacitor = getById(id);
        org.springframework.util.Assert.notNull(gwFilterCapacitor,"找不到该设备");
        return Result.success(gwFilterCapacitor);
    }
}
