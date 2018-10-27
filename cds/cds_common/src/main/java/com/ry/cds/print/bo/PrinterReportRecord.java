package com.ry.cds.print.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 打印机状态上报 MQ消息实体类
 * 
 * @author 幸仁强
 *
 */
@Component
public class PrinterReportRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private String reportDateTime;
	private long printerID;
	private int printerStatus;
	private String statusCode;
	private int printedTotalPageCount;
	private int errorPaperCount;
	private int carryPaperCount;
	private int paperBoxRemain;
	private int tonerRemain;
	private int wasteRemain;
	private int drumRemain;
	private int inkboxPrintedCount;
	private int inkboxReaminPrintCount;
	private String inkboxSN;
	private int inkboxStatus;
	private String ip;
	private String wifiSsid;
	private String wifiPassword;
	private String lng;
	private String lat;

	public String getReportDateTime() {
		return reportDateTime;
	}

	public void setReportDateTime(String reportDateTime) {
		this.reportDateTime = reportDateTime;
	}

	public long getPrinterID() {
		return printerID;
	}

	public void setPrinterID(long printerID) {
		this.printerID = printerID;
	}

	public int getPrinterStatus() {
		return printerStatus;
	}

	public void setPrinterStatus(int printerStatus) {
		this.printerStatus = printerStatus;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public int getPrintedTotalPageCount() {
		return printedTotalPageCount;
	}

	public void setPrintedTotalPageCount(int printedTotalPageCount) {
		this.printedTotalPageCount = printedTotalPageCount;
	}

	public int getErrorPaperCount() {
		return errorPaperCount;
	}

	public void setErrorPaperCount(int errorPaperCount) {
		this.errorPaperCount = errorPaperCount;
	}

	public int getCarryPaperCount() {
		return carryPaperCount;
	}

	public void setCarryPaperCount(int carryPaperCount) {
		this.carryPaperCount = carryPaperCount;
	}

	public int getPaperBoxRemain() {
		return paperBoxRemain;
	}

	public void setPaperBoxRemain(int paperBoxRemain) {
		this.paperBoxRemain = paperBoxRemain;
	}

	public int getTonerRemain() {
		return tonerRemain;
	}

	public void setTonerRemain(int tonerRemain) {
		this.tonerRemain = tonerRemain;
	}

	public int getWasteRemain() {
		return wasteRemain;
	}

	public void setWasteRemain(int wasteRemain) {
		this.wasteRemain = wasteRemain;
	}

	public int getDrumRemain() {
		return drumRemain;
	}

	public void setDrumRemain(int drumRemain) {
		this.drumRemain = drumRemain;
	}

	public int getInkboxPrintedCount() {
		return inkboxPrintedCount;
	}

	public void setInkboxPrintedCount(int inkboxPrintedCount) {
		this.inkboxPrintedCount = inkboxPrintedCount;
	}

	public int getInkboxReaminPrintCount() {
		return inkboxReaminPrintCount;
	}

	public void setInkboxReaminPrintCount(int inkboxReaminPrintCount) {
		this.inkboxReaminPrintCount = inkboxReaminPrintCount;
	}

	public String getInkboxSN() {
		return inkboxSN;
	}

	public void setInkboxSN(String inkboxSN) {
		this.inkboxSN = inkboxSN;
	}

	public int getInkboxStatus() {
		return inkboxStatus;
	}

	public void setInkboxStatus(int inkboxStatus) {
		this.inkboxStatus = inkboxStatus;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getWifiSsid() {
		return wifiSsid;
	}

	public void setWifiSsid(String wifiSsid) {
		this.wifiSsid = wifiSsid;
	}

	public String getWifiPassword() {
		return wifiPassword;
	}

	public void setWifiPassword(String wifiPassword) {
		this.wifiPassword = wifiPassword;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.reportDateTime).append("\t");
		stringBuilder.append(this.printerID).append("\t");
		stringBuilder.append(this.printerStatus).append("\t");
		stringBuilder.append(this.statusCode).append("\t");
		stringBuilder.append(this.printedTotalPageCount).append("\t");
		stringBuilder.append(this.errorPaperCount).append("\t");
		stringBuilder.append(this.carryPaperCount).append("\t");
		stringBuilder.append(this.paperBoxRemain).append("\t");
		stringBuilder.append(this.tonerRemain).append("\t");
		stringBuilder.append(this.wasteRemain).append("\t");
		stringBuilder.append(this.drumRemain).append("\t");
		stringBuilder.append(this.inkboxPrintedCount).append("\t");
		stringBuilder.append(this.inkboxReaminPrintCount).append("\t");
		stringBuilder.append(this.inkboxSN).append("\t");
		stringBuilder.append(this.inkboxStatus).append("\t");
		stringBuilder.append(this.ip).append("\t");
		stringBuilder.append(this.wifiSsid).append("\t");
		stringBuilder.append(this.wifiPassword).append("\t");
		stringBuilder.append(this.lng).append("\t");
		stringBuilder.append(this.lat).append("\n");
		return stringBuilder.toString();
	}

}