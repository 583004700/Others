package com.ry.cds.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.User;
import com.ry.cds.user.mapper.UserMapper;
import com.ry.cds.user.service.CouchBaseFactory;

@Repository
public class UserDao implements IUserDao {
	@Autowired
	UserMapper userMapper;

	@Override
	public long insert(User user) throws Exception {
		int result = userMapper.insert(user);
		long userID = 0;
		if (result > 0) {
			userID = user.getUserID();
			CouchBaseFactory.update(user);
		}
		return userID;
	}

	@Override
	public int update(User user) throws Exception {
		int result = userMapper.update(user);
		if (result > 0) {
			CouchBaseFactory.update(user);
		}
		return result;
	}

	@Override
	public User get(long userID) throws Exception {
		User user = new User();
		user.setUserID(userID);
		User rtnUser = CouchBaseFactory.get(User.class, user.key());
		if (null == rtnUser) {
			rtnUser = userMapper.get(userID);
			if (null != rtnUser) {
				CouchBaseFactory.update(rtnUser);
			}
		}
		return rtnUser;
	}

	/**
	 * 根据用户编号获取用户信息
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getByUserCode(String userCode) throws Exception {
		long userID = userMapper.getPrimaryByUserCode(userCode);
		return userID > 0 ? get(userID) : null;
	}

	@Override
	public User getByCardNo(String cardNo) throws Exception {
		long userID = userMapper.getPrimaryByCardNo(cardNo);
		return userID > 0 ? get(userID) : null;
	}

	@Override
	public long upset(User user) throws Exception {
		long userID = userMapper.getPrimaryByUserCode(user.getUserCode());
		if (userID > 0) {
			user.setUserID(userID);
			int updateResult = this.update(user);
			if (updateResult <= 0) {
				return updateResult;
			}
		} else {
			userID = this.insert(user);
		}
		return userID;
	}
}