package com.ry.cds.print.bo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 打印机状态上报接口输入实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class PrinterStateReportInput {
	// 版本号，本文档该接口版本为1.0
	@NotBlank(message = "version不允许为空")
	private String version;
	// 字符集：UTF8, GBK
	@NotBlank(message = "charset不允许为空")
	private String charset;
	// 语言：中文CN
	@NotBlank(message = "language不允许为空")
	private String language;
	// 签名
	@NotBlank(message = "signStr不允许为空")
	private String signStr;
	// 合作伙伴标识,宜联提供
	@NotBlank(message = "partner不允许为空")
	private String partner;
	// 时间戳 必须保证每条数据唯一
	@NotBlank(message = "timestamp不允许为空")
	private String timestamp;
	// 打印机唯一标识
	@NotBlank(message = "printDevSn不允许为空")
	private String printDevSn;
	// 打印机类型：ES(黑白激光打印机)EM(黑白激光一体机)EC(彩色照片打印机)
	@NotBlank(message = "printerType不允许为空")
	private String printerType;
	// 打印机连接 router 后，router分配给打印机的
	@NotBlank(message = "printInnerIp不允许为空")
	private String printInnerIp;
	// Idle 正常，可打印、 Busy 打印中 、Error 打印机故障
	@NotBlank(message = "errorCode不允许为空")
	private String errorCode;
	// 打印机状态 -1：正常，其他为不正常
	@NotBlank(message = "printStatus不允许为空")
	private String printStatus;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSignStr() {
		return signStr;
	}

	public void setSignStr(String signStr) {
		this.signStr = signStr;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getPrintDevSn() {
		return printDevSn;
	}

	public void setPrintDevSn(String printDevSn) {
		this.printDevSn = printDevSn;
	}

	public String getPrinterType() {
		return printerType;
	}

	public void setPrinterType(String printerType) {
		this.printerType = printerType;
	}

	public String getPrintInnerIp() {
		return printInnerIp;
	}

	public void setPrintInnerIp(String printInnerIp) {
		this.printInnerIp = printInnerIp;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

}
