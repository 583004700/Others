package com.ry.xk.main.bo;

import java.math.BigDecimal;
import java.util.Date;

import io.protostuff.Tag;

/**
 * 产品明细
 * 
 * @ClassName: ProductDetail
 * @author 幸仁强
 * @date 2018年6月7日
 */
public class ProductDetail
{
    @Tag(1)
    private int productDetailId;

    @Tag(2)
    private int productId;

    @Tag(3)
    private String productDetailName;

    @Tag(4)
    private BigDecimal productPrice;

    @Tag(5)
    private BigDecimal productSalePrice;

    @Tag(6)
    private String range;

    @Tag(7)
    private int statusFlag;

    @Tag(8)
    private int orderIndex;

    @Tag(9)
    private Date createDateTime;

    @Tag(10)
    private Date updateDateTime;

    @Tag(11)
    private int isHaveCount;

    @Tag(12)
    private int totalCount;

    @Tag(13)
    private int isRecommend;

    @Tag(14)
    private int buyMode;

    public int getProductDetailId()
    {

        return productDetailId;
    }

    public void setProductDetailId(int productDetailId)
    {

        this.productDetailId = productDetailId;
    }

    public int getProductId()
    {

        return productId;
    }

    public void setProductId(int productId)
    {

        this.productId = productId;
    }

    public String getProductDetailName()
    {

        return productDetailName;
    }

    public void setProductDetailName(String productDetailName)
    {

        this.productDetailName = productDetailName;
    }

    public BigDecimal getProductPrice()
    {

        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice)
    {

        this.productPrice = productPrice;
    }

    public BigDecimal getProductSalePrice()
    {

        return productSalePrice;
    }

    public void setProductSalePrice(BigDecimal productSalePrice)
    {

        this.productSalePrice = productSalePrice;
    }

    public String getRange()
    {

        return range;
    }

    public void setRange(String range)
    {

        this.range = range;
    }

    public int getStatusFlag()
    {

        return statusFlag;
    }

    public void setStatusFlag(int statusFlag)
    {

        this.statusFlag = statusFlag;
    }

    public int getOrderIndex()
    {

        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {

        this.orderIndex = orderIndex;
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

    public int getIsHaveCount()
    {

        return isHaveCount;
    }

    public void setIsHaveCount(int isHaveCount)
    {

        this.isHaveCount = isHaveCount;
    }

    public int getTotalCount()
    {

        return totalCount;
    }

    public void setTotalCount(int totalCount)
    {

        this.totalCount = totalCount;
    }

    public int getIsRecommend()
    {

        return isRecommend;
    }

    public void setIsRecommend(int isRecommend)
    {

        this.isRecommend = isRecommend;
    }

    public int getBuyMode()
    {

        return buyMode;
    }

    public void setBuyMode(int buyMode)
    {

        this.buyMode = buyMode;
    }

}