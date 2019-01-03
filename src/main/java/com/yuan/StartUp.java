package com.yuan;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.yuan.mapper")
//开启定时任务
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class StartUp {

    public static void main(String[] args) {
        System.out.println("~~~开始启动~~~");
        SpringApplication.run(StartUp.class, args);
    }
}
