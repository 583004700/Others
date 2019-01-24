package com.scriptManager.data;

import javax.sql.DataSource;

public class ThreadDataSourceManager {
    private static ThreadLocal<String> dataSourceThreadLocal = new ThreadLocal<String>();

    public static String get(){
        return dataSourceThreadLocal.get();
    }

    public static void set(String key){
        DataSource ds = DataSourceMap.getDataSource(key);
        dataSourceThreadLocal.set(key);
    }
}
