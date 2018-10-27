package com.ry.cds.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.user.bo.SchoolPriceConfig;

/**
 *  学校机构的打印价格配置表Mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface SchoolPriceConfigMapper {

	/**
	 * 根据主键获取学校机构的打印价格配置信息
	 * 
	 * @param map
	 * @return
	 */
	public SchoolPriceConfig get(@Param("schoolID") long schoolID);

}