package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.fee.Commission;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CommissionMapper extends BaseMapper<Commission,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Commission t);

    @Select({"<script>",
            " SELECT * " +
                " FROM fee_commission " +
                " WHERE state > -2 " +
                    " <choose>",
                    " <when test='roleType==\"LD\"'>",
                    " and 1=1",
                    " </when>",
                    " <when test='roleType==\"CW\"'>",
                    " and 1=1",
                    " </when>",
                    " <when test='roleType==\"YW\"'>",
                        " <choose>",
                        " <when test='roleCode==\"YG\"'>",
                        " and user_id=#{user.id}",
                        " </when>",
                        " <when test='roleCode==\"ZZ\"'>",
                        " and dept_id in (#{user.deptId})",
                        " </when>",
                        " <when test='roleCode==\"BZ\"'>",
                        " <foreach collection='user.deptIdSet' item='item' open='and dept_id in (' close=')' separator=','>",
                        " #{item}",
                        " </foreach>",
                        " </when>",
                        " <when test='roleCode==\"ZJ\"'>",
                        " and dept_id in (#{user.deptIds})",
                        " </when>",
                        "</choose>",
                    " </when>",
                    " <otherwise>",
                    " and 1=3",
                    " </otherwise>",
                    " </choose>",
                    " <when test='nameQc!=null and nameQc!=\"\"'>",
                    " AND name like '%${nameQc}%'",
                    " </when>",
                    " <when test='yearQc!=null and yearQc!=\"\"'>",
                    " AND year = #{yearQc}",
                    " </when>",
                    " <when test='monthQc!=null and monthQc!=\"\"'>",
                    " AND month = #{monthQc}",
                    " </when>",
                " order by id desc",
            "</script>"})
    List<Map> listPg(Map map);

    @Select("select * from fee_commission where state>-2 and id = #{id}")
    Commission getById(Integer id);

    @Select("select * from fee_commission where state>-2 and id = #{id} and year=#{year} and month-#{month}")
    List<Commission> queryCommissionByUser(@Param("id")Integer userId,@Param("year")Integer year,@Param("month")Integer month);

    @Select("select * from fee_commission where state>-2 and year=#{year} and month-#{month}")
    List<Commission> queryCommissionByMonth(@Param("year")Integer year,@Param("month")Integer month);

    /**
     * 更新提成的年和月
     */
    @Update("update fee_commission set year=#{year},month=#{month} where year!=#{year} and month!=#{month} and state>-2")
    void updateCommissionByMonth(@Param("year")Integer year,@Param("month")Integer month) ;
}
