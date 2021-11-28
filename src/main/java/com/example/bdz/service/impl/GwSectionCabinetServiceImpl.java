package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwSectionCabinetMapper;
import com.example.bdz.pojo.GwSectionCabinet;
import com.example.bdz.service.GwSectionCabinetService;
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
public class GwSectionCabinetServiceImpl extends ServiceImpl<GwSectionCabinetMapper, GwSectionCabinet> implements GwSectionCabinetService {

    @Override
    public Result getScList(Long id) {
        List<GwSectionCabinet> gwSectionCabinets = list(new QueryWrapper<GwSectionCabinet>());
        return Result.success(gwSectionCabinets);
    }
}
