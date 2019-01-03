package com.yuan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Date;

/**
 * Created by wangy on 2018/11/16.
 */
public class User {

    private String name;

    //此注解表示在返回前端的json中不显示属性pwd
    @JsonIgnore
    private String pwd;

    private Integer age;

    //此注解表示在返回前端的json中将birthday属性值格式化
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "GMT+8")
    private Date birthday;

    //此注解表示当属性desc为null时，不显示在返回给前端的json中
    @JsonInclude(Include.NON_NULL)
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
