package com.ry.cds.user.dao;

import java.util.Map;


public interface IUserBulkProcessDao {
	/**
	 * 导入本地文件到mysql数据库
	 */
	public int bulkInsert(Map<String, String> map);
}
