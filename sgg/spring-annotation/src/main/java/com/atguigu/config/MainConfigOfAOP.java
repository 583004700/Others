package com.atguigu.config;

import com.atguigu.aop.LogAspects;
import com.atguigu.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 1、导入aop模块：Spring AOP:(spring-aspects)
 * 2、定义一个业务逻辑类（MathCalculator）：在业务逻辑运行的时候将日志进行打印（方法之前、方法结束、方法出现异常时等）
 * 3、定义一个日志切面类（LogAspects）：切面类里面的方法需要动态感知MathCalculator.div运行
 *      通知方法：
 *          前置通知：logStart：在目标方法运行之前运行
 *          后置通知：logEnd：在目标方法运行结束之后运行
 *          返回通知：logReturn：在目标方法正常返回之后运行
 *          异常通知：logException：在目标方法出现异常以后运行
 *          环绕通知：
 * 4、给切面类的目标方法标注何时何地运行（通知注解）
 * 5、将切面类和业务逻辑类（目标方法所在的类）都加入到容器中
 * 6、必须告诉Spring哪个是切面类（给切面类加一个注解）
 * 7、给配置类中加@EnableAspectJAutoProxy
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    //业务逻辑类加入容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    //切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
