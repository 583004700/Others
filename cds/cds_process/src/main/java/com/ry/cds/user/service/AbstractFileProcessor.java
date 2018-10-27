package com.ry.cds.user.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractFileProcessor {
	/**
	 * 需要监控的路径
	 * 
	 * @return
	 */
	private String path;

	/**
	 * 文件处理
	 * 
	 * @param file
	 * @return 处理的数量
	 */
	@Async("processExecutor")
	public int process(String fileUrl) {
		return 0;
	}

	/**
	 * 是否处理完
	 * 
	 * @return
	 */
	private boolean isBusy;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isBusy() {
		return isBusy;
	}

	public void setBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}

}
