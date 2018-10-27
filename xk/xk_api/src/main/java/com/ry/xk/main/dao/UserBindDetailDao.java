package com.ry.xk.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.common.DatabaseType;
import com.ry.xk.main.bo.User;
import com.ry.xk.main.bo.UserBindDetail;
import com.ry.xk.main.mapper.UserBindDetailMapper;
import com.ry.xk.main.mapper.UserMapper;
import com.ry.xk.springbootframe.datasource.MyDataSource;

/**
 * 打印机组mapper
 * 
 * @author 幸仁强
 */
@Component
public class UserBindDetailDao implements IUserBindDetailDao
{
    @Autowired
    UserBindDetailMapper userBindDetailMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public int getUserIdByOpenId(String bindContent)
        throws Exception
    {
        int userId = userBindDetailMapper.getUserIdByOpenId(bindContent);
        if (userId > 0)
        {
            User user = userMapper.get(userId);
            return user.getUserId();
        }
        return 0;
    }

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public int insert(UserBindDetail userBindDetail)
    {
        return userBindDetailMapper.insert(userBindDetail);
    }

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public UserBindDetail getByUserId(int userId){
        return userBindDetailMapper.getByUserId(userId);
    }
}