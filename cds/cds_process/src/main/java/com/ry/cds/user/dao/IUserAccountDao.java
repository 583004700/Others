package com.ry.cds.user.dao;

import com.ry.cds.amqp.bo.UserAccountChange;
import com.ry.cds.user.bo.AmountChangeDetail;
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
	 * 变更账户
	 * @param userAccountChange
	 * @return
	 */
	public int changeAccount(UserAccountChange userAccountChange);
	
	/**
	 * 插入金额变动详情记录
	 * @param amountChangeDetail
	 * @return
	 */
	public int insertAmountChangeDetail(AmountChangeDetail amountChangeDetail);
}