package com.ry.xk.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.main.bo.User;
import com.ry.xk.main.bo.UserBindDetail;
import com.ry.xk.main.dao.IUserBindDetailDao;
import com.ry.xk.main.dao.IUserDao;

/**
 * 用户业务类
 * 
 * @ClassName: UserService
 * @author 幸仁强
 * @date 2018年5月29日
 */
@Service
public class UserService implements IUserService
{
    @Autowired
    IUserDao userDao;

    @Autowired
    IUserBindDetailDao userBindDetailDao;

    @Override
    public User get(int userId)
        throws Exception
    {
        return userDao.get(userId);
    }

    @Override
    public int checkAndBindUser(int partnerId, String openId)
        throws Exception
    {
        int userId = userBindDetailDao.getUserIdByOpenId(openId);
        if (userId > 0)
        {
            return userId;
        }
        else
        {
            User user = new User();
            user.setPartnerId(partnerId);
            user.setUserName(openId);
            userId = userDao.insert(user);
            UserBindDetail userBindDetail = new UserBindDetail();
            userBindDetail.setBindContent(openId);
            userBindDetail.setUserId(userId);
            return userBindDetailDao.insert(userBindDetail) > 0 ? userId : 0;
        }
    }

}
