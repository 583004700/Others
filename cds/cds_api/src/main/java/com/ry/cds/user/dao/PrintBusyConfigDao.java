package com.ry.cds.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.PrintBusyConfig;
import com.ry.cds.user.mapper.PrintBusyConfigMapper;
import com.ry.cds.user.service.CouchBaseFactory;

@Repository
public class PrintBusyConfigDao implements IPrintBusyConfigDao {
	@Autowired
	PrintBusyConfigMapper printBusyConfigMapper;

	@Override
	public PrintBusyConfig getBySchoolID(long schoolID) throws Exception{
		PrintBusyConfig printBusyConfig = new PrintBusyConfig();
		printBusyConfig.setSchoolID(schoolID);
		PrintBusyConfig rtnPrintBusyConfig = CouchBaseFactory.get(PrintBusyConfig.class, printBusyConfig.key());
		if (null == rtnPrintBusyConfig) {
			rtnPrintBusyConfig = printBusyConfigMapper.getBySchoolID(schoolID);
			if (null != rtnPrintBusyConfig) {
				CouchBaseFactory.update(rtnPrintBusyConfig);
			}
		}
		return rtnPrintBusyConfig;
	}

}