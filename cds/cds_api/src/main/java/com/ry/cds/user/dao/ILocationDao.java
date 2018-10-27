package com.ry.cds.user.dao;

/**
 * 班级持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface ILocationDao {
	/**
	 * 根据locationCode获取主键
	 * 
	 * @param locationCode
	 * @return
	 */
	public long getPrimaryByLocationCode(String locationCode);
}