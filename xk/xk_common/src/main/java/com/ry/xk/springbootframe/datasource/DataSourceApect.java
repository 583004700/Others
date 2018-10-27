package com.ry.xk.springbootframe.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ry.xk.common.DatabaseType;

@Aspect
@Component
@Order(1)
public class DataSourceApect
{

    private static final Logger log = LoggerFactory.getLogger(DataSourceApect.class);

    @Before("execution(* com.ry.*.*.dao.*.*(..))")
    public void setDataSourceKey(JoinPoint point)
    {
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        MyDataSource ds = method.getDeclaredAnnotation(MyDataSource.class);
        if (null == ds)
        {
            if (log.isDebugEnabled())
            {
                log.debug("如获取不到MyDataSource类注解，则从目标类获取。");
            }
            try
            {
                Class<?> targetClass = point.getTarget().getClass();
                Method targetMethod = targetClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
                if (null != targetMethod)
                {
                    ds = targetMethod.getDeclaredAnnotation(MyDataSource.class);
                }
            }
            catch (Exception e)
            {
                log.error("获取目标类注解失败。", e);
            }
        }
        if (null != ds && DatabaseType.EXAMRESULT.equals(ds.type()))
        {
            log.debug("使用PRINTDB");
            DatabaseContextHolder.setDatabaseType(DatabaseType.EXAMRESULT);
        }
        else
        {
            log.debug("使用USERDB");
            DatabaseContextHolder.setDatabaseType(DatabaseType.MAIN);
        }
    }

    @After("execution(* com.ry.*.*.dao.*.*(..))")
    public void after(JoinPoint point)
    {
        DatabaseContextHolder.clearDatabaseType();
    }

}
