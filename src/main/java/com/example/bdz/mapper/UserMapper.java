package com.example.bdz.mapper;

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
@Mapper
@Repository
public interface UserMapper {
    List<User> getUserList();
}
