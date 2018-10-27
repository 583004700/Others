package com.ry.xk.common.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ry.xk.common.bo.SystemConfigRaw;

/**
 * SystemConfig配置表持久层
 * @author 幸仁强
 */
@Mapper
public interface SystemConfigMapper {
	/**
	 * 查询所有SystemConfig配置
	 * @return SystemConfig集合
	 */
	public List<SystemConfigRaw> systemConfigs();
}
