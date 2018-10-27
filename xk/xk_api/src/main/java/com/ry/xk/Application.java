package com.ry.xk;

import javax.servlet.DispatcherType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.filter.DelegatingFilterProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication // same as @Configuration+@EnableAutoConfiguration+@ComponentScan
@EnableSwagger2 // 启动swagger注解
@EnableCaching // 启动缓存
@EnableAsync // 开启异步
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    /**
     * requestBaseBo数据填充过滤器注册
     * 
     * @Title: requestBaseFilterRegistrationBean
     * @author 幸仁强
     * @return
     */
    @Bean
    public FilterRegistrationBean requestBaseFilterRegistrationBean()
    {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DelegatingFilterProxy("requestBaseFilter"));
        filterRegistrationBean.addInitParameter("targetFilterLifecycle", "true");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistrationBean;
    }

    @Bean(name = "requestBaseFilter")
    public RequestBaseFilter requestBaseFilter()
    {
        return new RequestBaseFilter();
    }
}