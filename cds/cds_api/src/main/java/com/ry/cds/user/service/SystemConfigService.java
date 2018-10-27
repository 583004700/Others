package com.ry.cds.user.service;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ry.cds.user.bo.SystemConfig;
import com.ry.cds.user.bo.SystemConfigRaw;
import com.ry.cds.user.dao.ISystemConfigDao;

@Service
public class SystemConfigService implements ISystemConfigService {
	@Autowired
	private ISystemConfigDao systemConfigDao;

	@Cacheable(value = "systemConfig")
	@Override
	public SystemConfig systemConfigs() throws Exception {
		return resultListToEntity(systemConfigDao.systemConfigs(), SystemConfig.class);
	}

	/**
	 * 根据systemConfig配置表数据反射出一个配置实体
	 * 
	 * @param systemConfigRawList
	 * @param cls
	 *            反射得到的实体类Clazz
	 * @return 反射得到的实体类
	 * @throws Exception
	 */
	private SystemConfig resultListToEntity(List<SystemConfigRaw> systemConfigRawList, Class<?> cls) throws Exception {
		SystemConfig systemConfig = new SystemConfig();
		// 取得Method
		Method[] methods = cls.getMethods();// 获得bean的所有方法
		for (SystemConfigRaw systemConfigRaw : systemConfigRawList) {
			// 当前列名
			String colName = systemConfigRaw.getConfigName();
			// 设置方法名
			String setMethodName = "set" + colName;
			// 遍历Method
			Method setMethod = null;
			for (int j = 0; j < methods.length; j++) {
				if (methods[j].getName().equalsIgnoreCase(setMethodName)) { // 比较列名
					setMethodName = methods[j].getName();
					setMethod = methods[j];
					String parameterType = methods[j].getGenericParameterTypes()[0].toString();
					// 获取当前位置的值，返回Object类型
					if (parameterType.equals("class java.lang.String")) {
						String value = systemConfigRaw.getConfigValue();
						if (value == null) {
							continue;
						}
						// 实行Set方法
						// // 利用反射获取对象
						// JavaBean内部属性和ResultSet中一致时候
						setMethod.invoke(systemConfig, value);
					}
					if (parameterType.equals("int")) {
						int value = Integer.parseInt(systemConfigRaw.getConfigValue());
						setMethod.invoke(systemConfig, value);
						break;
					}

				}
			}
		}
		return systemConfig;
	}
}