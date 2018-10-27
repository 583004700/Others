package com.ry.cds.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.SystemConfigRaw;
import com.ry.cds.user.mapper.SystemConfigMapper;

/**
 * SystemConfig配置表持久层
 * 
 * @author 幸仁强
 */
@Repository
public class SystemConfigDao implements ISystemConfigDao {

	@Autowired
	SystemConfigMapper systemConfigMapper;

	/**
	 * 查询所有SystemConfig配置
	 * 
	 * @return SystemConfig集合
	 */
	@Override
	public List<SystemConfigRaw> systemConfigs() {
		return systemConfigMapper.systemConfigs();
	}
}
