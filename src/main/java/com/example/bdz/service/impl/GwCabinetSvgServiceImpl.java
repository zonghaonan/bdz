package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwCabinetSvgMapper;
import com.example.bdz.pojo.GwCabinetSvg;
import com.example.bdz.service.GwCabinetSvgService;
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
public class GwCabinetSvgServiceImpl extends ServiceImpl<GwCabinetSvgMapper, GwCabinetSvg> implements GwCabinetSvgService {

    @Override
    public Result getCsList(Long id) {
        List<GwCabinetSvg> gwCabinetSvgs = list(new QueryWrapper<GwCabinetSvg>());
        return Result.success(gwCabinetSvgs);
    }
}
