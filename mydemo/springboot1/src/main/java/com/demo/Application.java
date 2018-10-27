package com.demo;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

import java.util.HashMap;
import java.util.function.Function;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class, MybatisAutoConfiguration.class})
@EnableCaching
public class Application/* extends SpringBootServletInitializer*/
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Application.class);
//    }

}
