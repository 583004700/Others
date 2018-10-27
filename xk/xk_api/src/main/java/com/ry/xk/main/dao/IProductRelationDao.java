package com.ry.xk.main.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.main.bo.ProductRelation;

@Component
public interface IProductRelationDao
{
    /**
     * 通过主键获取一条数据
     * 
     * @param productId
     * @param referenceId
     * @param productSourceTypeId
     * @return
     */
    public ProductRelation getByPrimary(int productId, int referenceId, int productSourceTypeId);
}
