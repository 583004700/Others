package com.ry.cds.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ry.cds.user.bo.CouchBaseConfig;

@Mapper
public interface CouchBaseConfigMapper {
	/**
	 * 查询所有有效的couchbaseconfig配置
	 * 
	 * @return couchbaseconfig集合
	 */
	public List<CouchBaseConfig> couchBaseConfigs();
}
