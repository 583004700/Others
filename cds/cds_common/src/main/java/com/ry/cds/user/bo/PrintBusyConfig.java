package com.ry.cds.user.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 用户信息实体类
 * 
 * @author 幸仁强
 *
 */
@Component
public class PrintBusyConfig implements Serializable, ICouchBaseStoredObject {
	private static final long serialVersionUID = 1L;

	// 学校id
	@Tag(1)
	private long schoolID;
	// 状态
	@Tag(2)
	private int statusFlag;
	// 开始时间
	@Tag(3)
	private String startDateTime;
	// 结束时间
	@Tag(4)
	private String endDateTime;

	public long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	private static String _key = "PrintBusyConfig_%s";

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
		return CouchBaseSectionType.USER;
	}
}