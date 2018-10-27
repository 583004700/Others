package com.ry.cds.user.bo;

import java.io.Serializable;

/**
 * 同步用户结果列表里的详情List<SyncUserResult>
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class SyncUserResult implements Serializable {

	private static final long serialVersionUID = 1L;
	// 时间戳
	private String timestamp;
	// 学号/工号
	private String userCode;
	// 同步状态,R已接收 I同步中 S成功 F失败
	private String syncStatus;
	// 错误描述
	private String errorMessage;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(String syncStatus) {
		this.syncStatus = syncStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
