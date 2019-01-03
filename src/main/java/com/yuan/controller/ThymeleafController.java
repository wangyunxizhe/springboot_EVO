package com.yuan.controller;

import com.yuan.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/th")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-yuan");
        return "thymeleaf/index";
    }

    @RequestMapping("/center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("/test")
    public String test(ModelMap map) {
        User u = new User();
        u.setName("superadmin");
        u.setAge(10);
        u.setPwd("123465");
        u.setBirthday(new Date());
        u.setDesc("<font color='green'><b>hello thymeleaf</b></font>");
        map.addAttribute("user", u);

        User u1 = new User();
        u1.setAge(19);
        u1.setName("wangyuan");
        u1.setPwd("123456");
        u1.setBirthday(new Date());
        User u2 = new User();
        u2.setAge(17);
        u2.setName("yuan.wang");
        u2.setPwd("123456");
        u2.setBirthday(new Date());
        List<User> userList = new ArrayList<>();
        userList.add(u);
        userList.add(u1);
        userList.add(u2);
        map.addAttribute("userList", userList);
        return "thymeleaf/test";
    }

    @PostMapping("/postform")
    public String postform(User u) {
        System.out.println("姓名：" + u.getName());
        System.out.println("年龄：" + u.getAge());
        return "redirect:/th/test";
    }

    @RequestMapping("/showerror")
    public String showerror(User u) {
        int a = 1 / 0;
        return "redirect:/th/test";
    }
}
