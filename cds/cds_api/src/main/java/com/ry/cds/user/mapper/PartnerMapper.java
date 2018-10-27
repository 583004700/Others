package com.ry.cds.user.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ry.cds.user.bo.Partner;

/**
 * SystemConfig配置表持久层
 * 
 * @author 幸仁强
 */
@Mapper
public interface PartnerMapper {
	/**
	 * 查询所有Partner
	 * 
	 * @return Partner集合
	 */
	public List<Partner> partners();
}
