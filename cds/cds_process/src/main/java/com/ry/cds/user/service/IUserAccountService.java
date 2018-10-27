package com.ry.cds.user.service;

import com.ry.cds.amqp.bo.UserAccountChange;

/**
 * 用户账户业务类接口
 * 
 * @author 幸仁强
 *
 */
public interface IUserAccountService {

	/**
	 * 更新账户字段
	 * @param userAccountChange
	 * @throws Exception
	 */
	public int changeAccount(UserAccountChange userAccountChange) throws Exception;
}
