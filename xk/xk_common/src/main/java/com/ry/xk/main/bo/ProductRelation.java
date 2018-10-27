package com.ry.xk.main.bo;

import java.util.Date;

import io.protostuff.Tag;

/**
 * 产品业务关系映射表
 * 
 * @ClassName: ProductRelation
 * @author 幸仁强
 * @date 2018年6月7日
 */
public class ProductRelation
{
    @Tag(1)
    private int productId;

    @Tag(2)
    private int referenceId;

    @Tag(3)
    private int productSourceTypeId;

    @Tag(4)
    private int statusFlag;

    @Tag(5)
    private Date createDateTime;

    @Tag(6)
    private Date updateDateTime;

    public int getProductId()
    {

        return productId;
    }

    public void setProductId(int productId)
    {

        this.productId = productId;
    }

    public int getReferenceId()
    {

        return referenceId;
    }

    public void setReferenceId(int referenceId)
    {

        this.referenceId = referenceId;
    }

    public int getProductSourceTypeId()
    {

        return productSourceTypeId;
    }

    public void setProductSourceTypeId(int productSourceTypeId)
    {

        this.productSourceTypeId = productSourceTypeId;
    }

    public int getStatusFlag()
    {

        return statusFlag;
    }

    public void setStatusFlag(int statusFlag)
    {

        this.statusFlag = statusFlag;
    }

    public Date getCreateDateTime()
    {

        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime)
    {

        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime()
    {

        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime)
    {

        this.updateDateTime = updateDateTime;
    }

}