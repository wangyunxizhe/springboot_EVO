package com.yuan.controller;

import com.yuan.dto.MyJsonResult;
import com.yuan.entity.SysUser;
import com.yuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    public MyJsonResult saveUser() throws Exception {
        SysUser user = new SysUser();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("yuan" + new Date());
        user.setNickname("yuan" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.saveUser(user);
        return MyJsonResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public MyJsonResult updateUser() {
        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("1001-updated");
        user.setNickname("1001-updated");
        user.setPassword("1001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.updateUser(user);
        return MyJsonResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser/{userId}")
    public MyJsonResult deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return MyJsonResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById/{userId}")
    public MyJsonResult queryUserById(@PathVariable("userId") String userId) {
        return MyJsonResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public MyJsonResult queryUserList() {
        SysUser user = new SysUser();
        user.setUsername("wangyuan");
        user.setNickname("yuan");
        List<SysUser> userList = userService.queryUserList(user);
        return MyJsonResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged/{page}")
    public MyJsonResult queryUserListPaged(@PathVariable("page") Integer page) {
        if (page == null) {
            page = 1;
        }
        int pageSize = 10;
        SysUser user = new SysUser();
        //查询条件
//		user.setNickname("1001-updated");
        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
        return MyJsonResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom/{userId}")
    public MyJsonResult queryUserByIdCustom(@PathVariable("userId") String userId) {
        return MyJsonResult.ok(userService.queryUserByIdCustom(userId));
    }

    //该方法用于演示事务：userService中的操作是先添加后删除
    @RequestMapping("/saveUserTransactional")
    public MyJsonResult saveUserTransactional() {
        SysUser user = new SysUser();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("y.wang" + new Date());
        user.setNickname("y.wang" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.saveUserTransactional(user);
        return MyJsonResult.ok("保存成功");
    }
}
