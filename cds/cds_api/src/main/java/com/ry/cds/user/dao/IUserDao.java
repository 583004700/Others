package com.ry.cds.user.dao;

import com.ry.cds.user.bo.User;

/**
 * 用户持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IUserDao {

	/**
	 * 插入用户信息
	 * 
	 * @param user
	 * @return 用户ID
	 */
	public long insert(User user) throws Exception;

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user) throws Exception;

	/**
	 * 更新或者新增用户信息
	 * 
	 * @param user
	 * @return 用户ID
	 */
	public long upset(User user) throws Exception;

	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public User get(long userId) throws Exception;

	/**
	 * 根据用户编号获取用户信息
	 * 
	 * @param getByUserCode
	 * @return
	 * @throws Exception
	 */
	public User getByUserCode(String userCode) throws Exception;

	/**
	 * 根据卡号获取用户信息
	 * 
	 * @param cardNo
	 * @return
	 */
	public User getByCardNo(String cardNo) throws Exception;
}