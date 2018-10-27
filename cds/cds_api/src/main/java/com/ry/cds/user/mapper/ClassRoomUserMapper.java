package com.ry.cds.user.mapper;

import java.util.Map;

import org.mapstruct.Mapper;

import com.ry.cds.user.bo.ClassRoomUser;

/**
 * 用户班级关系mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface ClassRoomUserMapper {

	/**
	 * 插入班级信息
	 * 
	 * @param classRoom
	 * @return
	 */
	public int insert(ClassRoomUser classRoomUser);

	/**
	 * 插入班级信息
	 * 
	 * @param classRoom
	 * @return
	 */
	public int checkExistByPrimary(Map<String, Long> params);

}