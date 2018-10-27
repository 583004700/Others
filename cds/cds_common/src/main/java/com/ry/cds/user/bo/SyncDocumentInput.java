package com.ry.cds.user.bo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 同步文档接口输入实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class SyncDocumentInput implements Serializable {
	private static final long serialVersionUID = 1L;
	// 用户编号
	@NotBlank(message = "userCode不允许为空")
	private String userCode;
	// 文档id
	@NotBlank(message = "documentId不允许为空")
	private String documentId;
	// 文档名称
	@NotBlank(message = "documentName不允许为空")
	private String documentName;
	// 文档类型 1表示作业，2表示提分策报告，3作业答题卡
	@NotNull(message = "documentType不允许为空")
	private int documentType;
	// 文档页数
	@NotNull(message = "documentPageCount不允许为空")
	private int documentPageCount;
	// 创建人
	@NotBlank(message = "creatorName不允许为空")
	private String creatorName;
	// 创建时间 yyyy-MM-dd HH:mm:ss
	@NotBlank(message = "createDateTime不允许为空")
	private String createDateTime;
	// 文件下载链接
	@NotBlank(message = "downloadUrl不允许为空")
	private String downloadUrl;
	// 备案结果通知地址
	private String notifyUrl;
	// 考试批次号
	private String examNo;
	// 考试名称
	private String examName;
	// 学科
	private String subject;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public int getDocumentType() {
		return documentType;
	}

	public void setDocumentType(int documentType) {
		this.documentType = documentType;
	}

	public int getDocumentPageCount() {
		return documentPageCount;
	}

	public void setDocumentPageCount(int documentPageCount) {
		this.documentPageCount = documentPageCount;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getExamNo() {
		return examNo;
	}

	public void setExamNo(String examNo) {
		this.examNo = examNo;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
