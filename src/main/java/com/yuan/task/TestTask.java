package com.yuan.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * springboot整合定时任务
 */
@Component
public class TestTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定义每过3秒执行任务
//    @Scheduled(fixedRate = 3000)
    //定义从04秒开始到40秒之间循环执行，每隔一秒执行一次
    @Scheduled(cron = "4-40 * * * * ?")
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
