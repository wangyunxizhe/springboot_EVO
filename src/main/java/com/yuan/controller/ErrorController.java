package com.yuan.controller;

import com.yuan.dto.MyJsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 演示会发生异常的类
 * <p>
 * 当发生异常时，会统一被MyExceptionHandler捕获，并处理。不会将报错信息直接显示在页面上
 */
@Controller
@RequestMapping("/err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {
        int a = 1 / 0;
        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxerror")
    public String ajaxerror() {
        return "thymeleaf/ajaxerror";
    }

    @RequestMapping("/getAjaxerror")
    @ResponseBody
    public MyJsonResult getAjaxerror() {
        int a = 1 / 0;
        return MyJsonResult.ok();
    }
}
