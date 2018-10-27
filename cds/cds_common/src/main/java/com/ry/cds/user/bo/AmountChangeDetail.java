package com.ry.cds.user.bo;

import java.io.Serializable;

public class AmountChangeDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private long userID;
	private int accountTypeID;
	private long changeAmount;
	private int currencyTypeID;
	private int changeTypeID;
	private String createDatetime;
	private String updateDateTime;
	private String remark;
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
	public long getChangeAmount() {
		return changeAmount;
	}
	public void setChangeAmount(long changeAmount) {
		this.changeAmount = changeAmount;
	}
	public int getCurrencyTypeID() {
		return currencyTypeID;
	}
	public void setCurrencyTypeID(int currencyTypeID) {
		this.currencyTypeID = currencyTypeID;
	}
	public int getChangeTypeID() {
		return changeTypeID;
	}
	public void setChangeTypeID(int changeTypeID) {
		this.changeTypeID = changeTypeID;
	}
	public String getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getChangeReason() {
		return changeReason;
	}
	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

}
