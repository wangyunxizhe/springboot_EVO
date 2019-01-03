package com.yuan.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wangy on 2018/11/19.
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截器按照顺序执行
         */
        // 此写法/*/**表示拦截所有的请求
        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
                .addPathPatterns("/one/**");
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");

        super.addInterceptors(registry);
    }

}
