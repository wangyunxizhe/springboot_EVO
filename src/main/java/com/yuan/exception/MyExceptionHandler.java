package com.yuan.exception;

import com.yuan.dto.MyJsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangy on 2018/11/19.
 * <p>
 * 统一的异常捕获类
 */
//该注解表示此类是一个助手类
@ControllerAdvice
public class MyExceptionHandler {

    //自定义发生异常时，跳转的页面：error.html
    public static final String ERROR_VIEW = "error";

    //正常请求出异常时会调用的方法，因为此类中只能有一个此注解，
    // 为演示第二个方法，所以在这里把该方法上的注解注释了
//    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", reqest.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }

    /**
     * 判断是否是ajax请求
     */
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

    //正常请求以及Ajax请求出异常时，都可以用的方法
    @ExceptionHandler(value = Exception.class)
    public Object errorHandlerEVO(HttpServletRequest reqest,
                                  HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        if (isAjax(reqest)) {
            return MyJsonResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

}
