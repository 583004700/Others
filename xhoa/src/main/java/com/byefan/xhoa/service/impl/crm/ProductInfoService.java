package com.byefan.xhoa.service.impl.crm;

import com.byefan.xhoa.entity.crm.ProductInfo;
import com.byefan.xhoa.mapper.crm.ProductInfoMapper;
import com.byefan.xhoa.service.crm.IProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoService implements IProductInfoService{
    @Autowired
    ProductInfoMapper productInfoMapper;

    /**
     * 查询单个
     * @param productInfo
     * @return
     */
    public ProductInfo selectOne(ProductInfo productInfo){
        return productInfoMapper.get(ProductInfo.class,productInfo.getId());
    }

    public boolean update(ProductInfo productInfo){
        if(productInfo.getId() == null || productInfo.getId() ==0){
            return false;
        }
        productInfoMapper.update(productInfo);
        return true;
    }
}
