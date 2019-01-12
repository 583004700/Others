package scriptManager.data;

import com.jolbox.bonecp.BoneCPDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 根据参数获取数据源
 */

public class DataSourceManager {
    public static Lock lock = new ReentrantLock();

    public static ConcurrentHashMap<String,DataSource> dataSources = new ConcurrentHashMap<String,DataSource>();

    public static DataSource getDataSource(String jdbcDriverClassName,String jdbcUrl,String jdbcUsername,String jdbcPassword){
        BoneCPDataSource boneCPDataSource = null;
        lock.lock();
        try {
            String key = jdbcDriverClassName + jdbcUrl + jdbcUsername + jdbcPassword;
            if (dataSources.containsKey(key)) {
                return dataSources.get(key);
            }
            boneCPDataSource = new BoneCPDataSource();
            // 数据库驱动
            boneCPDataSource.setDriverClass(jdbcDriverClassName);
            // 相应驱动的jdbcUrl
            boneCPDataSource.setJdbcUrl(jdbcUrl);
            // 数据库的用户名
            boneCPDataSource.setUsername(jdbcUsername);
            // 数据库的密码
            boneCPDataSource.setPassword(jdbcPassword);
            // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
            boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
            // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
            boneCPDataSource.setIdleMaxAgeInMinutes(30);
            // 每个分区最大的连接数
            boneCPDataSource.setMaxConnectionsPerPartition(20);
            // 每个分区最小的连接数
            boneCPDataSource.setMinConnectionsPerPartition(5);
            dataSources.put(key, boneCPDataSource);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return boneCPDataSource;
    }

    public static Connection getConnection(String jdbcDriverClassName,String jdbcUrl,String jdbcUsername,String jdbcPassword) throws SQLException {
        return getDataSource(jdbcDriverClassName,jdbcUrl,jdbcUsername,jdbcPassword).getConnection();
    }
}
