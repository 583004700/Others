package com.ry.cds.print.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.print.mapper.PrintTaskMapper;
import com.ry.cds.springbootframe.datasource.DatabaseType;
import com.ry.cds.springbootframe.datasource.MyDataSource;

@Repository
public class PrintTaskDao implements IPrintTaskDao {
	@Autowired
	PrintTaskMapper printTaskMapper;

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public long getTimestamp() {
		return printTaskMapper.getTimestamp();
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public int printTaskMigrate(long timestamp) {
		return printTaskMapper.printTaskMigrate(timestamp);
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public int removeMigratedPrintTask(long timestamp) {
		return printTaskMapper.removeMigratedPrintTask(timestamp);
	}

}