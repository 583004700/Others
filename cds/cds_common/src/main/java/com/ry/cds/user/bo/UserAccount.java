package com.ry.cds.user.bo;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.couchbase.client.java.document.AbstractDocument;
import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseOperationObject;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;
import com.ry.cds.utils.DateUtil;
import com.ry.cds.utils.GZipUtil;
import com.ry.cds.utils.ProtoBufUtil;

import io.protostuff.Tag;

/**
 * 用户账户信息实体类
 * 
 * @author 幸仁强
 *
 */
@Component
public class UserAccount implements Serializable, ICouchBaseStoredObject, ICouchBaseOperationObject {
	private static final long serialVersionUID = 1L;
	// 用户id，对应user表的主键
	@Tag(1)
	private long userID;
	// 账号类型，默认为系统用户1
	@Tag(2)
	private int accountTypeID;
	// 账户编号，为了兼容老数据
	@Tag(3)
	private String accountNo;
	// 账户可用余额，单位毫（元角分厘毫）
	@Tag(4)
	private long amount;
	// 账号余额货币类型，默认为人民币
	@Tag(5)
	private int currencyTypeID;
	// 冻结金额，单位毫（元角分厘毫）
	@Tag(6)
	private long frezeeAmount;
	// 账户状态
	@Tag(7)
	private int statusFlag;
	@Tag(8)
	private String createDatetime;
	@Tag(9)
	private String updateDateTime;

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

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public int getCurrencyTypeID() {
		return currencyTypeID;
	}

	public void setCurrencyTypeID(int currencyTypeID) {
		this.currencyTypeID = currencyTypeID;
	}

	public long getFrezeeAmount() {
		return frezeeAmount;
	}

	public void setFrezeeAmount(long frezeeAmount) {
		this.frezeeAmount = frezeeAmount;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
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

	private static String _key = "UserAccount_%s_%s";

	@Override
	public String key() {
		return String.format(keyFormat(), userID, accountTypeID);
	}

	@Override
	public String keyFormat() {
		return _key;
	}

	@Override
	public CouchBaseSectionType couchbaseSection() {
		return CouchBaseSectionType.USER;
	}

	@Override
	public <T extends AbstractDocument<byte[]>> void subtract(T t) throws IOException {
		UserAccount userAccount = (UserAccount) ProtoBufUtil.deserializer(GZipUtil.uncompress(t.content()),
				UserAccount.class);
		this.userID = userAccount.getUserID();
		this.accountTypeID = userAccount.getAccountTypeID();
		this.accountNo = userAccount.getAccountNo();
		this.amount = userAccount.getAmount() - this.amount;
		this.currencyTypeID = userAccount.getCurrencyTypeID();
		this.frezeeAmount = userAccount.getFrezeeAmount();
		this.statusFlag = userAccount.getStatusFlag();
		this.createDatetime = userAccount.getCreateDatetime();
		this.updateDateTime = DateUtil.getDateString("yyyy-MM-dd HH:mm:ss");
	}
}