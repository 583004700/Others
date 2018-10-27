package com.ry.cds.springbootframe.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "common")
@PropertySource("classpath:common.properties")
// @Profile("dev")
public class CommonConfig {
	private Map<String, Object> ftpMap;

	private Map<String, Object> filePath;

	public Map<String, Object> getFtpMap() {
		return ftpMap;
	}

	public void setFtpMap(Map<String, Object> ftpMap) {
		this.ftpMap = ftpMap;
	}

	public Map<String, Object> getFilePath() {
		return filePath;
	}

	public void setFilePath(Map<String, Object> filePath) {
		this.filePath = filePath;
	}

}
