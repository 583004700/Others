package com.ry.cds.print.bo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 打印机获取打印任务输入参数
 * 
 * @author 幸仁强
 *
 */
public class PrinterGetTaskInput {
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
}
