package com.ry.cds.user.bo;

public class SystemConfig {

	private String aliyunAccessId;
	private String aliyunAccessKey;
	private String configKey;
	private String aliyunBaseUrl;
	private String cdsFileBucket;
	private String aliyunDownloadBaseUrl;
	private String printResultReportApiUrl;

	private int retryCount;

	public String getAliyunAccessId() {
		return aliyunAccessId;
	}

	public void setAliyunAccessId(String aliyunAccessId) {
		this.aliyunAccessId = aliyunAccessId;
	}

	public String getAliyunAccessKey() {
		return aliyunAccessKey;
	}

	public void setAliyunAccessKey(String aliyunAccessKey) {
		this.aliyunAccessKey = aliyunAccessKey;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getAliyunBaseUrl() {
		return aliyunBaseUrl;
	}

	public void setAliyunBaseUrl(String aliyunBaseUrl) {
		this.aliyunBaseUrl = aliyunBaseUrl;
	}

	public String getCdsFileBucket() {
		return cdsFileBucket;
	}

	public void setCdsFileBucket(String cdsFileBucket) {
		this.cdsFileBucket = cdsFileBucket;
	}

	public String getAliyunDownloadBaseUrl() {
		return aliyunDownloadBaseUrl;
	}

	public void setAliyunDownloadBaseUrl(String aliyunDownloadBaseUrl) {
		this.aliyunDownloadBaseUrl = aliyunDownloadBaseUrl;
	}

	public String getPrintResultReportApiUrl() {
		return printResultReportApiUrl;
	}

	public void setPrintResultReportApiUrl(String printResultReportApiUrl) {
		this.printResultReportApiUrl = printResultReportApiUrl;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

}
