package com.demo.javaconfig;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)  //统一异常处理
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest request,Exception e){
        return "对不起，服务器繁忙，请稍候再试";
    }
}
