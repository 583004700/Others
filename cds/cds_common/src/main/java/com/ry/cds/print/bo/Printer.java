package com.ry.cds.print.bo;

import java.io.Serializable;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 打印机实体
 * 
 * @author 幸仁强
 *
 */
public class Printer implements Serializable, ICouchBaseStoredObject {
	private static final long serialVersionUID = 1L;
	// 主键自增
	@Tag(1)
	private long printerID;
	// 打印机名称
	@Tag(2)
	private String printName;
	// 打印机的编号
	@Tag(3)
	private String printCode;
	// 打印机设备序列号
	@Tag(4)
	private String printSN;
	// Ip地址
	@Tag(5)
	private String ip;
	// mac地址
	@Tag(6)
	private String mac;
	// 打印机WiFi
	@Tag(7)
	private String wifiSsid;
	// 打印机的wifi密码
	@Tag(8)
	private String wifiPassword;
	// 打印机的类型
	@Tag(9)
	private int printerType;
	// 打印机固件版本
	@Tag(10)
	private String firmwareVersion;
	// 打印机型号
	@Tag(11)
	private String printerModel;
	// 联系人信息
	@Tag(12)
	private String handler;
	// 经度
	@Tag(13)
	private String lng;
	// 纬度
	@Tag(14)
	private String lat;
	// 墨盒序列号
	@Tag(15)
	private String inkboxSN;
	// 墨盒状态，1表示正常，2表示无效
	@Tag(16)
	private int inkboxStatus;
	// 打印机状态，1表示正常，2表示故障，0表示删除
	@Tag(17)
	private int printerStatus;
	// 打印机备注
	@Tag(18)
	private String remark;
	// 打印机的地址
	@Tag(19)
	private String address;
	// 机器状态码
	@Tag(20)
	private String statusCode;
	// 最近一次上报时间
	@Tag(21)
	private String reportDateTime;
	// 剩余纸张数
	@Tag(22)
	private int paperBoxRemain;
	// 创建时间
	@Tag(23)
	private String createDateTime;
	// 更新时间
	@Tag(24)
	private String updateDateTime;

	public long getPrinterID() {
		return printerID;
	}

	public void setPrinterID(long printerID) {
		this.printerID = printerID;
	}

	public String getPrintName() {
		return printName;
	}

	public void setPrintName(String printName) {
		this.printName = printName;
	}

	public String getPrintCode() {
		return printCode;
	}

	public void setPrintCode(String printCode) {
		this.printCode = printCode;
	}

	public String getPrintSN() {
		return printSN;
	}

	public void setPrintSN(String printSN) {
		this.printSN = printSN;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
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

	public int getPrinterType() {
		return printerType;
	}

	public void setPrinterType(int printerType) {
		this.printerType = printerType;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public String getPrinterModel() {
		return printerModel;
	}

	public void setPrinterModel(String printerModel) {
		this.printerModel = printerModel;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
		this.handler = handler;
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

	public int getPrinterStatus() {
		return printerStatus;
	}

	public void setPrinterStatus(int printerStatus) {
		this.printerStatus = printerStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getReportDateTime() {
		return reportDateTime;
	}

	public void setReportDateTime(String reportDateTime) {
		this.reportDateTime = reportDateTime;
	}

	public int getPaperBoxRemain() {
		return paperBoxRemain;
	}

	public void setPaperBoxRemain(int paperBoxRemain) {
		this.paperBoxRemain = paperBoxRemain;
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

	private static String _key = "Printer_%s";

	@Override
	public String key() {
		return String.format(keyFormat(), printerID);
	}

	@Override
	public String keyFormat() {
		return _key;
	}

	@Override
	public CouchBaseSectionType couchbaseSection() {
		return CouchBaseSectionType.PRINT;
	}

}
