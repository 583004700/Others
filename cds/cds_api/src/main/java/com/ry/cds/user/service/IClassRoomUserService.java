package com.ry.cds.user.service;

import com.ry.cds.user.bo.ClassRoomUser;

/**
 * 用户班级关系业务接口
 * 
 * @author 幸仁强
 *
 */
public interface IClassRoomUserService {
	/**
	 * 插入用户班级关系
	 * 
	 * @param school
	 * @return
	 */
	public int insert(ClassRoomUser classRoomUser) throws Exception;
}
