package com.yuan.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * springboot异步任务
 * <p>
 * 异步任务：当几个任务同时执行时（AsyncTaskController中将该类中的3个方法，在一个类方法中同时调用），
 * 如下3个任务为异步任务时，需要1秒可全部执行完毕。
 * 若不是异步任务的话则需要2.3秒才可全部执行完毕（1000+700+600）
 * 使用场景：发送短信/发送邮件/App消息推送/节省运维凌晨发布任务时间提供效率
 */
@Component
public class AsyncTask {

    @Async
    public Future<Boolean> doTask11() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask22() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask33() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(600);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

}
