package com.ry.cds.user.dao;

import com.ry.cds.user.bo.ClassRoom;

/**
 * 班级持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IClassRoomDao {
	/**
	 * 根据主键获取班级信息
	 * 
	 * @param classRoomID
	 * @return
	 * @throws Exception
	 */
	public ClassRoom get(long classRoomID) throws Exception;

	/**
	 * 根据班级编号获取班级信息
	 * 
	 * @param classRoomCode
	 * @return
	 * @throws Exception
	 */
	public ClassRoom getByClassRoomCode(String classRoomCode) throws Exception;

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