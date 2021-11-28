package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwIsolationCabinetMapper;
import com.example.bdz.pojo.GwIsolationCabinet;
import com.example.bdz.service.GwIsolationCabinetService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-11-28
 */
@Service
public class GwIsolationCabinetServiceImpl extends ServiceImpl<GwIsolationCabinetMapper, GwIsolationCabinet> implements GwIsolationCabinetService {

    @Override
    public Result getIscList(Long id) {
        List<GwIsolationCabinet> gwIsolationCabinets = list(new QueryWrapper<GwIsolationCabinet>());
        return Result.success(gwIsolationCabinets);
    }
}
