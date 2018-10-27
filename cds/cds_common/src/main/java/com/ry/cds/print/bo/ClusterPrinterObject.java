package com.ry.cds.print.bo;

import java.io.Serializable;
import java.util.List;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 机组下的打印机集合对象
 * 
 * @author Administrator
 *
 */
public class ClusterPrinterObject implements Serializable, ICouchBaseStoredObject {

	private static final long serialVersionUID = 1L;
	//集群ID
	@Tag(1)
	private long clusterID;
	//打印机集合
	@Tag(2)
	List<Printer> printerList;

	public long getClusterID() {
		return clusterID;
	}

	public void setClusterID(long clusterID) {
		this.clusterID = clusterID;
	}

	public List<Printer> getPrinterList() {
		return printerList;
	}

	public void setPrinterList(List<Printer> printerList) {
		this.printerList = printerList;
	}

	private static String _key = "ClusterPrinterObject__%s";

	@Override
	public String key() {
		return String.format(keyFormat(), clusterID);
	}

	@Override
	public String keyFormat() {
		return _key;
	}

	@Override
	public CouchBaseSectionType couchbaseSection() {
		return CouchBaseSectionType.PRINT;
	}
}
