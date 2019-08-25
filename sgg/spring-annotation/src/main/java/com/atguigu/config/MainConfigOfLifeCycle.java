package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * bean的生命周期
 *      bean的创建---初始化---销毁的过程
 * 容器管理bean的生命周期
 * 多实例的bean容器不会销毁
 */
@Configurable
public class MainConfigOfLifeCycle {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
