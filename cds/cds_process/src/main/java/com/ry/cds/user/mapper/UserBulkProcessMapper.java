package com.ry.cds.user.mapper;

import java.util.Map;

import org.mapstruct.Mapper;

@Mapper
public interface UserBulkProcessMapper {
	/**
	 * 导入本地文件到mysql数据库
	 */
	public int bulkInsert(Map<String, String> map);
}
