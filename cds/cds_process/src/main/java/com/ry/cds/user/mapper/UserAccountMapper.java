package com.ry.cds.user.mapper;

import java.util.Map;

import org.mapstruct.Mapper;

import com.ry.cds.amqp.bo.UserAccountChange;
import com.ry.cds.user.bo.AmountChangeDetail;
import com.ry.cds.user.bo.UserAccount;

/**
 * 学校Mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface UserAccountMapper {

	/**
	 * 根据主键获取用户账户信息
	 * 
	 * @param map
	 * @return
	 */
	public UserAccount get(Map<String, Object> map);

	/**
	 * 变更账户
	 * 
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