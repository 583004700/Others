package com.ry.cds.print.bo;

import java.io.Serializable;

/**
 * 打印任务
 * 
 * @author 幸仁强
 * @createTime 2018-03-09
 */
public class PrintTask implements Serializable {

	private static final long serialVersionUID = 1L;
	// 主键自增
	private long printTaskID;
	// 打印记录id
	private long printRecordID;
	// 卡号
	private String cardNo;
	// 文档ID
	private long documentID;
	// 学校ID
	private long schoolID;
	// 打印机群ID
	private long clusterID;
	// 打印机ID
	private long printerID;
	// 1.待打印 2.被打印机获取3.打印成功4.打印失败
	private int taskStatus;
	// 该任务打印完成的页数
	private int printedPageCount;
	// 该任务打印完成的起始页
	private int printedStartPage;
	// 该任务打印完成结束页
	private int printedEndPage;
	// 该任务打印需要的页数
	private int printPageCount;
	// 该任务需要打印的起始页
	private int printStartPage;
	// 该任务需要打印的结束页
	private int printEndPage;
	private String createDateTime;
	private String updateDateTime;
	// 任务异常消息
	private String failedMessage;
	// 任务重试次数
	private int retryCount;

	public long getPrintTaskID() {
		return printTaskID;
	}

	public void setPrintTaskID(long printTaskID) {
		this.printTaskID = printTaskID;
	}

	public long getPrintRecordID() {
		return printRecordID;
	}

	public void setPrintRecordID(long printRecordID) {
		this.printRecordID = printRecordID;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public long getDocumentID() {
		return documentID;
	}

	public void setDocumentID(long documentID) {
		this.documentID = documentID;
	}

	public long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	public long getClusterID() {
		return clusterID;
	}

	public void setClusterID(long clusterID) {
		this.clusterID = clusterID;
	}

	public long getPrinterID() {
		return printerID;
	}

	public void setPrinterID(long printerID) {
		this.printerID = printerID;
	}

	public int getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}

	public int getPrintedPageCount() {
		return printedPageCount;
	}

	public void setPrintedPageCount(int printedPageCount) {
		this.printedPageCount = printedPageCount;
	}

	public int getPrintedStartPage() {
		return printedStartPage;
	}

	public void setPrintedStartPage(int printedStartPage) {
		this.printedStartPage = printedStartPage;
	}

	public int getPrintedEndPage() {
		return printedEndPage;
	}

	public void setPrintedEndPage(int printedEndPage) {
		this.printedEndPage = printedEndPage;
	}

	public int getPrintPageCount() {
		return printPageCount;
	}

	public void setPrintPageCount(int printPageCount) {
		this.printPageCount = printPageCount;
	}

	public int getPrintStartPage() {
		return printStartPage;
	}

	public void setPrintStartPage(int printStartPage) {
		this.printStartPage = printStartPage;
	}

	public int getPrintEndPage() {
		return printEndPage;
	}

	public void setPrintEndPage(int printEndPage) {
		this.printEndPage = printEndPage;
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

	public String getFailedMessage() {
		return failedMessage;
	}

	public void setFailedMessage(String failedMessage) {
		this.failedMessage = failedMessage;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

}
