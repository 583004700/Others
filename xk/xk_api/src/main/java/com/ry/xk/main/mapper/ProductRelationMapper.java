package com.ry.xk.main.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.xk.main.bo.ProductRelation;

/**
 * 产品映射mapper
 */
@Mapper
public interface ProductRelationMapper
{
    /**
     * 通过主键获取一条数据
     * 
     * @param productId
     * @param referenceId
     * @param productSourceTypeId
     * @return
     */
    public ProductRelation getByPrimary(@Param("productId") int productId, @Param("referenceId") int referenceId, @Param("productSourceTypeId") int productSourceTypeId);
}