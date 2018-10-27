package com.ry.cds.user.dao;

import com.ry.cds.user.bo.SchoolPriceConfig;

/**
 *  学校机构的打印价格配置持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface ISchoolPriceConfigDao {
	/**
	 * 根据主键获取 学校机构的打印价格配置信息
	 * 
	 * @param map
	 * @return
	 */
	public SchoolPriceConfig get(long schoolID) throws Exception;
}