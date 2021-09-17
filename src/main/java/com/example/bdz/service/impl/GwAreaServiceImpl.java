package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.pojo.GwArea;
import com.example.bdz.mapper.GwAreaMapper;
import com.example.bdz.pojo.GwEquip;
import com.example.bdz.service.GwAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-09
 */
@Service
public class GwAreaServiceImpl extends ServiceImpl<GwAreaMapper, GwArea> implements GwAreaService {

    @Autowired
    GwAreaMapper gwAreaMapper;

    @Override
    public GwArea getByAreaName(String areaName) {
        return getOne((new QueryWrapper<GwArea>().eq("area_name",areaName)));
    }


}
