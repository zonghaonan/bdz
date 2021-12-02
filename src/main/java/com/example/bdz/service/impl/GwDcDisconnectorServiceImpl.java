package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwDcDisconnectorMapper;
import com.example.bdz.pojo.GwDcDisconnector;
import com.example.bdz.service.GwDcDisconnectorService;
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
public class GwDcDisconnectorServiceImpl extends ServiceImpl<GwDcDisconnectorMapper, GwDcDisconnector> implements GwDcDisconnectorService {

    @Override
    public Result getDcdList(Long id) {
        List<GwDcDisconnector> gwDcDisconnectors = list(new QueryWrapper<GwDcDisconnector>());
        return Result.success(gwDcDisconnectors);
    }
}
