package com.ry.cds.amqp.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.ry.cds.common.CommonConst;

/**
 * 用户账户变更 MQ消息实体类
 * 
 * @author 幸仁强
 *
 */
@Component
public class UserAccountChange implements Serializable, IAmqpStoredObject {
	private static final long serialVersionUID = 1L;
	// 用户id，对应user表的主键
	private long userID;
	// 账号类型，默认为系统用户1
	private int accountTypeID;
	// 发生金额
	private long price;
	// 余额
	private long amount;
	// 操作类型，1、扣款，2退款
	private int handelType;

	private String changeReason;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public int getAccountTypeID() {
		return accountTypeID;
	}

	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getHandelType() {
		return handelType;
	}

	public void setHandelType(int handelType) {
		this.handelType = handelType;
	}

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	private String queueName = CommonConst.USERACCOUNTCHANGEQUEUE;

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	@Override
	public String getQueueName() {
		return this.queueName;
	}

}