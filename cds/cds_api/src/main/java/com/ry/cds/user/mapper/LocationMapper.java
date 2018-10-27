package com.ry.cds.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * 班级mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface LocationMapper {
	/**
	 * 根据locationCode获取主键
	 * 
	 * @param locationCode
	 * @return
	 */
	public long getPrimaryByLocationCode(@Param("locationCode") String locationCode);

}