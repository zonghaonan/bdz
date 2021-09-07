package com.example.bdz.service.impl;

import com.example.bdz.common.dto.GwMenuDto;
import com.example.bdz.mapper.GwUserMapper;
import com.example.bdz.pojo.GwMenu;
import com.example.bdz.mapper.GwMenuMapper;
import com.example.bdz.service.GwMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
    @Override
    public List<GwMenuDto> getNavByUserId(Long userId) {
        List<Integer> menuIds = gwUserMapper.getMenuIds(userId);
        List<GwMenu> menus = this.listByIds(menuIds);
        //转树状结构
        List<GwMenu> menusTree=buildTreeMenu(menus);
        //转dto
        return convert(menusTree);
    }

    private List<GwMenuDto> convert(List<GwMenu> menusTree) {
        List<GwMenuDto> menuDtos=new ArrayList<>();
        for (GwMenu gwMenu : menusTree) {
            GwMenuDto dto=new GwMenuDto();
            dto.setId(gwMenu.getId());
            dto.setTitle(gwMenu.getName());
            dto.setName(gwMenu.getPerms());
            dto.setPath(gwMenu.getPath());
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
