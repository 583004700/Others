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
public class User implements Serializable, ICouchBaseStoredObject {
	private static final long serialVersionUID = 1L;

	// 用户标识，主键自增
	@Tag(1)
	private long userID;
	// 用户名称
	@Tag(2)
	private String userName;
	// 用户类型，1老师，2学生
	@Tag(3)
	private int userTypeID;
	// 卡编号
	@Tag(4)
	private String cardNo;
	// 所在学校id
	@Tag(5)
	private long schoolID;
	// 性别
	@Tag(6)
	private int sex;
	// 用户编号 学号/工号
	@Tag(7)
	private String userCode;
	// 学段
	@Tag(8)
	private int courseTypeID;
	// 生日
	@Tag(9)
	private String birthday;
	// 入学时间
	@Tag(10)
	private String admissionTime;
	// 打印标识，用于标识特定打印集群的用户，1标识校内打印（演示账号）
	@Tag(11)
	private int printFlag;
	// 联系方式，手机号码
	@Tag(12)
	private String mobile;
	// 来源平台的用户标识
	@Tag(13)
	private int userSourceID;
	// 状态
	@Tag(14)
	private int statusFlag;
	// 创建时间
	@Tag(15)
	private String createDateTime;
	// 更新时间
	@Tag(16)
	private String updateDateTime;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserTypeID() {
		return userTypeID;
	}

	public void setUserTypeID(int userTypeID) {
		this.userTypeID = userTypeID;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getCourseTypeID() {
		return courseTypeID;
	}

	public void setCourseTypeID(int courseTypeID) {
		this.courseTypeID = courseTypeID;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(String admissionTime) {
		this.admissionTime = admissionTime;
	}

	public int getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(int printFlag) {
		this.printFlag = printFlag;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getUserSourceID() {
		return userSourceID;
	}

	public void setUserSourceID(int userSourceID) {
		this.userSourceID = userSourceID;
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

	private static String _key = "User_%s";

	@Override
	public String key() {
		return String.format(keyFormat(), userID);
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