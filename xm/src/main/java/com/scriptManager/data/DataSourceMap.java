package com.scriptManager.data;

import com.alibaba.fastjson.JSONObject;
import com.common.util.FileUtil;
import com.scriptManager.entity.DataSourceEntity;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class DataSourceMap {
    public static HashMap<String, DataSource> datasources = new HashMap<>();
    public static String defaultDataSource = "defaultDataSource";
    static {
        String fileName = "jdbc.json";
        InputStream inputStream = DataSourceMap.class.getClassLoader().getResourceAsStream(fileName);
        try {
            if(inputStream == null) {
                File file = new File(fileName);
                inputStream = new FileInputStream(file);
            }
            String jdbcJsonStr = FileUtil.readString(inputStream);
            System.out.println(jdbcJsonStr);
            List<DataSourceEntity> dataSources = JSONObject.parseArray(jdbcJsonStr, DataSourceEntity.class);

            for (int i = 0; i < dataSources.size(); i++) {
                DataSourceEntity dataSourceEntity = dataSources.get(i);
                datasources.put(dataSourceEntity.getKey(), DataSourceManager.getDataSource(dataSourceEntity.getJdbcDriverClassName(), dataSourceEntity.getJdbcUrl(), dataSourceEntity.getJdbcUsername(), dataSourceEntity.getJdbcPassword()));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(String key){
        return datasources.get(key);
    }

    public static String getDatabaseProductName(String key){
        String databaseProductName = "";
        Connection con = null;
        try {
            con = datasources.get(key).getConnection();
            DatabaseMetaData metaData = con.getMetaData();
            databaseProductName = metaData.getDatabaseProductName();
        }catch (Exception e){

        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // ignored
                }
            }
        }
        return databaseProductName;
    }
}
