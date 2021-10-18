package com.example.bdz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bdz.common.lang.Result;
import com.example.bdz.pojo.GwArea;
import com.example.bdz.pojo.GwEquip;
import com.example.bdz.mapper.GwEquipMapper;
import com.example.bdz.pojo.GwType;
import com.example.bdz.service.GwAreaService;
import com.example.bdz.service.GwEquipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.service.GwTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
@Service
public class GwEquipServiceImpl extends ServiceImpl<GwEquipMapper, GwEquip> implements GwEquipService {

    @Autowired
    GwAreaService gwAreaService;
    @Autowired
    GwTypeService gwTypeService;
    @Autowired
    HttpServletRequest request;
    //根据id获取资产信息
    @Override
    public Result info(Long equipId) {
        GwEquip gwEquip = getById(equipId);
        Assert.notNull(gwEquip,"找不到该资产");
        GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
        gwEquip.setAreaName(gwArea.getAreaName());
        GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
        gwEquip.setTypeName(gwType.getTypeName());
        return Result.success(gwEquip);
    }

    //获取资产列表
    @Override
    public Result getEquipList(String equipName, Integer areaId, Integer typeId) {
        if(areaId==null){
            areaId=0;
        }
        if(typeId==null){
            typeId=0;
        }
        Page<GwEquip> gwEquipPage=page(getPage(),
                new QueryWrapper<GwEquip>()
                        .like(StrUtil.isNotBlank(equipName),"equip_name",equipName)
                        .eq(areaId!=0,"area_id",areaId)
                        .eq(typeId!=0,"type_id",typeId));
        for (GwEquip gwEquip : gwEquipPage.getRecords()) {
            GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
            gwEquip.setAreaName(gwArea.getAreaName());
            GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
            gwEquip.setTypeName(gwType.getTypeName());
        }
        return Result.success(gwEquipPage);
    }

    //添加资产
    @Override
    public Result addEquip(GwEquip gwEquip) {
        GwEquip ge=getByEquipName(gwEquip.getEquipName());
        if(ge!=null){
            return Result.fail("该资产已存在");
        }
        gwEquip.setTag(gwEquip.getEquipName());
        save(gwEquip);
        GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
        gwEquip.setAreaName(gwArea.getAreaName());
        GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
        gwEquip.setTypeName(gwType.getTypeName());
        return Result.success(gwEquip);
    }

    //根据资产名查询资产
    private GwEquip getByEquipName(String equipName) {
        return getOne(new QueryWrapper<GwEquip>().eq("equip_name",equipName));
    }

    //更新资产
    @Override
    public Result updateEquip(Long equipId, GwEquip gwEquip) {
        GwEquip preGwEquip = getById(equipId);
        Assert.notNull(preGwEquip,"找不到该资产");
        if(!preGwEquip.getEquipName().equals(gwEquip.getEquipName())){
            GwEquip ge=getByEquipName(gwEquip.getEquipName());
            if(ge!=null){
                return Result.fail("该资产已存在");
            }
        }
        gwEquip.setEquipId(equipId);
        updateById(gwEquip);
        GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
        gwEquip.setAreaName(gwArea.getAreaName());
        GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
        gwEquip.setTypeName(gwType.getTypeName());
        return Result.success(gwEquip);
    }

    //删除资产
    @Override
    @Transactional
    public Result deleteEquip(Long equipId) {
        GwEquip gwEquip = getById(equipId);
        Assert.notNull(gwEquip,"该资产不存在");
        removeById(gwEquip);
        return Result.success(null);
    }

    //获取资产故障列表接口
    @Override
    public Result getEquipBadList() {
        Page<GwEquip> gwEquipPage=page(getPage(),
                new QueryWrapper<GwEquip>().eq("status",1));
        for (GwEquip gwEquip : gwEquipPage.getRecords()) {
            GwArea gwArea=gwAreaService.getById(gwEquip.getAreaId());
            gwEquip.setAreaName(gwArea.getAreaName());
            GwType gwType=gwTypeService.getById(gwEquip.getTypeId());
            gwEquip.setTypeName(gwType.getTypeName());
        }
        return Result.success(gwEquipPage);
    }



    //获取分页
    public Page getPage(){
        int page= ServletRequestUtils.getIntParameter(request,"page",1);
        int size= ServletRequestUtils.getIntParameter(request,"size",10);
        return new Page(page,size);
    }
}
