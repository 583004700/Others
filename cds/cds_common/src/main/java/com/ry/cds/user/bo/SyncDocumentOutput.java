package com.ry.cds.user.bo;

import java.io.Serializable;

/**
 * 同步文档接口输出实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class SyncDocumentOutput implements Serializable {
	private static final long serialVersionUID = 1L;
	// 结果代码：N失败 , Y成功
	private String result;
	// true, false
	private boolean success;
	// 错误代码
	private String errorCode;
	// 错误信息
	private String errorMsg;

	public SyncDocumentOutput() {
	}

	public SyncDocumentOutput(String result, boolean success, String errorCode, String errorMsg) {
		this.result = result;
		this.success = success;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

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
