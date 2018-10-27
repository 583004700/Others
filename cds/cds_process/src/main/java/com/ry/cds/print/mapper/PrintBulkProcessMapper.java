package com.ry.cds.print.mapper;

import java.util.Map;

import org.mapstruct.Mapper;

@Mapper
public interface PrintBulkProcessMapper {
	/**
	 * 导入本地文件到mysql数据库
	 */
	public int bulkInsert(Map<String, String> map);
}
