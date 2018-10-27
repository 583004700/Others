package com.ry.cds.user.bo;

import java.io.Serializable;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 班级信息实体类
 * 
 * @author 幸仁强
 *
 */
public class ClassRoom implements Serializable, ICouchBaseStoredObject {
	private static final long serialVersionUID = 1L;
	// 班级id，主键自增
	@Tag(1)
	private long classRoomID;
	// 来源平台班级标识
	@Tag(2)
	private String classRoomCode;
	// 班级名称
	@Tag(3)
	private String classRoomName;
	// 班级所属学校id
	@Tag(4)
	private long schoolID;
	// 班级类型，1表示正常班级，默认值为1
	@Tag(5)
	private int classRoomTypeID;
	// 状态，0表示删除，1表示正常，2表示升学
	@Tag(6)
	private int statusFlag;
	// 创建时间
	@Tag(7)
	private String createDateTime;
	// 更新时间
	@Tag(8)
	private String updateDateTime;

	public long getClassRoomID() {
		return classRoomID;
	}

	public void setClassRoomID(long classRoomID) {
		this.classRoomID = classRoomID;
	}

	public String getClassRoomCode() {
		return classRoomCode;
	}

	public void setClassRoomCode(String classRoomCode) {
		this.classRoomCode = classRoomCode;
	}

	public String getClassRoomName() {
		return classRoomName;
	}

	public void setClassRoomName(String classRoomName) {
		this.classRoomName = classRoomName;
	}

	public long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	public int getClassRoomTypeID() {
		return classRoomTypeID;
	}

	public void setClassRoomTypeID(int classRoomTypeID) {
		this.classRoomTypeID = classRoomTypeID;
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

	private static String _key = "ClassRoom_%s";

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
