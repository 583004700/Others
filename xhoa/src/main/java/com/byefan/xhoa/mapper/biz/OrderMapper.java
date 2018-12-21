package com.byefan.xhoa.mapper.biz;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.biz.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper extends BaseMapper<Order, Integer> {

    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Order order);

    @Select("select * from t_biz_order where no=#{no}")
    Order getByNo(@Param("no") String no);

    @Select({"<script>", "SELECT * FROM (SELECT a.* ,b.`id` cid,b.`user_name` cusername,b.`name` cname,\n" +
            "  c.`id` uid,c.`user_name` uusername,c.`name` uname,d.id did,d.name deptname\n" +
            "FROM t_biz_order a LEFT JOIN sys_user b ON a.`user_id` = b.`id` \n" +
            "  LEFT JOIN sys_user c ON a.`update_user_id` = c.`id` \n" +
            "  LEFT JOIN sys_dept d ON a.`depat_id` = c.`id` ) a" +
            " <when test='state!=null '>",
            " AND a.state=#{state}", "</when>",
            " <when test='companyId!=null '>",
            " AND a.company_id =#{companyId}", " </when>",
            " order by id desc",
            "</script>"})
    @Results({@Result(column = "cid", property = "user.id"),
            @Result(column = "cusername", property = "user.userName"),
            @Result(column = "cname", property = "user.name"),
            @Result(column = "did", property = "dept.id"),
            @Result(column = "deptname", property = "dept.name"),
            @Result(column = "uid", property = "updateUser.id"),
            @Result(column = "uusername", property = "updateUser.userName"),
            @Result(column = "uname", property = "updateUser.name"),
    })
    List<Order> search(Order order);
}