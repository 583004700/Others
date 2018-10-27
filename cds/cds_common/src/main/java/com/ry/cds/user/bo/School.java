package com.ry.cds.user.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 学校信息实体类
 * 
 * @author 幸仁强
 *
 */
@Component
public class School implements Serializable, ICouchBaseStoredObject {
	private static final long serialVersionUID = 1L;
	// 主键自增
	@Tag(1)
	private long schoolID;
	// 来源平台的学校标识
	@Tag(2)
	private String schoolCode;
	// 学校名称
	@Tag(3)
	private String schoolName;
	// 状态
	@Tag(4)
	private int statusFlag;
	// 地区id，对应location表的主键
	@Tag(5)
	private String locationID;
	// 学校类型，1 K12教育、2 完全中学、 3 初级中学、4 高级中学、5 小学学校
	@Tag(6)
	private int schoolTypeID;
	// 学校地址
	@Tag(7)
	private String address;
	// 取件地址
	@Tag(8)
	private String pickupAddress;
	// 创建时间
	@Tag(9)
	private String createDateTime;
	// 更新时间
	@Tag(10)
	private String updateDateTime;

	public long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getLocationID() {
		return locationID;
	}

	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}

	public int getSchoolTypeID() {
		return schoolTypeID;
	}

	public void setSchoolTypeID(int schoolTypeID) {
		this.schoolTypeID = schoolTypeID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
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

	private static String _key = "School_%s";

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