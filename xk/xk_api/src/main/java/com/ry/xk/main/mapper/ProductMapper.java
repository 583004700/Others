package com.ry.xk.main.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.xk.main.bo.Product;
import com.ry.xk.main.bo.ProductDetail;
import com.ry.xk.main.bo.ProductGroup;
import com.ry.xk.main.bo.ProductRelation;

/**
 * 产品映射mapper
 */
@Mapper
public interface ProductMapper
{
    /**
     * 根据产品ID查询产品
     * 
     * @Title: getProductByProductId
     * @author 幸仁强
     * @param productId
     * @return
     */
    public Product getProductByProductId(@Param("productId") int productId);

    /**
     * 根据产品ID查询产品明细
     * 
     * @Title: getProductDetailByProductId
     * @author 幸仁强
     * @param productId
     * @return
     */
    public List<ProductDetail> getProductDetailByProductId(@Param("productId") int productId);

    /**
     * 根据产品ID查询产品关系
     * 
     * @Title: getProductRelationByProductId
     * @author 幸仁强
     * @param productId
     * @return
     */
    public List<ProductRelation> getProductRelationByProductId(@Param("productId") int productId);

    /**
     * 根据产品ID查询产品组
     * 
     * @Title: getProductGroup
     * @author 幸仁强
     * @return
     */
    public List<ProductGroup> getProductGroup();

    /**
     * 根据试卷ID获取产品ID
     * 
     * @Title: getProductIdByReferenceId
     * @author 幸仁强
     * @param referenceId
     * @return
     */
    public int getProductIdByReferenceId(@Param("referenceId") int referenceId);
}