package com.ry.xk.common.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.xk.common.bo.SystemConfigRaw;
import com.ry.xk.common.mapper.SystemConfigMapper;

/**
 * SystemConfig配置表持久层
 * 
 * @author 幸仁强
 */
@Repository("systemConfigDao")
public class SystemConfigDao implements ISystemConfigDao {
	//systemConfig持久化对象
	@Autowired
	SystemConfigMapper systemConfigMapper;

	/**
	 *获取所有的系统设置
	 * @return
	 */
	@Override
	public List<SystemConfigRaw> systemConfigs() {
		return systemConfigMapper.systemConfigs();
	}
}
