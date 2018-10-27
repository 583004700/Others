package com.ry.cds.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.amqp.bo.UserAccountChange;
import com.ry.cds.user.bo.UserAccount;
import com.ry.cds.user.mapper.UserAccountMapper;
import com.ry.cds.user.service.CouchBaseFactory;

@Repository
public class UserAccountDao implements IUserAccountDao {
	@Autowired
	UserAccountMapper userAccountMapper;

	@Override
	public UserAccount get(long userID, int accountTypeID) throws Exception {
		UserAccount userAccount = new UserAccount();
		userAccount.setUserID(userID);
		userAccount.setAccountTypeID(accountTypeID);
		UserAccount rtnUserAccount = CouchBaseFactory.get(UserAccount.class, userAccount.key());
		if (null == rtnUserAccount) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userID", userID);
			map.put("accountTypeID", accountTypeID);
			rtnUserAccount = userAccountMapper.get(map);
			if (null != rtnUserAccount) {
				CouchBaseFactory.update(rtnUserAccount);
			}
		}
		return rtnUserAccount;

	}

	@Override
	public boolean updateCacheForUserAccount(UserAccountChange userAccountChange) throws Exception {
		UserAccount userAccount = this.get(userAccountChange.getUserID(), userAccountChange.getAccountTypeID());
		if (null != userAccount) {
			if (userAccountChange.getHandelType() == 2) {
				userAccount.setAmount(-userAccountChange.getPrice());
			} else {
				userAccount.setAmount(userAccountChange.getPrice());
			}
			boolean cacheResult = CouchBaseFactory.updateCas(userAccount);
			return cacheResult;
		} else {
			return false;
		}
	}

}