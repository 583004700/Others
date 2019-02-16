package com.common.plugins;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}
), @Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}
)})
public class MyPageInterceptor extends PageInterceptor {
    public static PageInterceptor pageInterceptor;
    public static Properties properties;

    public MyPageInterceptor(){
        //引用创建的插件
        pageInterceptor = this;
    }

    public void setProperties(Properties properties) {
        super.setProperties(properties);
        MyPageInterceptor.properties = properties;
    }

    public Object intercept(Invocation invocation) throws Throwable {
        flushProperties();
        return super.intercept(invocation);
    }

    public static void flushProperties(){
        MyPageInterceptor.pageInterceptor.setProperties(MyPageInterceptor.properties);
    }
}
