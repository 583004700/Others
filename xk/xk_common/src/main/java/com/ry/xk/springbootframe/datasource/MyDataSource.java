package com.ry.xk.springbootframe.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ry.xk.common.DatabaseType;

/**
 * 在方法上使用，用于指定使用哪个数据源
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyDataSource {

    DatabaseType type() default DatabaseType.MAIN;

}
