package com.ry.cds.springbootframe.datasource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class AbstractBatisBaseConfig implements EnvironmentAware {
	private static final Logger log = LoggerFactory.getLogger(AbstractBatisBaseConfig.class);
	private Environment env;

	@Override
	public void setEnvironment(final Environment environment) {
		this.env = environment;
	}

	@Bean
	public DataSource userDs() throws Exception {
		Properties props = new Properties();
		props.put("driverClassName", env.getProperty("jdbc.cdsuser.driverClassName"));
		props.put("url", env.getProperty("jdbc.cdsuser.url"));
		props.put("username", env.getProperty("jdbc.cdsuser.username"));
		props.put("password", env.getProperty("jdbc.cdsuser.password"));
		this.setCommonJDBCProperties(props);
		DruidDataSource ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
		// List<Filter> filters = new ArrayList<>();
		// filters.add(wallFilter());
		// ds.setProxyFilters(filters);
		return ds;
	}

	/**
	 * private WallConfig wallConfig() { WallConfig wconfig = new WallConfig();
	 * wconfig.setMultiStatementAllow(true); return wconfig; }
	 * 
	 * private WallFilter wallFilter() { WallFilter wfilter = new WallFilter();
	 * wfilter.setConfig(wallConfig()); return wfilter; }
	 **/

	@Bean
	public DataSource printDs() throws Exception {
		Properties props = new Properties();
		props.put("driverClassName", env.getProperty("jdbc.cdsprint.driverClassName"));
		props.put("url", env.getProperty("jdbc.cdsprint.url"));
		props.put("username", env.getProperty("jdbc.cdsprint.username"));
		props.put("password", env.getProperty("jdbc.cdsprint.password"));
		this.setCommonJDBCProperties(props);
		DruidDataSource ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(props);
		// List<Filter> filters = new ArrayList<>();
		// filters.add(wallFilter());
		// ds.setProxyFilters(filters);
		return ds;
	}

	@Bean
	@Primary
	public DynamicDataSource dataSource(@Qualifier("userDs") DataSource userDs,
			@Qualifier("printDs") DataSource printDs) {
		Map<Object, Object> targetDataSources = new HashMap<Object,Object>();
		targetDataSources.put(DatabaseType.USERDB, userDs);
		targetDataSources.put(DatabaseType.PRINTDB, printDs);

		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
		dataSource.setDefaultTargetDataSource(userDs);// 默认的datasource设置为myTestDbDataSource

		return dataSource;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean(DynamicDataSource ds) {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(ds);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath:com/ry/**/dao/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			log.error("sqlSessionFactory创建失败！");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Bean
	public DataSourceTransactionManager transationManager(DynamicDataSource ds) throws Exception {
		return new DataSourceTransactionManager(ds);
	}

	private void setCommonJDBCProperties(Properties props) {
		props.put("initialSize", env.getProperty("jdbc.initialSize"));
		props.put("minIdle", env.getProperty("jdbc.minIdle"));
		props.put("maxActive", env.getProperty("jdbc.maxActive"));
		props.put("maxWait", env.getProperty("jdbc.maxWait"));
		props.put("validationQuery", env.getProperty("jdbc.validationQuery"));
		props.put("testOnBorrow", env.getProperty("jdbc.testOnBorrow"));
		props.put("testOnReturn", env.getProperty("jdbc.testOnReturn"));
		props.put("testWhileIdle", env.getProperty("jdbc.testWhileIdle"));
		props.put("timeBetweenEvictionRunsMillis", env.getProperty("jdbc.timeBetweenEvictionRunsMillis"));
		props.put("minEvictableIdleTimeMillis", env.getProperty("jdbc.minEvictableIdleTimeMillis"));
		props.put("removeAbandoned", env.getProperty("jdbc.removeAbandoned"));
		props.put("removeAbandonedTimeOut", env.getProperty("jdbc.removeAbandonedTimeOut"));
		props.put("logAbandoned", env.getProperty("jdbc.logAbandoned"));
		props.put("poolPreparedStatements", env.getProperty("jdbc.poolPreparedStatements"));
		props.put("maxPoolPreparedStatementPerConnectionSize",
				env.getProperty("jdbc.maxPoolPreparedStatementPerConnectionSize"));
		props.put("filters", env.getProperty("jdbc.filters"));
	}
}
