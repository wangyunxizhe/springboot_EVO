package com.yuan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 获取资源文件中设置的自定义属性值
 * <p>
 * Created by wangy on 2018/11/16.
 */
@Configuration
@ConfigurationProperties(prefix = "com.yuan.opensource")
@PropertySource(value = "classpath:resources.properties")
public class ResourcesPro {

    private String name;
    private String website;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
