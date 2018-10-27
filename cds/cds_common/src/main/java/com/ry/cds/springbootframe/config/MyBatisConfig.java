package com.ry.cds.springbootframe.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ry.cds.springbootframe.datasource.AbstractBatisBaseConfig;

/**
 * springboot集成mybatis的基本入口 1）创建数据源 2）创建SqlSessionFactory
 */
@Configuration
@PropertySource("classpath:datasource.properties")
@MapperScan(basePackages = "com.ry.**.mapper")
public class MyBatisConfig extends AbstractBatisBaseConfig {
}