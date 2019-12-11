package com.cimc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

// springboot启动注解
@SpringBootApplication
// mybatis需要扫描dao层
@MapperScan(value = "com.cimc.dao")
// 开启定时任务
@EnableScheduling
// 开启异步调用方法
@EnableAsync
public class start {
    public static void main(String[] args){

        SpringApplication.run(start.class, args);
    }
}
