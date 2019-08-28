package com.atguigu.tx;

import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 声明式事务
 */
@Configuration
public class TxConfig {

    public DataSource dataSource(){
        return null;
    }
}
