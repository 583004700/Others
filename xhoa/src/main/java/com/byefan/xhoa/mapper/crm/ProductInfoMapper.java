package com.byefan.xhoa.mapper.crm;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.crm.ProductInfo;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ProductInfoMapper extends BaseMapper<ProductInfo, Integer> {
    /**
     * 添加一条产品记录
     *
     * @param record
     * @return
     */
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(ProductInfo record);

    /**
     * 通过公司ID查询产品信息
     * @param companyId
     * @return
     */
    @Select("SELECT * FROM t_crm_product_info WHERE company_id = #{companyId}")
    ProductInfo getProductInfoCompanyId(@Param("companyId") Integer companyId);
}
