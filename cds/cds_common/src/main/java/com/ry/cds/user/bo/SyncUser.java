package com.ry.cds.user.bo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 同步用户列表详情List<SyncUser>
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class SyncUser implements Serializable {

	private static final long serialVersionUID = 1L;
	// 时间戳 必须保证每条数据唯一
	@NotBlank(message="时间戳不允许为空")
	private String timestamp;
	// 省代码
	private String provinceCode;
	// 省名称
	private String provinceName;
	// 市代码
	private String cityCode;
	// 市名称
	private String cityName;
	// 区县代码
	private String countyCode;
	// 区县名称
	private String countyName;
	// 学校编码
	@NotBlank(message="schoolCode不允许为空")
	private String schoolCode;
	// 学校名称
	@NotBlank(message="schoolName不允许为空")
	private String schoolName;
	// 学段
	@NotNull(message="period不允许为空")
	private int period;
	// 学科
	@NotNull(message="subject不允许为空")
	private int subject;
	// 年级
	@NotNull(message="grade不允许为空")
	private int grade;
	// 年级名称
	@NotBlank(message="gradeName不允许为空")
	private String gradeName;
	// 班级编号
	@NotBlank(message="period不允许为空")
	private String classCode;
	// 班级名称
	@NotBlank(message="className不允许为空")
	private String className;
	// 入学时间 yyyy-MM-dd
	private String admissionTime;
	// 学号/工号
	@NotBlank(message="userCode不允许为空")
	private String userCode;
	// 学生姓名/老师姓名
	@NotBlank(message="userName不允许为空")
	private String userName;
	// 用户类型
	@NotNull(message = "userType不能为空")
	private int userType;
	// 手机号
	private String mobile;
	// 性别
	private int sex;
	// 生日 yyyy-MM-dd
	private String birthday;
	// 是否校内打印用户标识，showFlag=1表示该用户文档采用校内打印
	private String showFlag;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
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

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getSubject() {
		return subject;
	}

	public void setSubject(int subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(String admissionTime) {
		this.admissionTime = admissionTime;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

}
