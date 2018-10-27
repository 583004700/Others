package com.ry.cds.user.bo;

import java.io.Serializable;

/**
 * 班级信息实体类
 * 
 * @author 幸仁强
 *
 */
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;
	// 区域id，主键自增
	private long locationID;
	// 地区编码，采用全国统一编码
	private String locationCode;
	// 地区名称
	private String locationName;
	// 地区的父级id
	private String parentLocationID;
	// 状态
	private int statusFlag;

	public long getLocationID() {
		return locationID;
	}

	public void setLocationID(long locationID) {
		this.locationID = locationID;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getParentLocationID() {
		return parentLocationID;
	}

	public void setParentLocationID(String parentLocationID) {
		this.parentLocationID = parentLocationID;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

}
