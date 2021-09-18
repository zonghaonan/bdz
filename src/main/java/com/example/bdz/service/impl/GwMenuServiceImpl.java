package com.example.bdz.service.impl;

import cn.hutool.core.map.MapUtil;
import com.example.bdz.common.dto.GwMenuDto;
import com.example.bdz.common.lang.Result;
import com.example.bdz.mapper.GwUserMapper;
import com.example.bdz.pojo.GwMenu;
import com.example.bdz.mapper.GwMenuMapper;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.service.GwMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bdz.service.GwRoleMenuService;
import com.example.bdz.service.GwUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.security.Principal;
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
public class GwMenuServiceImpl extends ServiceImpl<GwMenuMapper, GwMenu> implements GwMenuService {

    @Autowired
    GwUserMapper gwUserMapper;
    @Autowired
    GwRoleMenuService gwRoleMenuService;
    @Autowired
    GwUserService gwUserService;

    //获取当前用户的权限列表
    @Override
    public Result nav(Principal principal) {
        GwUser gwUser=gwUserService.getByUsername(principal.getName());
        //获取权限信息
        String authority=gwUserService.getUserAuthorityInfo(gwUser.getUserId());
        String[] authorityArray= StringUtils.tokenizeToStringArray(authority,",");
        List<Integer> menuIds = gwUserMapper.getMenuIds(gwUser.getUserId());
        List<GwMenu> menus = this.listByIds(menuIds);
        //转树状结构
        List<GwMenu> menusTree=buildTreeMenu(menus);
        //转dto
        List<GwMenuDto> navs=convert(menusTree);
        return Result.success(MapUtil.builder()
                .put("authorities",authorityArray)
                .put("nav",navs)
                .map());
    }

    //根据id获取权限信息
    @Override
    public Result info(Integer id) {
        GwMenu gwMenu = getById(id);
        Assert.notNull(gwMenu,"找不到该权限");
        return Result.success(gwMenu);
    }

    //获取权限列表
    @Override
    public Result getMenuTree() {
        List<GwMenu> gwMenus=list();
        List<GwMenu> menusTree=buildTreeMenu(gwMenus);
        return Result.success(menusTree);
    }

    private List<GwMenuDto> convert(List<GwMenu> menusTree) {
        List<GwMenuDto> menuDtos=new ArrayList<>();
        for (GwMenu gwMenu : menusTree) {
            GwMenuDto dto=new GwMenuDto();
            dto.setId(gwMenu.getId());
            dto.setTitle(gwMenu.getName());
            dto.setName(gwMenu.getPerms());
            dto.setPath(gwMenu.getPath());
            dto.setType(gwMenu.getType());
            if(gwMenu.getChildren().size()>0){
                dto.setChildren(convert(gwMenu.getChildren()));
            }
            menuDtos.add(dto);
        }
        return menuDtos;
    }

    private List<GwMenu> buildTreeMenu(List<GwMenu> menus) {
        List<GwMenu> finalMenus=new ArrayList<>();
        for (GwMenu menu : menus) {
            for (GwMenu m : menus) {
                if(menu.getId().equals(m.getParentId())){
                    menu.getChildren().add(m);
                }
            }
            if(menu.getParentId()==0){
                finalMenus.add(menu);
            }
        }
        return finalMenus;
    }
}
