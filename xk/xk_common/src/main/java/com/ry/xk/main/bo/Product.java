package com.ry.xk.main.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 产品
 * 
 * @ClassName: Product
 * @author 幸仁强
 * @date 2018年6月7日
 */
public class Product implements Serializable, ICouchBaseStoredObject
{
    private static final long serialVersionUID = 1L;

    @Tag(1)
    private int productId;

    @Tag(2)
    private String productNumber;

    @Tag(3)
    private String productName;

    @Tag(4)
    private int statusFlag;

    @Tag(5)
    private int productGroupId;

    @Tag(6)
    private String productPicture;

    @Tag(7)
    private Date createDateTime;

    @Tag(8)
    private Date updateDateTime;

    @Tag(9)
    private int productProviderId;

    @Tag(10)
    private List<ProductDetail> productDetails;

    @Tag(11)
    private List<ProductRelation> productRelations;

    public int getProductId()
    {

        return productId;
    }

    public void setProductId(int productId)
    {

        this.productId = productId;
    }

    public String getProductNumber()
    {

        return productNumber;
    }

    public void setProductNumber(String productNumber)
    {

        this.productNumber = productNumber;
    }

    public String getProductName()
    {

        return productName;
    }

    public void setProductName(String productName)
    {

        this.productName = productName;
    }

    public int getStatusFlag()
    {

        return statusFlag;
    }

    public void setStatusFlag(int statusFlag)
    {

        this.statusFlag = statusFlag;
    }

    public int getProductGroupId()
    {

        return productGroupId;
    }

    public void setProductGroupId(int productGroupId)
    {

        this.productGroupId = productGroupId;
    }

    public String getProductPicture()
    {

        return productPicture;
    }

    public void setProductPicture(String productPicture)
    {

        this.productPicture = productPicture;
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

    public int getProductProviderId()
    {

        return productProviderId;
    }

    public void setProductProviderId(int productProviderId)
    {

        this.productProviderId = productProviderId;
    }

    public List<ProductDetail> getProductDetails()
    {

        return productDetails;
    }

    public void setProductDetails(List<ProductDetail> productDetails)
    {

        this.productDetails = productDetails;
    }

    public List<ProductRelation> getProductRelations()
    {

        return productRelations;
    }

    public void setProductRelations(List<ProductRelation> productRelations)
    {

        this.productRelations = productRelations;
    }

    private static String _key = "Product_%s";

    @Override
    public String key()
    {
        return String.format(keyFormat(), productId);
    }

    @Override
    public String keyFormat()
    {
        return _key;
    }

    @Override
    public CouchBaseSectionType couchbaseSection()
    {
        return CouchBaseSectionType.MAIN;
    }

}