package com.ry.xk.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.common.DatabaseType;
import com.ry.xk.common.bo.UserOrder;
import com.ry.xk.main.mapper.UserOrderMapper;
import com.ry.xk.springbootframe.datasource.MyDataSource;

@Component
public class UserOrderDao implements IUserOrderDao
{

    @Autowired
    UserOrderMapper userOrderMapper;

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public int update(UserOrder userOrder)
    {
        return userOrderMapper.update(userOrder);
    }
    
    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public UserOrder getByOrderNumber(String orderNumber)
    {
        return userOrderMapper.getByOrderNumber(orderNumber);
    }

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public int insert(UserOrder userOrder)
    {
        return userOrderMapper.insert(userOrder);
    }
}
