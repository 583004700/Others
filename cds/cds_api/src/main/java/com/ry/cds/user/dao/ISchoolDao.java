package com.ry.cds.user.dao;

import com.ry.cds.user.bo.School;

/**
 * 学校持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface ISchoolDao {
	/**
	 * 根据主键获取学校信息
	 * 
	 * @param schoolID
	 * @return
	 * @throws Exception
	 */
	public School get(long schoolID) throws Exception;

	/**
	 * 根据学校编号获取学校信息
	 * 
	 * @param schoolCode
	 * @return
	 * @throws Exception
	 */
	public School getBySchoolCode(String schoolCode) throws Exception;

	/**
	 * 插入学校信息
	 * 
	 * @param school
	 * @return
	 */
	public long insert(School school) throws Exception;

	/**
	 * 更新学校信息
	 * 
	 * @param school
	 * @return
	 */
	public int update(School school) throws Exception;
}