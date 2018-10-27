package com.ry.cds.user.bo;

/**
 * 用户文档列表
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class UserDocument {
	// 文档名称，UTF-8编码
	private String documentName;
	// 宜联平台文档资源编号
	private String documentNo;
	// 文档类型:1 魔题库作业,2 提分策报告,3 答题卡,4 错题本,11 测验报告,12 错题,99 其他
	private String documentType;
	// 文档页数
	private String documentPageCount;
	// 文档打印状态：N 未创建打印任务,P 打印完成 C 已创建打印任务 I 文档部分打印中
	private String printStatus;
	// 打印单价，单位：元
	private double printPrice;
	// 学科
	private String subject;

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentPageCount() {
		return documentPageCount;
	}

	public void setDocumentPageCount(String documentPageCount) {
		this.documentPageCount = documentPageCount;
	}

	public String getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	public double getPrintPrice() {
		return printPrice;
	}

	public void setPrintPrice(double printPrice) {
		this.printPrice = printPrice;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
