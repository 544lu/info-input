package com.example.info;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.info.repository") //设置mapper接口的扫描包
public class InfoInputApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfoInputApplication.class, args);
    }

}
