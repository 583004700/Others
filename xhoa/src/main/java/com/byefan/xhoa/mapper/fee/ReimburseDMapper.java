package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.fee.ReimburseD;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ReimburseDMapper extends BaseMapper<ReimburseD,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(ReimburseD t);

    @Select({"<script>",
            " SELECT a.id id,a.title title,a.type type,a.purpose purpose," +
                    " a.amount amount,a.bill_num billNum,a.state state" +
//                    " creator creator,create_time createTime,update_user_id updateUserId,update_time updateTime" +
                " FROM fee_reimburse_d a" +
                " WHERE state=0 " +
                    " <when test='titleQc!=null and titleQc!=\"\"'>",
                    " AND a.title like '%${titleQc}%'",
                    " </when>",
                    " <when test='typeQc!=null and typeQc!=\"\"'>",
                    " AND a.type like '%${typeQc}%'",
                    " </when>",
                " order by id desc",
            "</script>"})
    List<Map> listPg(Map map);

    @Select("select * from fee_reimburse_d where state=0 and id = #{id}")
    ReimburseD getById(Integer id);
}
