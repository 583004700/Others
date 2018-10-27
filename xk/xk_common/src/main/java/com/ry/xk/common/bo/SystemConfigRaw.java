package com.ry.xk.common.bo;

import java.io.Serializable;

public class SystemConfigRaw implements Serializable {
	private static final long serialVersionUID = -3124823891987804463L;
	private int configID;
	private String configName;
	private String configValue;
	private String description;

	public int getConfigID() {
		return configID;
	}

	public void setConfigID(int configID) {
		this.configID = configID;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
