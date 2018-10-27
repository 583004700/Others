package com.ry.xk.main.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.main.bo.Product;
import com.ry.xk.main.bo.ProductGroupList;

/**
 * 合作伙伴dao
 */
@Component
public interface IProductDao
{
    /**
     * 查询产品
     * 
     * @Title: get
     * @author 幸仁强
     * @param partnerID
     * @return
     */
    public Product get(int productId);

    /**
     * 根据产品ID查询产品组
     * 
     * @Title: getProductGroup
     * @author 幸仁强
     * @return
     */
    public ProductGroupList getProductGroup();

    /**
     * 根据试卷ID获取产品ID
     * 
     * @Title: getProductIdByReferenceId
     * @author 幸仁强
     * @param referenceId
     * @return
     */
    public Product getProductByReferenceId(int referenceId);
}