package com.ry.xk.common.dao;

import java.util.List;

import com.ry.xk.common.bo.CouchBaseConfig;

public interface ICouchBaseConfigDao {
	/**
	 * 查询所有有效的couchbaseconfig配置
	 * 
	 * @return couchbaseconfig集合
	 */
	public List<CouchBaseConfig> couchBaseConfigs();
}
