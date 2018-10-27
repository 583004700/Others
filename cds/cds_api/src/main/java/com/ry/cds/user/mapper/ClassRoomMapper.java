package com.ry.cds.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.user.bo.ClassRoom;

/**
 * 班级mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface ClassRoomMapper {
	/**
	 * 根据主键获取班级信息
	 * 
	 * @param schoolID
	 * @return
	 */
	public ClassRoom get(long classRoomID);

	/**
	 * 根据班级编号获取班级主键
	 * 
	 * @param schoolCode
	 * @return
	 */
	public long getPrimaryByClassRoomCode(@Param("classRoomCode") String classRoomCode);

	/**
	 * 插入班级信息
	 * 
	 * @param classRoom
	 * @return
	 */
	public int insert(ClassRoom classRoom);

	/**
	 * 更新班级信息
	 * 
	 * @param classRoom
	 * @return
	 */
	public int update(ClassRoom classRoom);

}