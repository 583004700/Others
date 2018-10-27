package com.ry.xk.common.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class CouchBaseConfig implements Serializable {
	private static final long serialVersionUID = 5716226141919572394L;

	private int couchBaseConfigID;

	private String couchBaseConfigName;

	private String couchBaseConfigValue;

	private int enabled;

	public int getCouchBaseConfigID() {
		return couchBaseConfigID;
	}

	public void setCouchBaseConfigID(int couchBaseConfigID) {
		this.couchBaseConfigID = couchBaseConfigID;
	}

	public String getCouchBaseConfigName() {
		return couchBaseConfigName;
	}

	public void setCouchBaseConfigName(String couchBaseConfigName) {
		this.couchBaseConfigName = couchBaseConfigName;
	}

	public String getCouchBaseConfigValue() {
		return couchBaseConfigValue;
	}

	public void setCouchBaseConfigValue(String couchBaseConfigValue) {
		this.couchBaseConfigValue = couchBaseConfigValue;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
