package com.ry.cds.print.bo;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 打印机机组
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class Cluster implements ICouchBaseStoredObject {
	// 打印机群组Id
	@Tag(1)
	private long clusterID;
	// 打印机群组名称
	@Tag(2)
	private String clusterName;
	// 打印机组类型 1普通机组，2演示机组，3打印中心机组
	@Tag(3)
	private int clusterTypeID;
	// 备注
	@Tag(4)
	private String remark;
	// 状态1正常，
	@Tag(5)
	private int statusFlag;
	@Tag(6)
	private String createDateTime;
	@Tag(7)
	private String updateDateTime;

	public long getClusterID() {
		return clusterID;
	}

	public void setClusterID(long clusterID) {
		this.clusterID = clusterID;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public int getClusterTypeID() {
		return clusterTypeID;
	}

	public void setClusterTypeID(int clusterTypeID) {
		this.clusterTypeID = clusterTypeID;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	private static String _key = "Cluster_%s";

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
