package com.example.bdz.service;

import com.example.bdz.mapper.UserMapper;
import com.example.bdz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhn
 * @Date 2021/8/31 20:34
 * @Version 1.0
 */
@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> getUserList() {
        return userMapper.getUserList();
    }
}
