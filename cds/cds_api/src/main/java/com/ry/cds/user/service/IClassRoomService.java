package com.ry.cds.user.service;

import com.ry.cds.user.bo.ClassRoom;

/**
 * 班级业务接口
 * 
 * @author 幸仁强
 *
 */
public interface IClassRoomService {
	/**
	 * 插入班级信息
	 * 
	 * @param school
	 * @return
	 */
	public long insert(ClassRoom classRoom) throws Exception;

	/**
	 * 更新班级信息
	 * 
	 * @param school
	 * @return
	 */
	public int update(ClassRoom classRoom) throws Exception;
}
