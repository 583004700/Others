package com.demo.javaConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拓展springmvc的配置
@Configuration
public class MySpringMvcConfig extends WebMvcConfigurerAdapter{
    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//                System.out.println(o.getClass().getName());
//                System.out.println(((HandlerMethod)o).getBeanType());
//                System.out.println(((HandlerMethod)o).getMethod());
//                System.out.println("preHandle"+this);
//                httpServletRequest.getRequestDispatcher("index.html").forward(httpServletRequest,httpServletResponse);
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

            }
        };
        //registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
    }
}
