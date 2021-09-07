package com.example.bdz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bdz.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author zhn
 * @Date 2021/8/31 20:22
 * @Version 1.0
 */
//
@Repository
public interface UserMapper extends BaseMapper<User> {
    //所有的CRUD操作都已经编写了
    //List<User> getUserList();
}
