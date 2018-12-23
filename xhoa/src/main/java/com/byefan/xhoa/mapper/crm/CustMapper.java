package com.byefan.xhoa.mapper.crm;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.crm.Cust;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CustMapper extends BaseMapper<Cust, Integer> {
    /**
     * 添加一条客户记录
     *
     * @param record
     * @return
     */
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(Cust record);

    /**
     * 通过公司名称查询一条公司记录
     *
     * @param companyName
     * @return
     */
    @Select("select * from t_crm_cust where company_name=#{0} limit 0,1")
    @Results({@Result(property = "id", column = "id"),
            @Result(property = "dockingPeoples", javaType = List.class, column = "id",
                    many = @Many(select = "com.byefan.xhoa.mapper.crm.DockingPeopleMapper.getDockingPeopleByCompanyId")),
            @Result(property = "productInfos", javaType = List.class, column = "id",
                    many = @Many(select = "com.byefan.xhoa.mapper.crm.ProductInfoMapper.getProductInfoCompanyId")),
            @Result(property = "custUsers", javaType = List.class, column = "id",
                    many = @Many(select = "com.byefan.xhoa.mapper.crm.CustUsersMapper.getCustUsersByCompanyId"))
    })
    Cust getByCompanyName(String companyName);


    /**
     * 通过id查询一条公司记录
     *
     * @param id
     * @return
     */
    @Select("select * from t_crm_cust where id=#{0}")
    @Results({@Result(property = "id", column = "id"),
            @Result(property = "dockingPeoples", javaType = List.class, column = "id",
                    many = @Many(select = "com.byefan.xhoa.mapper.crm.DockingPeopleMapper.getDockingPeopleByCompanyId")),
            @Result(property = "productInfos", javaType = List.class, column = "id",
                    many = @Many(select = "com.byefan.xhoa.mapper.crm.ProductInfoMapper.getProductInfoCompanyId")),
            @Result(property = "custUsers", javaType = List.class, column = "id",
                    many = @Many(select = "com.byefan.xhoa.mapper.crm.CustUsersMapper.getCustUsersByCompanyId"))
    })
    Cust getByCompanyId(Integer id);


    @Select("select * from t_crm_cust")
    @Results({@Result(property = "id", column = "id"),
            @Result(property = "dockingPeoples", javaType = List.class, column = "id",
                    many = @Many(select = "com.byefan.xhoa.mapper.crm.DockingPeopleMapper.getDockingPeopleByCompanyId"))})
    List<Cust> getCusts();

    @Select("select hy_id,hymc from sys_wd_hy order by hy_id asc")
    List<Map> hySelect();

    /**
     * 根据对接人查询客户信息列表
     *
     * @param worker
     * @return
     */
    @Select("select a.* from t_crm_cust a, t_crm_docking_people b where a.id=b.`company_id` and b.`worker`=#{worker}")
    List<Cust> listByWorker(Integer worker);
}
