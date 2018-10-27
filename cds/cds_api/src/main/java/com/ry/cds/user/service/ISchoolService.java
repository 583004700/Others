package com.ry.cds.user.service;

import com.ry.cds.user.bo.School;

/**
 * 学校业务接口
 * 
 * @author 幸仁强
 *
 */
public interface ISchoolService {
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
