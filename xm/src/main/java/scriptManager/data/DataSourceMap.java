package scriptManager.data;

import com.alibaba.fastjson.JSONObject;
import scriptManager.entity.DataSourceEntity;
import scriptManager.util.FileUtil;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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
}
