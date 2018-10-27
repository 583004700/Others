package com.ry.cds.user.bo;

import java.io.Serializable;
import java.util.List;

/**
 * 同步用户输出实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class SyncUserOutput implements Serializable {
	private static final long serialVersionUID = 1L;
	// 结果代码：N失败 , Y成功
	private String result;
	// true, false
	private boolean success;
	// 成功条数
	private int successCount;
	// 失败条数
	private int failureCount;
	// 错误代码
	private String errorCode;
	// 错误信息
	private String errorMsg;
	// 同步结果详情
	private List<SyncUserResult> list;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}



	public List<SyncUserResult> getList() {
		return list;
	}

	public void setList(List<SyncUserResult> list) {
		this.list = list;
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

}
