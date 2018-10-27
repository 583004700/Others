package com.ry.cds.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.user.bo.PrintBusyConfig;

/**
 * SystemConfig配置表持久层
 * 
 * @author 幸仁强
 */
@Mapper
public interface PrintBusyConfigMapper {
	/**
	 * 根据SchoolID获取忙时配置
	 * 
	 * @return PrintBusyConfig
	 */
	public PrintBusyConfig getBySchoolID(@Param("schoolID") long schoolID);
}
