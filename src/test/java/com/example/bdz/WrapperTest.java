package com.example.bdz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bdz.mapper.UserMapper;
import com.example.bdz.pojo.User;
import org.apache.ibatis.javassist.runtime.Desc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author zhn
 * @Date 2021/9/2 16:58
 * @Version 1.0
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelect(){
        //查询username、password、age不为空的用户，年龄大于等于18
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.isNotNull("username")
                .isNotNull("password")
                .isNotNull("age")
                .ge("age",18);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    public void testSelect2(){
        //查询用户名为123456
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username","12345");
        User user=userMapper.selectOne(wrapper);
        System.out.println(user);
    }
    @Test
    public void testSelect3(){
        //查询年龄在20到30之间的用户个数
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        Integer count=userMapper.selectCount(wrapper);
        System.out.println(count);
    }
    //模糊查询
    @Test
    public void testSelect4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("username","1") //相当于not like %1%
                .likeRight("password","e"); //相当于like e%
        //List<User> users = userMapper.selectList(wrapper);
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }
    //模糊查询
    @Test
    public void testSelect5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id在子查询中查出
        wrapper.inSql("id","select id from user where id<5");
        //List<User> users = userMapper.selectList(wrapper);
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    @Test
    public void testSelect6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过id进行排序
        wrapper.orderByAsc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
