package com.ry.cds.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.user.bo.School;

/**
 * 学校Mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface SchoolMapper {

	/**
	 * 根据主键获取学校信息
	 * 
	 * @param schoolID
	 * @return
	 */
	public School get(long schoolID);

	/**
	 * 根据学校编号获取学校主键
	 * 
	 * @param schoolCode
	 * @return
	 */
	public long getPrimaryBySchoolCode(@Param("schoolCode") String schoolCode);

	/**
	 * 插入学校信息
	 * 
	 * @param school
	 * @return
	 */
	public int insert(School school);

	/**
	 * 更新学校信息
	 * 
	 * @param school
	 * @return
	 */
	public int update(School school);

}