package com.yuan.controller;

import com.yuan.dto.MyJsonResult;
import com.yuan.entity.SysUser;
import com.yuan.utils.JsonUtils;
import com.yuan.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangy on 2018/11/19.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test1")
    public MyJsonResult test1() {
        strRedis.opsForValue().set("yuan-cache", "hello Redis~~~~~~");
        return MyJsonResult.ok(strRedis.opsForValue().get("yuan-cache"));
    }

    @RequestMapping("/test2")
    public MyJsonResult test2() {
        SysUser user = new SysUser();
        user.setId("100111");
        user.setUsername("y.wang");
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        //将对象转为json，存入redis
        strRedis.opsForValue().set("json:user", JsonUtils.objectToJson(user));
        //从redis中取出对象
        SysUser jsonUser = JsonUtils.jsonToPojo(strRedis.opsForValue().get("json:user"), SysUser.class);
        return MyJsonResult.ok(jsonUser);
    }

    @RequestMapping("/getJsonList")
    public MyJsonResult getJsonList() {
        SysUser user = new SysUser();
        user.setAge(18);
        user.setUsername("王渊");
        user.setPassword("123456");
        user.setRegistTime(new Date());
        SysUser u1 = new SysUser();
        u1.setAge(19);
        u1.setUsername("wangyuan");
        u1.setPassword("123456");
        u1.setRegistTime(new Date());
        SysUser u2 = new SysUser();
        u2.setAge(17);
        u2.setUsername("hello y.wang");
        u2.setPassword("123456");
        u2.setRegistTime(new Date());
        List<SysUser> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("json:info:userlist", JsonUtils.objectToJson(userList), 2000);

        String userListJson = redis.get("json:info:userlist");
        List<SysUser> userListBorn = JsonUtils.jsonToList(userListJson, SysUser.class);

        return MyJsonResult.ok(userListBorn);
    }
}
