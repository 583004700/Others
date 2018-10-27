package com.ry.cds.user.bo;

import javax.validation.constraints.NotNull;

/**
 * 更新文档接口输入实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class UpdateDocumentInput {
	// 文档Id
	@NotNull(message = "documentID不允许为空")
	private String documentID;
	// prnUrl
	private String prnUrl;
	// statusFlag
	@NotNull(message = "statusFlag不允许为空")
	private int statusFlag;

	public String getDocumentID() {
		return documentID;
	}

	public void setDocumentID(String documentID) {
		this.documentID = documentID;
	}

	public String getPrnUrl() {
		return prnUrl;
	}

	public void setPrnUrl(String prnUrl) {
		this.prnUrl = prnUrl;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

}
