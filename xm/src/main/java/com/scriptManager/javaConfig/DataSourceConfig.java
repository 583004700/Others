package com.scriptManager.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.scriptManager.data.DataSourceMap;
import com.scriptManager.data.DynamicDataSource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration //通过该注解表明该类是一个spring配置，相当于一个xml文件
//@ComponentScan(basePackages = "scriptManager.javaConfig") //配置扫描包
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        //默认数据源
        DataSource boneCPDataSource = DataSourceMap.getDataSource(DataSourceMap.defaultDataSource);
        //动态数据源
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources((Map)DataSourceMap.datasources);
        //设置默认数据源
        dataSource.setDefaultTargetDataSource(boneCPDataSource);
        return dataSource;
    }
}
