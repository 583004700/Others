package com.ry.cds.print.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.print.bo.PrintTask;

/**
 * 打印任务表mapper
 * 
 * @author Administrator
 *
 */
@Mapper
public interface PrintTaskMapper {

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
	public PrintTask get(@Param("printTaskID") long printTaskID);

	/**
	 * 获取重试次数
	 * 
	 * @param printTaskID
	 * @return
	 */
	public int getRetryCount(@Param("printTaskID") long printTaskID);

	/**
	 * 根据ClusterID获取打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public PrintTask getByClusterID(@Param("clusterID") long clusterID);

	/**
	 * 根据SchoolID获取打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public PrintTask getBySchoolID(@Param("schoolID") long schoolID);

	/**
	 * 根据ClusterID更新打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public int updateByClusterID(PrintTask printTask);

	/**
	 * 根据SchoolID更新打印任务
	 * 
	 * @param userId
	 * @return
	 */
	public int updateBySchoolID(PrintTask printTask);

}