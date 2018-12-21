package com.byefan.xhoa.mapper.media;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.media.Supplier;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;


public interface SupplierMapper extends BaseMapper<Supplier, Integer> {

//    @SelectProvider(type = ProviderUtil.class, method = "listByOrder")
//    List<Supplier> suppliers(@Param("supplier") Supplier supplier, String... order);


    @Select("select * from t_media_supplier where state='0' order by id desc")
    List<Supplier> listAll(Supplier supplier);

    @Select("select * from t_media_supplier where state='0' and id=#{id}")
    Supplier getById(@Param("id") Integer id);

    @Select("select count(id) from t_media_supplier where state='0' and contactor = #{contactor} and name=#{name}")
    int getIdBySupplierName(@Param("name") String supplierName,@Param("contactor") String contactor  );

    @Select({"<script>",
        "select  a.* " +
                " from t_media_supplier a " +
                " where 1=1 and a.state=0 " +
                " <when test='supplierNameQc!=null and supplierNameQc!=\"\"'>",
                " AND a.name like '%${supplierNameQc}%'",
                " </when>",
        " order by a.id desc",
        "</script>"})
    List<Map> querySupplierList(Map map);

}