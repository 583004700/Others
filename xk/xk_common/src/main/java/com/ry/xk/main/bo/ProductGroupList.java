package com.ry.xk.main.bo;

import java.io.Serializable;
import java.util.List;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 产品组
 * 
 * @ClassName: ProductGroupList
 * @author 幸仁强
 * @date 2018年6月7日
 */
public class ProductGroupList implements Serializable, ICouchBaseStoredObject
{
    private static final long serialVersionUID = 1L;

    @Tag(1)
    private List<ProductGroup> productGroups;

    public List<ProductGroup> getProductGroups()
    {
        return productGroups;
    }

    public void setProductGroups(List<ProductGroup> productGroups)
    {
        this.productGroups = productGroups;
    }

    private static String _key = "ProductGroup";

    @Override
    public String key()
    {
        return keyFormat();
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