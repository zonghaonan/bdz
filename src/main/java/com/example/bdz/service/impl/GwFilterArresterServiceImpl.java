package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwFilterArresterMapper;
import com.example.bdz.pojo.GwFilterArrester;
import com.example.bdz.pojo.GwOilfilledTransformer;
import com.example.bdz.service.GwFilterArresterService;
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
public class GwFilterArresterServiceImpl extends ServiceImpl<GwFilterArresterMapper, GwFilterArrester> implements GwFilterArresterService {

    @Override
    public Result getFaList(Long id) {
        List<GwFilterArrester> gwFilterArresters = list(new QueryWrapper<GwFilterArrester>());
        return Result.success(gwFilterArresters);
    }

    @Override
    public Result info(Long id) {
        GwFilterArrester gwFilterArrester = getById(id);
        org.springframework.util.Assert.notNull(gwFilterArrester,"找不到该设备");
        return Result.success(gwFilterArrester);
    }
}
