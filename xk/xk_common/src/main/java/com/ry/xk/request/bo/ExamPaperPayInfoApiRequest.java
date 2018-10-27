package com.ry.xk.request.bo;

import com.ry.xk.common.bo.RequestBase;

/**
 * 获取购买试卷支付信息 <描述类的作用>
 * 
 * @ClassName: PaperPayInfoApiRequest
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamPaperPayInfoApiRequest extends RequestBase
{

    /**
     * 订单号
     */
    private String orderNum;

    public String getOrderNum()
    {

        return orderNum;
    }

    public void setOrderNum(String orderNum)
    {

        this.orderNum = orderNum;
    }

}
