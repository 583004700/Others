package com.ry.cds.print.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.print.bo.ClusterPrinterObject;
import com.ry.cds.print.bo.Printer;
import com.ry.cds.print.mapper.PrinterMapper;
import com.ry.cds.springbootframe.datasource.DatabaseType;
import com.ry.cds.springbootframe.datasource.MyDataSource;
import com.ry.cds.user.service.CouchBaseFactory;
import com.ry.cds.utils.ListHelper;

@Repository
public class PrinterDao implements IPrinterDao {
	@Autowired
	PrinterMapper printerMapper;

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public Printer get(long printerID) throws Exception {
		Printer printer = new Printer();
		printer.setPrinterID(printerID);
		Printer rtnPrinter = CouchBaseFactory.get(Printer.class, printer.key());
		if (null == rtnPrinter) {
			rtnPrinter = printerMapper.get(printerID);
			if (null != rtnPrinter) {
				CouchBaseFactory.update(rtnPrinter);
			}
		}
		return rtnPrinter;
	}

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public long getPrimaryByPrintSN(String printSN) {
		return printerMapper.getPrimaryByPrintSN(printSN);
	}

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public Printer getByPrintSN(String printSN) throws Exception {
		long printerID = printerMapper.getPrimaryByPrintSN(printSN);
		if (printerID > 0) {
			return get(printerID);
		}
		return null;
	}

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public List<Printer> getByClusterID(long clusterID) throws Exception {
		ClusterPrinterObject clusterPrinterObject = new ClusterPrinterObject();
		clusterPrinterObject.setClusterID(clusterID);
		ClusterPrinterObject returnClusterPrinterObject = CouchBaseFactory.get(ClusterPrinterObject.class,
				clusterPrinterObject.key());
		if (null == returnClusterPrinterObject) {
			returnClusterPrinterObject = new ClusterPrinterObject();
			returnClusterPrinterObject.setClusterID(clusterID);
			List<Printer> printerList = printerMapper.getByClusterID(clusterID);
			if (ListHelper.isNotEmpty(printerList)) {
				returnClusterPrinterObject.setPrinterList(printerList);
				CouchBaseFactory.update(returnClusterPrinterObject);
			}
		}
		return returnClusterPrinterObject.getPrinterList();
	}

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public long getClusterIDByPrinterID(long printerID) throws Exception {
		return printerMapper.getClusterIDByPrinterID(printerID);
	}

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public int update(Printer printer) throws Exception {
		int result = printerMapper.update(printer);
		if (result > 0) {
			CouchBaseFactory.update(printer);
		}
		return result;
	}

}