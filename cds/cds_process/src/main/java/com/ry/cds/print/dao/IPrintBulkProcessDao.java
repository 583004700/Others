package com.ry.cds.print.dao;

import java.util.Map;


public interface IPrintBulkProcessDao {
	/**
	 * 导入本地文件到mysql数据库
	 */
	public int bulkInsert(Map<String, String> map);
}
