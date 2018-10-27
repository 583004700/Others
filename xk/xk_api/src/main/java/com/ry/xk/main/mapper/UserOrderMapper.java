package com.ry.xk.main.mapper;

import org.mapstruct.Mapper;

import com.ry.xk.common.bo.UserOrder;

/**
 * 产品映射mapper
 */
@Mapper
public interface UserOrderMapper
{
    /**
     * 插入用户订单记录表数据
     * 
     * @param userOrder
     * @return
     */
    public int insert(UserOrder userOrder);

    /**
     * 更新用户订单表数据
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