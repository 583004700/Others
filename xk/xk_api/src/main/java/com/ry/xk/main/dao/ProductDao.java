package com.ry.xk.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.common.DatabaseType;
import com.ry.xk.main.bo.Product;
import com.ry.xk.main.bo.ProductGroup;
import com.ry.xk.main.bo.ProductGroupList;
import com.ry.xk.main.mapper.ProductMapper;
import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.springbootframe.datasource.MyDataSource;

/**
 * <描述类的作用>
 * 
 * @ClassName: ProductDao
 * @author 幸仁强
 * @date 2018年6月7日
 */
@Component
public class ProductDao implements IProductDao
{
    @Autowired
    ProductMapper productMapper;

    /**
     * 获取一个合作伙伴
     * 
     * @param partnerID
     * @return
     */
    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public Product get(int productId)
    {
        Product product = new Product();
        product.setProductId(productId);
        Product rtnProduct = CouchBaseFactory.get(product.getClass(), product.key());
        if (rtnProduct == null)
        {
            rtnProduct = productMapper.getProductByProductId(productId);
            rtnProduct.setProductDetails(productMapper.getProductDetailByProductId(productId));
            rtnProduct.setProductRelations(productMapper.getProductRelationByProductId(productId));
            CouchBaseFactory.update(rtnProduct);
        }
        return rtnProduct;
    }

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public ProductGroupList getProductGroup()
    {
        ProductGroupList productGroupList = new ProductGroupList();
        ProductGroupList rtnProductGroupList = CouchBaseFactory.get(ProductGroupList.class, productGroupList.key());
        if (null == rtnProductGroupList || null == rtnProductGroupList.getProductGroups() || rtnProductGroupList.getProductGroups().isEmpty())
        {
            List<ProductGroup> productGroups = productMapper.getProductGroup();
            if (null == productGroups || productGroups.size() == 0)
            {
                return null;
            }
            rtnProductGroupList = new ProductGroupList();
            rtnProductGroupList.setProductGroups(productGroups);
            CouchBaseFactory.update(rtnProductGroupList);
        }
        return rtnProductGroupList;
    }

    @Override
    @MyDataSource(type = DatabaseType.MAIN)
    public Product getProductByReferenceId(int referenceId)
    {
        int productId = productMapper.getProductIdByReferenceId(referenceId);
        return productId > 0 ? get(productId) : null;
    }

}