package com.byefan.xhoa.mapper.crm;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.crm.CustUsers;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CustUsersMapper extends BaseMapper<CustUsers,Integer> {
    /**
     * 添加一条客户用户记录
     * @param record
     * @return
     */
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(CustUsers record);

    /**
     * 通过公司ID查询用户信息
     * @param companyId
     * @return
     */
    @Select("SELECT * FROM t_crm_cust_users WHERE company_id = #{companyId}")
    CustUsers getCustUsersByCompanyId(@Param("companyId") Integer companyId);
}
