package com.example.bdz.mapper;

import com.example.bdz.pojo.GwUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhn
 * @since 2021-09-03
 */
@Repository
@Mapper
public interface GwUserMapper extends BaseMapper<GwUser> {

    List<Integer> getMenuIds(Long userId);

    List<GwUser> listByMenuId(Integer menuId);
}
