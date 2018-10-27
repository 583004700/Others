package com.ry.xk.response.bo;

/**
 * 创建订单信息 <描述类的作用>
 * 
 * @ClassName: PaperPayInfoModule
 * @author DELL
 * @date 2018年5月22日
 */
public class BuildOrderModule
{
    /**
     * 获取结果，0失败 1成功
     */
    private int result;

    /**
     * 订单号
     */
    private String orderNum;

    public int getResult()
    {

        return result;
    }

    public void setResult(int result)
    {

        this.result = result;
    }

    public String getOrderNum()
    {

        return orderNum;
    }

    public void setOrderNum(String orderNum)
    {

        this.orderNum = orderNum;
    }

    public BuildOrderModule()
    {}

    public BuildOrderModule(int result, String orderNum)
    {
        this.result = result;
        this.orderNum = orderNum;
    }

}
