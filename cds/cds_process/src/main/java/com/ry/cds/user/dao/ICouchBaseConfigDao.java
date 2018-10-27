package com.ry.cds.user.dao;

import java.util.List;

import com.ry.cds.user.bo.CouchBaseConfig;


public interface ICouchBaseConfigDao {
	/**
	 * 查询所有有效的couchbaseconfig配置
	 * 
	 * @return couchbaseconfig集合
	 */
	public List<CouchBaseConfig> couchBaseConfigs();
}
