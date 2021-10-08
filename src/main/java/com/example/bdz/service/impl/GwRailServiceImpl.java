package com.example.bdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwRail;
import com.example.bdz.mapper.GwRailMapper;
import com.example.bdz.pojo.GwRailPosition;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwRailPositionService;
import com.example.bdz.service.GwRailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.service.GwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-10-08
 */
@Service
public class GwRailServiceImpl extends ServiceImpl<GwRailMapper, GwRail> implements GwRailService {

    @Autowired
    GwRailPositionService gwRailPositionService;
    @Autowired
    GwUserService gwUserService;
    @Override
    public Result info(Long railId) {
        GwRail gwRail=getById(railId);
        Assert.notNull(gwRail,"找不到该电子围栏");
        return Result.success(gwRail);
    }

    @Override
    public Result getRailList(Long userId) {
        List<GwRail> gwRails=list(new QueryWrapper<GwRail>().eq("user_id",userId));
        for (GwRail gwRail : gwRails) {
            List<GwRailPosition> gwRailPositions = gwRailPositionService.list(new QueryWrapper<GwRailPosition>().eq("rail_id", gwRail.getRailId()));
            gwRail.setPositions(gwRailPositions);
        }
        return Result.success(gwRails);
    }

    @Override
    @Transactional
    public Result addRail(GwRail gwRail) {
        GwUser gwUser=gwUserService.getById(gwRail.getUserId());
        Assert.notNull(gwUser,"找不到该用户");
        save(gwRail);
        List<GwRailPosition> positions=gwRail.getPositions();
//        System.out.println("positions:"+positions);
        for (GwRailPosition position : positions) {
            position.setRailId(gwRail.getRailId());
        }
        gwRailPositionService.saveBatch(positions);
        return Result.success("");
    }

    @Override
    @Transactional
    public Result deleteRail(Long railId) {
        return null;
    }
}
