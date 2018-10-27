package com.ry.xk.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.common.DatabaseType;
import com.ry.xk.main.bo.User;
import com.ry.xk.main.mapper.UserMapper;
import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.springbootframe.datasource.MyDataSource;

/**
 * 用户数据处理
 * 
 * @author 幸仁强
 */
@Component
public class UserDao implements IUserDao
{
    @Autowired
    UserMapper userMapper;

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public User get(int userId)
        throws Exception
    {
        User user = new User();
        user.setUserId(userId);
        User rtnUser = CouchBaseFactory.get(User.class, user.key());
        if (null == rtnUser)
        {
            rtnUser = userMapper.get(userId);
            if (null != rtnUser)
            {
                CouchBaseFactory.update(rtnUser);
            }
        }
        return rtnUser;
    }

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public int insert(User user)
        throws Exception
    {
        int result = userMapper.insert(user);
        int userId = 0;
        if (result > 0)
        {
            userId = user.getUserId();
            CouchBaseFactory.update(user);
        }
        return userId;
    }

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public int getUserIdByUserName(String userName)
        throws Exception
    {
        return userMapper.getUserIdByUserName(userName);

    }

}