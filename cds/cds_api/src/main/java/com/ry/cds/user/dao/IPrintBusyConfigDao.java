package com.ry.cds.user.dao;

import com.ry.cds.user.bo.PrintBusyConfig;

/**
 * 学校持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IPrintBusyConfigDao {
	/**
	 * 根据SchoolID获取忙时配置
	 * 
	 * @return PrintBusyConfig
	 * @throws Exception 
	 */
	public PrintBusyConfig getBySchoolID(long schoolID) throws Exception;
}