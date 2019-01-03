package com.yuan.controller;

import com.yuan.dto.MyJsonResult;
import com.yuan.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * Created by wangy on 2018/11/16.
 */
@RestController
@RequestMapping("/hello")
public class UserController {

    @RequestMapping("/getUser")
    public User getUser() {
        User u = new User();
        u.setName("wyuan");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPwd("123456");
        return u;
    }

    @RequestMapping("/getBetterUser")
    public MyJsonResult getBetterUser(){
        User u = new User();
        u.setName("wyuan");
        u.setAge(18);
        u.setBirthday(new Date());
        u.setPwd("123456");
        u.setDesc("看你显不显示");
        return  MyJsonResult.ok(u);
    }

}
