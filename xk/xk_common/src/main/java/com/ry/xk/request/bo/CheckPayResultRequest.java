package com.ry.xk.request.bo;


import com.ry.xk.common.bo.RequestBase;
import org.hibernate.validator.constraints.NotBlank;


/**
 * <描述类的作用>
 * 
 * @ClassName: PayNotifyRequest
 * @author 幸仁强
 * @date 2018年5月23日
 */

public class CheckPayResultRequest extends RequestBase
{
    // 订单号
    @NotBlank(message = "订单号不为空")
    private String orderNumber;

    public String getOrderNumber()
    {

        return orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {

        this.orderNumber = orderNumber;
    }

}
