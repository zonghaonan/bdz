package com.example.bdz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.bdz.mapper")
public class BdzApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdzApplication.class, args);
    }

}
