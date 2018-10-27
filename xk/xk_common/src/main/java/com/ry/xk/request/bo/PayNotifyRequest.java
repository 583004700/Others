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

public class PayNotifyRequest extends RequestBase
{
    // 用户ID
    @NotBlank(message = "用户ID不为空")
    private String targetId;

    // 产品ID
    @NotBlank(message = "产品ID不为空")
    private String productId;

    // 订单中心的订单编号
    @NotBlank(message = "订单编号不为空")
    private String orderNumber;

    public String getTargetId()
    {

        return targetId;
    }

    public void setTargetId(String targetId)
    {

        this.targetId = targetId;
    }

    public String getProductId()
    {

        return productId;
    }

    public void setProductId(String productId)
    {

        this.productId = productId;
    }

    public String getOrderNumber()
    {

        return orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {

        this.orderNumber = orderNumber;
    }

}
