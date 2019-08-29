package com.atguigu.ext;

import com.atguigu.bean.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扩展原理：
 * BeanPostProcessor:bean后置处理器，bean创建对象初始化前后进行拦截工作的
 * BeanFactoryPostProcessor:beanFactory的后置处理器
 *      在beanFactory标准初始化后调用；所有的bean定义已经保存加载到beanFactory，但bean的实例未创建
 * 1)、ioc容器创建对象
 * 2)、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessors
 *      如何找到所有的BeanFactoryPostProcessors并执行他们的方法
 *          1)、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *          2)、在初始化创建其他组件前面执行
 *
 * 2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      postProcessBeanDefinitionRegistry();
 *      在所有bean定义信息将要被加载，bean实例还未创建的时候执行
 *
 *      优先于BeanFactoryPostProcessor执行；利用BeanDefinitionRegistryPostProcessor给容器中额外添加一些组件；
 */
@ComponentScan("com.atguigu.ext")
@Configuration
public class ExtConfig {
    @Bean
    public Blue blue(){
        return new Blue();
    }
}
