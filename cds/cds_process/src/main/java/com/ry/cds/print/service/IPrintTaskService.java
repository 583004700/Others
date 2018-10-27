package com.ry.cds.print.service;

/**
 * 打印任务业务接口
 * 
 * @author 幸仁强
 *
 */
public interface IPrintTaskService {
	/**
	 * 运行打印任务迁移定时任务
	 */
	public void runPrintTaskMigrateTask();
}
