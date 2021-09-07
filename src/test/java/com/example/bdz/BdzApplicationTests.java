package com.example.bdz;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bdz.mapper.GwUserMapper;
import com.example.bdz.mapper.UserMapper;
import com.example.bdz.pojo.GwUser;
import com.example.bdz.pojo.User;
import com.example.bdz.service.GwUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BdzApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    GwUserService gwUserService;
    @Test
    public void testSelectAll(){
        List<User> users=userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    //测试插入
    @Test
    public void testInsert(){
//        User user=new User();
//        user.setUsername("1234");
//        user.setPassword("1234");
//        int result=userMapper.insert(user); //自动生成id
//        System.out.println(result);  //受影响行数
        GwUser gwUser=new GwUser();
        gwUser.setUsername("1242424");
        gwUser.setPassword("ggrtetre");
        gwUser.setAvatar("/path");
        gwUserService.saveOrUpdate(gwUser);
    }
    //测试更新
    @Test
    public void testUpdate(){
        User user=new User();
        user.setId(4L);
        user.setUsername("12345");
        user.setPassword("12345");
        int result=userMapper.updateById(user);
        System.out.println(result);
    }
    //测试乐观锁成功
    @Test
    public void testOptimisticLocker(){
        //查询用户信息
        User user=userMapper.selectById(1L);
        //修改用户信息
        user.setUsername("1111");
        user.setPassword("1111");
        //执行更新操作
        userMapper.updateById(user);
    }
    //测试乐观锁失败
    @Test
    public void testOptimisticLocker2(){
        User user=userMapper.selectById(1L);
        user.setUsername("11111");
        user.setPassword("11111");
        User user2=userMapper.selectById(1L);
        user2.setUsername("11112");
        user2.setPassword("11112");
        userMapper.updateById(user2);
        userMapper.updateById(user);//如果没有乐观锁，则会覆盖之前的操作
    }
    //测试查询
    @Test
    public void testSelectById(){
        User user=userMapper.selectById(3L);
        System.out.println(user);
    }
    //测试批量查询
    @Test
    public void testSelectByBatchId(){
        List<User> users=userMapper.selectBatchIds(Arrays.asList(1,2,3));
        users.forEach(System.out::println);
    }
    //条件查询map
    @Test
    public void testSelectByBatchIds(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","123");
        map.put("password","1234");
        List<User> users=userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //测试分页查询
    @Test
    public void testPage(){
        //参数一：当前页
        //参数二：页面大小
        Page<User> page=new Page<>(2,5);
        userMapper.selectPage(page,null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }
    //测试删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(3L);
    }
    //测试通过id批量删除
    @Test
    public void testDeleteBatchId(){
        userMapper.deleteBatchIds(Arrays.asList(8,10));
    }
    //通过map删除
    @Test
    public void testDeleteByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","123");
        userMapper.deleteByMap(map);
    }
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Test
    public void pass(){
        String pwd=bCryptPasswordEncoder.encode("123456");
        System.out.println(pwd);
    }
}
