package com.ry.cds.user.bo;

import java.io.Serializable;

/**
 * 用户和班级的关系实体类
 * 
 * @author 幸仁强
 *
 */
public class ClassRoomUser implements Serializable {
	private static final long serialVersionUID = 1L;
	// 班级id，主键自增
	private long classRoomID;
	// 用户ID
	private long userID;
	// 用户类型
	private int userTypeID;
	// 老师的类型，如：班主任
	private int teacherTypeID;
	// 0表示退出班级，1表示在班级
	private int statusFlag;
	// 创建时间
	private String createDateTime;
	// 更新时间
	private String updateDateTime;

	public long getClassRoomID() {
		return classRoomID;
	}

	public void setClassRoomID(long classRoomID) {
		this.classRoomID = classRoomID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public int getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}

	public int getTeacherTypeID() {
		return teacherTypeID;
	}

	public void setTeacherTypeID(int teacherTypeID) {
		this.teacherTypeID = teacherTypeID;
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
}
