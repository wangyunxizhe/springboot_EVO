package com.yuan.interceptor;

import com.yuan.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangy on 2018/11/19.
 */
@Controller
@RequestMapping("/two")
public class TwoController {

    @RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("name", "wangy66");
        return "thymeleaf/index";
    }

    @RequestMapping("/center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("/test")
    public String test(ModelMap map) {
        SysUser user = new SysUser();
        user.setAge(18);
        user.setUsername("manager");
        user.setPassword("123456");
        user.setRegistTime(new Date());
        map.addAttribute("user", user);
        SysUser u1 = new SysUser();
        u1.setAge(19);
        u1.setUsername("yuan");
        u1.setPassword("123456");
        u1.setRegistTime(new Date());
        SysUser u2 = new SysUser();
        u2.setAge(17);
        u2.setUsername("王渊");
        u2.setPassword("123456");
        u2.setRegistTime(new Date());
        List<SysUser> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);
        map.addAttribute("userList", userList);
        return "thymeleaf/test";
    }

    @PostMapping("/postform")
    public String postform(SysUser user) {
        System.out.println(user.getUsername());
        return "redirect:/th/test";
    }

}
