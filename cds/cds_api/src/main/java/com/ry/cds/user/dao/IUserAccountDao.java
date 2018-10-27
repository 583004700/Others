package com.ry.cds.user.dao;

import com.ry.cds.amqp.bo.UserAccountChange;
import com.ry.cds.user.bo.UserAccount;

/**
 * 用户账户持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IUserAccountDao {
	/**
	 * 根据主键获取用户账户信息
	 * 
	 * @param map
	 * @return
	 */
	public UserAccount get(long userID, int accountTypeID) throws Exception;

	/**
	 * 更新UserAccount缓存
	 * 
	 * @param userAccountChange
	 * @return
	 * @throws Exception
	 */
	public boolean updateCacheForUserAccount(UserAccountChange userAccountChange) throws Exception;
}