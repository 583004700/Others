package com.ry.cds.print.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.print.bo.PrintTask;
import com.ry.cds.print.mapper.PrintTaskMapper;
import com.ry.cds.springbootframe.datasource.DatabaseType;
import com.ry.cds.springbootframe.datasource.MyDataSource;

@Repository
public class PrintTaskDao implements IPrintTaskDao {
	@Autowired
	PrintTaskMapper printTaskMapper;

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public int insert(PrintTask printTask) {
		return printTaskMapper.insert(printTask);
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public int update(PrintTask printTask) {
		return printTaskMapper.update(printTask);
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public PrintTask get(long printTaskID) {
		return printTaskMapper.get(printTaskID);
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public int getRetryCount(long printTaskID) {
		return printTaskMapper.getRetryCount(printTaskID);
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public PrintTask getByClusterID(long clusterID) {
		return printTaskMapper.getByClusterID(clusterID);
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public PrintTask getBySchoolID(long schoolID) {
		return printTaskMapper.getBySchoolID(schoolID);
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public PrintTask getAndUpdateByClusterID(long clusterID, long printerID) {
		PrintTask printTask = new PrintTask();
		printTask.setClusterID(clusterID);
		printTask.setPrinterID(printerID);
		printTaskMapper.updateByClusterID(printTask);
		return this.get(printTask.getPrintTaskID());
	}

	@Override
	@MyDataSource(type = DatabaseType.PRINTDB)
	public PrintTask getAndUpdateBySchoolID(long schoolID, long printerID) {
		PrintTask printTask = new PrintTask();
		printTask.setSchoolID(schoolID);
		printTask.setPrinterID(printerID);
		printTaskMapper.updateBySchoolID(printTask);
		return this.get(printTask.getPrintTaskID());
	}
}