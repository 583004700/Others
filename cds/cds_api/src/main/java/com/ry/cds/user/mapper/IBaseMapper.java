package com.ry.cds.user.mapper;

import java.util.Map;

import org.mapstruct.Mapper;

@Mapper
public interface IBaseMapper {
	public Map<String, Object> findSingByColumnName(Map<String, String> map);
	public int addOne(Map<String,String> map);
	public int updateOne(Map<String,String> map);
}
