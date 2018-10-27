package com.ry.cds.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.amqp.bo.UserAccountChange;
import com.ry.cds.user.bo.AmountChangeDetail;
import com.ry.cds.user.bo.UserAccount;
import com.ry.cds.user.dao.UserAccountDao;

@Service
public class UserAccountService implements IUserAccountService {

	@Autowired
	UserAccountDao userAccountDao;

	@Override
	public int changeAccount(UserAccountChange userAccountChange) throws Exception {
		UserAccount userAccount = userAccountDao.get(userAccountChange.getUserID(),
				userAccountChange.getAccountTypeID());
		userAccountChange.setAmount(userAccount.getAmount());
		int updateUserAccountCount = userAccountDao.changeAccount(userAccountChange);
		if (updateUserAccountCount > 0) {
			AmountChangeDetail amountChangeDetail = new AmountChangeDetail();
			amountChangeDetail.setUserID(userAccount.getUserID());
			amountChangeDetail.setAccountTypeID(userAccount.getAccountTypeID());
			amountChangeDetail.setChangeAmount(userAccountChange.getPrice());
			amountChangeDetail.setCurrencyTypeID(1);
			amountChangeDetail.setChangeTypeID(2);
			amountChangeDetail.setChangeReason(userAccountChange.getChangeReason());
			return userAccountDao.insertAmountChangeDetail(amountChangeDetail);
		} else {
			return 0;
		}
	}

}