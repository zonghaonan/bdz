package com.example.bdz;

import com.example.bdz.pojo.GwRoleMenu;
import com.example.bdz.service.GwRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {

    @Autowired
    GwRoleMenuService gwRoleMenuService;
    @org.junit.jupiter.api.Test
    void test(){
        for (int i = 50; i < 97; i++) {
            GwRoleMenu gwRoleMenu=new GwRoleMenu();
            gwRoleMenu.setRoleId(2);
            gwRoleMenu.setMenuId(i);
            gwRoleMenuService.save(gwRoleMenu);
        }
    }
}
