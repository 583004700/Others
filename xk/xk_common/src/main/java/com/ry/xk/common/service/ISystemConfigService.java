package com.ry.xk.common.service;

import com.ry.xk.common.bo.SystemConfig;

/**
 * 系统配置表业务类接口
 * @author 幸仁强
 *
 */
public interface ISystemConfigService {
	/**
	 * 获取systemConfig配置表数据反射成的实体类
	 * @return systemConfig配置表数据反射成的实体类
	 * @throws Exception
	 */
	public SystemConfig systemConfigs();

}
