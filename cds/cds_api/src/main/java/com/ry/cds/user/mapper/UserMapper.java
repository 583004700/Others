package com.ry.cds.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.user.bo.User;

@Mapper
public interface UserMapper {

	/**
	 * 插入用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int insert(User user);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user);

	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public User get(@Param("userID") long userID);

	/**
	 * 根据用户编号获取用户主键
	 * 
	 * @param userCode
	 * @return
	 */
	public long getPrimaryByUserCode(@Param("userCode") String userCode);

	/**
	 * 根据用户编号获取用户主键
	 * 
	 * @param userCode
	 * @return
	 */
	public long getPrimaryByCardNo(@Param("cardNo") String cardNo);
}