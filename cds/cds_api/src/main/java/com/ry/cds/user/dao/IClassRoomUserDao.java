package com.ry.cds.user.dao;

import com.ry.cds.user.bo.ClassRoomUser;

/**
 * 用户班级关系持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IClassRoomUserDao {
	/**
	 * 判断用户班级关系是否已经存在
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isExist(long classRoomID, long userID) throws Exception;

	/**
	 * 插入用户班级关系
	 * 
	 * @param classRoomUser
	 * @return
	 */
	public int insert(ClassRoomUser classRoomUser) throws Exception;
}