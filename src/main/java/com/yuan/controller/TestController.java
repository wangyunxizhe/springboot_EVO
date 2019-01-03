package com.yuan.controller;

import com.yuan.config.ResourcesPro;
import com.yuan.dto.MyJsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangy on 2018/11/16.
 */
@RestController
public class TestController {

    @Autowired
    private ResourcesPro resourcesPro;

    @RequestMapping("/getResources")
    public MyJsonResult getResources() {
        ResourcesPro resources = new ResourcesPro();
        BeanUtils.copyProperties(resourcesPro, resources);
        return MyJsonResult.ok(resources);
    }

}
