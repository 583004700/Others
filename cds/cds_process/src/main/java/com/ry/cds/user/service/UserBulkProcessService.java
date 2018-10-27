package com.ry.cds.user.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.user.dao.IUserBulkProcessDao;

@Service
public class UserBulkProcessService implements IUserBulkProcessService {
	@Autowired
	IUserBulkProcessDao userBulkProcessDao;

	@Override
	/**
	 * 导入本地文件到mysql数据库
	 */
	public int bulkInsert(String fileUrl, String tableName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("fileUrl", fileUrl);
		map.put("tableName", tableName);
		return userBulkProcessDao.bulkInsert(map);
	}
}
