package com.ry.cds.print.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.print.dao.IPrintBulkProcessDao;

@Service
public class PrintBulkProcessService implements IPrintBulkProcessService {
	@Autowired
	IPrintBulkProcessDao printBulkProcessDao;

	/**
	 * 导入本地文件到mysql数据库
	 */
	@Override
	public int bulkInsert(String fileUrl, String tableName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("fileUrl", fileUrl);
		map.put("tableName", tableName);
		return printBulkProcessDao.bulkInsert(map);
	}
}
