package com.demo.javaconfig;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//拓展springmvc的配置
@Configuration
public class MySpringMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        SerializerFeature[] serializerFeatures = {SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue};
        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
    }

//    @Bean //消息转换器
//    public HttpMessageConverters fastJsonHttpMessageConverter(){
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        SerializerFeature[] serializerFeatures = {SerializerFeature.PrettyFormat,SerializerFeature.WriteMapNullValue};
//        fastJsonConfig.setSerializerFeatures(serializerFeatures);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        return new HttpMessageConverters(fastJsonHttpMessageConverter);
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
                String name = httpServletRequest.getParameter("name");
                if("zy".equals(name) || "zwb".equals(name)) {
                    System.out.println("remoteAddr-----------" + httpServletRequest.getRemoteAddr());
                    System.out.println("remoteHost-----------" + httpServletRequest.getRemoteHost());
                    System.out.println("remoteHost-----------" + httpServletRequest.getRemoteHost());
                    System.out.println("ip-----------" + getIpAddress(httpServletRequest));
                    return true;
                }
                httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), "无权限");
                return false;
            }

            public String getIpAddress(HttpServletRequest request) {
                        String ip = request.getHeader("x-forwarded-for");
                        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                                ip = request.getHeader("Proxy-Client-IP");
                        }
                if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                                ip = request.getHeader("WL-Proxy-Client-IP");
                            }
                        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                                ip = request.getHeader("HTTP_CLIENT_IP");
                            }
                         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                                 ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                            }
                        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                                ip = request.getRemoteAddr();
                           }
               return ip;
            }

            @Override
            public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

            }

            @Override
            public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

            }
        };
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
    }
}
