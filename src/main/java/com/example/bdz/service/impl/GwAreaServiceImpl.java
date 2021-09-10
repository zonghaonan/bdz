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
    public void updateCount(Integer areaId,int count) {
        GwArea gwArea = getById(areaId);
        if(count>0){
            gwArea.setEquipCount(gwArea.getEquipCount()+1);
        }else {
            gwArea.setEquipCount(gwArea.getEquipCount()-1);
        }
        gwArea.setEquipAllCount(gwArea.getEquipAllCount()+count);
        updateById(gwArea);
    }

    @Override
    public void updateCount(GwEquip preGwEquip, GwEquip gwEquip) {
        if(preGwEquip.getAreaId()==gwEquip.getAreaId()&&preGwEquip.getCount()==gwEquip.getCount()){
            //区域和数量均不变
            return;
        }else if(preGwEquip.getAreaId()==gwEquip.getAreaId()){
            //区域不变
            GwArea gwArea = getById(preGwEquip.getAreaId());
            int relativeCount=gwEquip.getCount()-preGwEquip.getCount();
            gwArea.setEquipAllCount(gwArea.getEquipAllCount()+relativeCount);
            updateById(gwArea);
        }else {
            //区域改变
            GwArea preGwArea = getById(preGwEquip.getAreaId());
            GwArea gwArea = getById(gwEquip.getAreaId());
            preGwArea.setEquipCount(preGwArea.getEquipCount()-1);
            gwArea.setEquipCount(gwArea.getEquipCount()+1);
            preGwArea.setEquipAllCount(preGwArea.getEquipAllCount()-preGwEquip.getCount());
            gwArea.setEquipAllCount(gwArea.getEquipAllCount()+gwEquip.getCount());
            updateBatchById(Arrays.asList(preGwArea,gwArea));
        }
    }

}
