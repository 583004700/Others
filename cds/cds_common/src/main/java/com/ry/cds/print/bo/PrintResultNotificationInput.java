package com.ry.cds.print.bo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 打印机结果通知接口输入实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class PrintResultNotificationInput {
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
	// 打印机设备序列号
	@NotBlank(message = "printDevSn不允许为空")
	private String printDevSn;
	// 外部订单号
	@NotBlank(message = "extOrderNo不允许为空")
	private String extOrderNo;
	// 任务状态PS-成功，PF-失败
	@NotBlank(message = "status不允许为空")
	private String status;
	// 当次打印成功张数
	@NotNull(message = "succCount不允许为空")
	private int succCount;
	// 打印机成功打印面数
	@NotNull(message = "succPaperCount不允许为空")
	private int succPaperCount;
	// 打印机失败打印面数
	@NotNull(message = "errorPaperCount不允许为空")
	private int errorPaperCount;
	// 错误码
	@NotBlank(message = "errorCode不允许为空")
	private String errorCode;
	// 打印机状态
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

	public String getPrintDevSn() {
		return printDevSn;
	}

	public void setPrintDevSn(String printDevSn) {
		this.printDevSn = printDevSn;
	}

	public String getExtOrderNo() {
		return extOrderNo;
	}

	public void setExtOrderNo(String extOrderNo) {
		this.extOrderNo = extOrderNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSuccCount() {
		return succCount;
	}

	public void setSuccCount(int succCount) {
		this.succCount = succCount;
	}

	public int getSuccPaperCount() {
		return succPaperCount;
	}

	public void setSuccPaperCount(int succPaperCount) {
		this.succPaperCount = succPaperCount;
	}

	public int getErrorPaperCount() {
		return errorPaperCount;
	}

	public void setErrorPaperCount(int errorPaperCount) {
		this.errorPaperCount = errorPaperCount;
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
