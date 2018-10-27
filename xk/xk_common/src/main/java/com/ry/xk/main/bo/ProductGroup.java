package com.ry.xk.main.bo;

import io.protostuff.Tag;

/**
 * 产品组
 * 
 * @ClassName: ProductGroup
 * @author 幸仁强
 * @date 2018年6月7日
 */
public class ProductGroup
{
    @Tag(1)
    private int productGroupId;

    @Tag(2)
    private String productGroupName;

    @Tag(3)
    private String productGroupDesc;

    public int getProductGroupId()
    {

        return productGroupId;
    }

    public void setProductGroupId(int productGroupId)
    {

        this.productGroupId = productGroupId;
    }

    public String getProductGroupName()
    {

        return productGroupName;
    }

    public void setProductGroupName(String productGroupName)
    {

        this.productGroupName = productGroupName;
    }

    public String getProductGroupDesc()
    {

        return productGroupDesc;
    }

    public void setProductGroupDesc(String productGroupDesc)
    {

        this.productGroupDesc = productGroupDesc;
    }

}