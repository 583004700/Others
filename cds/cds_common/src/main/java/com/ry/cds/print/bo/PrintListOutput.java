package com.ry.cds.print.bo;

import java.util.List;

import com.ry.cds.user.bo.UserDocument;

/**
 * 获取用户打印列表及基础信息接口输出实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class PrintListOutput {
	// 结果代码：N失败 , Y成功
	private String result;
	// true, false
	private boolean success;
	// 错误代码
	private String errorCode;
	// 错误信息
	private String errorMsg;
	// 用户姓名
	private String userName;
	// 冻结金额，单位：元
	private double freezeAmount;
	// 余额，单位：元
	private double balance;
	// 已消费，单位：元
	private double consumeAmount;
	// 打印机群组列表(预留)
	private List<Cluster> clusterList;
	// 用户文档列表
	private List<UserDocument> userDocumentList;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getFreezeAmount() {
		return freezeAmount;
	}

	public void setFreezeAmount(double freezeAmount) {
		this.freezeAmount = freezeAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getConsumeAmount() {
		return consumeAmount;
	}

	public void setConsumeAmount(double consumeAmount) {
		this.consumeAmount = consumeAmount;
	}

	public List<Cluster> getClusterList() {
		return clusterList;
	}

	public void setClusterList(List<Cluster> clusterList) {
		this.clusterList = clusterList;
	}

	public List<UserDocument> getUserDocumentList() {
		return userDocumentList;
	}

	public void setUserDocumentList(List<UserDocument> userDocumentList) {
		this.userDocumentList = userDocumentList;
	}

}
