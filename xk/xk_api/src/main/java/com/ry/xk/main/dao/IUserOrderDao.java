package com.ry.xk.main.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.common.bo.UserOrder;

@Component
public interface IUserOrderDao
{
    /**
     * 插入userOrder表
     * 
     * @param userOrder
     * @return
     */
    public int insert(UserOrder userOrder);

    /**
     * 更新userOrder表
     * 
     * @param userOrder
     * @return
     */
    public int update(UserOrder userOrder);

    /**
     * 通过订单号查询订单
     * 
     * @param orderNumber
     * @return
     */
    public UserOrder getByOrderNumber(String orderNumber);
}
