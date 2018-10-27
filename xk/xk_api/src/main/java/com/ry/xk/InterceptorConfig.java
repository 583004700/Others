package com.ry.xk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 添加token过滤器
 * 
 * @ClassName: InterceptorConfig
 * @author 幸仁强
 * @date 2018年5月26日
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter
{
    @Bean
    TokenInterceptor tokenInterceptor()
    {
        return new TokenInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**");
    }
}