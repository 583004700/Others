package com.ry.xk.springbootframe.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ry.xk.springbootframe.datasource.AbstractBatisBaseConfig;

/**
 * springboot集成mybatis的基本入口 1）创建数据源 2）创建SqlSessionFactory
 */
@Configuration
@PropertySource(value = { "classpath:config/datasource.properties",
		"file:${spring.profiles.path}/datasource.properties" }, ignoreResourceNotFound = true)
@MapperScan(basePackages = "com.ry.**.mapper")
public class MyBatisConfig extends AbstractBatisBaseConfig {
}