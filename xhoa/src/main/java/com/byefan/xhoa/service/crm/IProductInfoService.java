package com.byefan.xhoa.service.crm;

import com.byefan.xhoa.entity.crm.ProductInfo;

public interface IProductInfoService {
    /**
     * 查看单个产品信息
     * @param productInfo
     * @return
     */
    ProductInfo selectOne(ProductInfo productInfo);

    boolean update(ProductInfo productInfo);
}
