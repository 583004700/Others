package com.ry.cds.user.bo;

import java.io.Serializable;

public class DocumentPrintRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	private long printRecordID;
	private long createUserID;
	private String comment;
	private long documentID;
	private long totalPrice;
	private long unitPrice;
	private int printPageCount;
	private int statusFlag;
	private int printStatus;
	private String failedMessage;
	private String createDateTime;
	private String updateDateTime;
	public long getPrintRecordID() {
		return printRecordID;
	}
	public void setPrintRecordID(long printRecordID) {
		this.printRecordID = printRecordID;
	}
	public long getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(long createUserID) {
		this.createUserID = createUserID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public long getDocumentID() {
		return documentID;
	}
	public void setDocumentID(long documentID) {
		this.documentID = documentID;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(long unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getPrintPageCount() {
		return printPageCount;
	}
	public void setPrintPageCount(int printPageCount) {
		this.printPageCount = printPageCount;
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
	
	

}
