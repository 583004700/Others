package com.ry.cds.print.bo;

import java.io.Serializable;
import java.util.List;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 学校下的集群对象
 * 
 * @author Administrator
 *
 */
public class SchoolClusterObject implements Serializable, ICouchBaseStoredObject {

	private static final long serialVersionUID = 1L;
	@Tag(1)
	private long schoolID;
	@Tag(2)
	private List<Cluster> clusterList;

	public long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	public List<Cluster> getClusterList() {
		return clusterList;
	}

	public void setClusterList(List<Cluster> clusterList) {
		this.clusterList = clusterList;
	}

	private static String _key = "SchoolClusterObject_%s";

	@Override
	public String key() {
		return String.format(keyFormat(), schoolID);
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
