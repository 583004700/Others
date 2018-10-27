package com.ry.cds.print.dao;

import com.ry.cds.print.bo.PrintTask;

/**
 * 打印任务持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IPrintTaskDao {
	/**
	 * 插入打印任务
	 * 
	 * @param printTask
	 * @return
	 */
	public int insert(PrintTask printTask);

	/**
	 * 更新打印任务
	 * 
	 * @param printTask
	 * @return
	 */
	public int update(PrintTask printTask);

	/**
	 * 根据主键获取打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public PrintTask get(long printTaskID);

	/**
	 * 获取重试次数
	 * 
	 * @param printTaskID
	 * @return
	 */
	public int getRetryCount(long printTaskID);

	/**
	 * 根据ClusterID获取打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public PrintTask getByClusterID(long clusterID);

	/**
	 * 根据SchoolID获取打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public PrintTask getBySchoolID(long schoolID);

	/**
	 * 根据ClusterID更新打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public PrintTask getAndUpdateByClusterID(long clusterID, long printerID);

	/**
	 * 根据SchoolID更新打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public PrintTask getAndUpdateBySchoolID(long schoolID, long printerID);

}