package com.ry.cds.print.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.print.mapper.PrintBulkProcessMapper;
import com.ry.cds.springbootframe.datasource.DatabaseType;
import com.ry.cds.springbootframe.datasource.MyDataSource;

@Repository
public class PrintBulkProcessDao implements IPrintBulkProcessDao {

	@Autowired
	PrintBulkProcessMapper printBulkProcessMapper;

	/**
	 * 导入本地文件到mysql数据库
	 */
	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public int bulkInsert(Map<String, String> map) {
		return printBulkProcessMapper.bulkInsert(map);
	}
}
