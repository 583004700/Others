package com.ry.xk.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.main.bo.ProductRelation;
import com.ry.xk.main.mapper.ProductRelationMapper;

@Component
public class ProductRelationDao implements IProductRelationDao
{

    @Autowired
    ProductRelationMapper productRelationMapper;

    /**
     * 通过主键获取一条数据
     * 
     * @param productId
     * @param referenceId
     * @param productSourceTypeId
     * @return
     */
    public ProductRelation getByPrimary(int productId, int referenceId, int productSourceTypeId)
    {
        return productRelationMapper.getByPrimary(productId, referenceId, productSourceTypeId);
    }
}
