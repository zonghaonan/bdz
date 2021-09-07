package com.example.bdz.service;

import com.example.bdz.common.dto.GwMenuDto;
import com.example.bdz.pojo.GwMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhn
 * @since 2021-09-06
 */
public interface GwMenuService extends IService<GwMenu> {

    List<GwMenuDto> getNavByUserId(Long userId);
}
