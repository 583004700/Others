package com.ry.cds.print.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.print.dao.IPrintTaskDao;

@Service("printTaskService")
public class PrintTaskService implements IPrintTaskService {
	private static Logger log = LoggerFactory.getLogger(PrintTaskService.class);
	@Autowired
	IPrintTaskDao printTaskDao;

	@Override
	public void runPrintTaskMigrateTask() {
		long timestamp = printTaskDao.getTimestamp();
		int migratedCount = printTaskDao.printTaskMigrate(timestamp);
		int removedCount = printTaskDao.removeMigratedPrintTask(timestamp);
		log.info(String.format("迁移%s条数据", migratedCount));
		log.info(String.format("迁移后删除%s条数据", removedCount));
	}
}