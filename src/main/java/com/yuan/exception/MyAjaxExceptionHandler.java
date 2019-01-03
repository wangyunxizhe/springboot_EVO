package com.yuan.exception;

import com.yuan.dto.MyJsonResult;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangy on 2018/11/19.
 * <p>
 * Ajax异常处理类
 */
@RestControllerAdvice
public class MyAjaxExceptionHandler {

    //Ajax请求出异常时会调用的方法，为演示MyExceptionHandler类中的web+Ajax异常统一处理方法，
    //所以在这里把该方法上的注解注释了
//    @ExceptionHandler(value = Exception.class)
    public MyJsonResult defaultErrorHandler(HttpServletRequest req,
                                            Exception e) throws Exception {
        e.printStackTrace();
        return MyJsonResult.errorException(e.getMessage());
    }

}
