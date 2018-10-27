package com.ry.xk.studentexamresult.service;

import org.springframework.stereotype.Service;

@Service
public interface IOrderPayService
{
    /**
     * 支付结果通知
     * 
     * @param userId
     * @param productId
     * @param orderNumber
     * @return
     */
    public boolean payNotify(int userId, int productId, String orderNumber)
        throws Exception;

    /**
     * 前端获取支付结果
     * 
     * @param orderNumber
     * @return
     */
    public boolean payResult(String orderNumber);
}
