package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.pojo.GwArea;
import com.example.bdz.pojo.GwType;
import com.example.bdz.mapper.GwTypeMapper;
import com.example.bdz.service.GwTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-16
 */
@Service
public class GwTypeServiceImpl extends ServiceImpl<GwTypeMapper, GwType> implements GwTypeService {

    @Override
    public GwType getByTypeName(String typeName) {
        return getOne((new QueryWrapper<GwType>().eq("type_name",typeName)));
    }
}
