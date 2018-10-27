package com.ry.cds.user.service;

import com.ry.cds.print.bo.PrintListOutput;
import com.ry.cds.user.bo.SyncUserInput;
import com.ry.cds.user.bo.SyncUserOutput;
import com.ry.cds.user.bo.User;

/**
 * 用户业务接口
 * 
 * @author 幸仁强
 *
 */
public interface IUserService {
	/**
	 * 插入用户信息
	 * 
	 * @param user
	 * @return
	 */
	public long insert(User user) throws Exception;

	/**
	 * 批量导入用户信息
	 * 
	 * @param syncUserInput
	 * @return
	 */
	public SyncUserOutput synchronous(SyncUserInput syncUserInput) throws Exception;

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int update(User user) throws Exception;

	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public User get(long userID) throws Exception;

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
	
	/**
	 * 根据卡号获取用户信息
	 * 
	 * @param cardNo
	 * @return
	 */
	public PrintListOutput printList(String cardNo) throws Exception;

}
