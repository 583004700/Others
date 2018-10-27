package com.ry.cds.user.bo;

import java.io.Serializable;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 文档信息实体类
 * 
 * @author 幸仁强
 *
 */
public class Document implements Serializable, ICouchBaseStoredObject {
	private static final long serialVersionUID = 1L;
	// 文档id，主键自增
	@Tag(1)
	private long documentID;
	// 文档类型，1标识题集，2标识提分策报告，3标识答题卡，4标识错题本
	@Tag(2)
	private int documentTypeID;
	// 文档所属的用户id，对应user表主键
	@Tag(3)
	private long userID;
	// 来源的文档id，第三方文档标识，可以为空
	@Tag(4)
	private String sourceCode;
	// 文档的原始地址
	@Tag(5)
	private String sourceUrl;
	// PDF的文档地址
	@Tag(6)
	private String pdfUrl;
	// 文档最终打印地址
	@Tag(7)
	private String printUrl;
	// 文档页数
	@Tag(8)
	private int pageCount;
	// 已打印的文档页数
	@Tag(9)
	private int printedPageCount;
	// 文档名称
	@Tag(10)
	private String documentName;
	// 创建人标识，第三方平台创建人标识
	@Tag(11)
	private String sourceCreator;
	// 文档状态 1-待转换 2-待打印 99-转换失败
	@Tag(12)
	private int statusFlag;
	// 文档打印状态
	@Tag(13)
	private int printStatus;
	// 文档的学科id
	@Tag(14)
	private long courseID;
	// 文档所属的考试批次编号，可以为空
	@Tag(15)
	private String examNo;
	// 文档的考试批次名称
	@Tag(16)
	private String examName;
	// 文档的打印时间
	@Tag(17)
	private String printDateTime;
	// 信息，打印失败可能产生的信息
	@Tag(18)
	private String failedMessage;
	// 文档的创建时间
	@Tag(19)
	private String createDateTime;
	// 文档的更新时间
	@Tag(20)
	private String updateDateTime;

	public long getDocumentID() {
		return documentID;
	}

	public void setDocumentID(long documentID) {
		this.documentID = documentID;
	}

	public int getDocumentTypeID() {
		return documentTypeID;
	}

	public void setDocumentTypeID(int documentTypeID) {
		this.documentTypeID = documentTypeID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getPdfUrl() {
		return pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	public String getPrintUrl() {
		return printUrl;
	}

	public void setPrintUrl(String printUrl) {
		this.printUrl = printUrl;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPrintedPageCount() {
		return printedPageCount;
	}

	public void setPrintedPageCount(int printedPageCount) {
		this.printedPageCount = printedPageCount;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getSourceCreator() {
		return sourceCreator;
	}

	public void setSourceCreator(String sourceCreator) {
		this.sourceCreator = sourceCreator;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

	public int getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(int printStatus) {
		this.printStatus = printStatus;
	}

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
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

	public String getPrintDateTime() {
		return printDateTime;
	}

	public void setPrintDateTime(String printDateTime) {
		this.printDateTime = printDateTime;
	}

	public String getFailedMessage() {
		return failedMessage;
	}

	public void setFailedMessage(String failedMessage) {
		this.failedMessage = failedMessage;
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

	private static String _key = "Document_%s";

	@Override
	public String key() {
		return String.format(keyFormat(), documentID);
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
