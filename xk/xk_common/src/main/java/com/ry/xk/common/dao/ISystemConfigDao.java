package com.ry.xk.common.dao;

import java.util.List;

import com.ry.xk.common.bo.SystemConfigRaw;

/**
 * SystemConfig配置表持久层
 * 
 * @author 幸仁强
 */
public interface ISystemConfigDao {
	/**
	 * 查询所有SystemConfig配置
	 * 
	 * @return SystemConfig集合
	 */
	public List<SystemConfigRaw> systemConfigs();
}
