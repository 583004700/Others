package com.ry.cds.print.bo;

/**
 * 打印机获取任务接口输出实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class PrinterGetTaskOutput {
	//结果代码：N失败 , Y成功
	private String result;
	//打印结果后台通知的地址
	private String notifyUrl;
	//打印页数
	private String printCount;
	//打印份数
	private String copyCount;
	//打印文件url
	private String printDataUrl;
	//外部订单号(任务Id)
	private String extOrderNo;
	//签名
	private String signStr;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getPrintCount() {
		return printCount;
	}

	public void setPrintCount(String printCount) {
		this.printCount = printCount;
	}

	public String getCopyCount() {
		return copyCount;
	}

	public void setCopyCount(String copyCount) {
		this.copyCount = copyCount;
	}

	public String getPrintDataUrl() {
		return printDataUrl;
	}

	public void setPrintDataUrl(String printDataUrl) {
		this.printDataUrl = printDataUrl;
	}

	public String getExtOrderNo() {
		return extOrderNo;
	}

	public void setExtOrderNo(String extOrderNo) {
		this.extOrderNo = extOrderNo;
	}

	public String getSignStr() {
		return signStr;
	}

	public void setSignStr(String signStr) {
		this.signStr = signStr;
	}

}
