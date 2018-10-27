package com.ry.cds.user.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.mapper.UserBulkProcessMapper;

@Repository
public class UserBulkProcessDao implements IUserBulkProcessDao {

	@Autowired
	UserBulkProcessMapper bulkProcessMapper;

	/**
	 * 导入本地文件到mysql数据库
	 */
	@Override
	public int bulkInsert(Map<String, String> map) {
		return bulkProcessMapper.bulkInsert(map);
	}
}
