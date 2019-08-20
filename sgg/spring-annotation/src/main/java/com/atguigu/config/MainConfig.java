package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configurable  //告诉spring这是一个配置类
@ComponentScans(
        value={
                @ComponentScan(value="com.atguigu",includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class, Service.class})},useDefaultFilters = false)
        }
)
//@ComponentScan(value="com.atguigu",includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class, Service.class})},useDefaultFilters = false)
public class MainConfig {

    //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
    @Bean("person")
    public Person person01(){
        return new Person("lisi",20);
    }
}
