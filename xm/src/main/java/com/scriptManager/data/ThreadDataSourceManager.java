package com.scriptManager.data;

import javax.sql.DataSource;

public class ThreadDataSourceManager {
    private static ThreadLocal<String> dataSourceThreadLocal = new ThreadLocal<String>();
    private static ThreadLocal<String> test = new ThreadLocal<String>();

    public static String get(){
        String d = dataSourceThreadLocal.get();
        return d;
    }

    public static void remove(){
        dataSourceThreadLocal.remove();
    }

    /**
     * 切换数据源
     * @param key
     */
    public static void set(String key){
        DataSource ds = DataSourceMap.getDataSource(key);
        dataSourceThreadLocal.set(key);
    }

    public static void main(String[] args) {
        dataSourceThreadLocal.set("sdfsf");
        System.out.println(dataSourceThreadLocal.get());
        System.out.println(dataSourceThreadLocal.get());
        test.set("sdflasfd");
        System.out.println(test.get());
        dataSourceThreadLocal.remove();
        System.out.println(test.get());
        System.out.println(dataSourceThreadLocal.get());
    }
}
