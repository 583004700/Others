package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.fee.IncomeUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface IncomeUserMapper extends BaseMapper<IncomeUser,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(IncomeUser t);

    @UpdateProvider(type = ProviderUtil.class, method = "update")
    int update2(IncomeUser record);

    @Select("select * from fee_income_user where state>-2 and id = #{id}")
    IncomeUser getById(Integer id);

    @Select("select b.* from fee_income_user b where b.state>-2 and b.income_id = #{incomeId} and b.user_id = #{userId}")
    IncomeUser getIncomeUser(@Param("incomeId") Integer incomeId, @Param("userId") Integer userId);

    @Update("update fee_income_user set state=-9 where income_id = #{incomeId}")
    void deleteIncomeUserByIncomeId(@Param("incomeId") Integer incomeId) ;

    @Delete("update fee_income_user set state=-9 where income_id = #{incomeId} and user_id = #{userId}")
    void deleteIncomeUserByIncomeIdAndUserId(@Param("incomeId") Integer incomeId, @Param("userId") Integer userId) ;

    @Select({"<script>",
            " select b.code code,a.name name,a.dept_name deptName,a.receive_amount receiveAmount,a.name name," +
                    " DATE_FORMAT(a.receive_time,\"%Y-%m-%d %H:%i\") receiveTime," +
                    " a.assign_amount assignAmount,a.remain_amount remainAmount," +
                    " b.id incomeId,b.account_name accountName,DATE_FORMAT(b.trade_time,\"%Y-%m-%d %H:%i\") tradeTime," +
                    " b.trade_bank tradeBank,b.bank_no bankNo," +
                    " b.trade_man tradeMan,b.trade_amount tradeAmount,b.cust_company_name custCompanyName " +
                    " from fee_income_user a,fee_income b" +
                    " where a.income_id=b.id and a.state>-2 and b.state>-2 and a.user_id=#{id}" +
                        " <when test='accountNameQc!=null and accountNameQc!=\"\"'>",
                        " AND b.account_name like '%${accountNameQc}%'",
                        " </when>",
                        " <when test='bankNoQc!=null and bankNoQc!=\"\"'>",
                        " AND b.bank_no like '%${bankNoQc}%'",
                        " </when>",
                        " <when test='tradeManQc!=null and tradeManQc!=\"\"'>",
                        " AND b.trade_man like '%${tradeManQc}%'",
                        " </when>",
                        " <when test='tradeBankQc!=null and tradeBankQc!=\"\"'>",
                        " AND b.trade_bank like '%${tradeBankQc}%'",
                        " </when>",
                        " <when test='startTimeQc!=null and startTimeQc!=\"\"'>",
                        " AND b.trade_time &gt;= #{startTimeQc}",
                        " </when>",
                        " <when test='endTimeQc!=null and endTimeQc!=\"\"'>",
                        " AND b.trade_time &lt;= #{endTimeQc}",
                        " </when>",
                        " <when test='tradeAmountQc!=null and tradeAmountQc!=\"\"'>",
                        " AND b.trade_amount like '%${tradeAmountQc}%'",
                        " </when>",
                    " order by a.id desc ",
            "</script>"})
    List<Map> listPgForAssign(Map map);

    @Select("select b.* from fee_income_user b where b.state>-2 and b.income_id = #{incomeId}")
    List<IncomeUser> queryIncomeUserByIncomeId(@Param("incomeId") Integer incomeId);

    @Select("select b.* from fee_income_user b where b.state>-2 and b.income_id = #{incomeId} and user_id = #{userId}")
    List<IncomeUser> queryIncomeUserByIncomeIdAndUserId(@Param("incomeId") Integer incomeId,@Param("userId") Integer userId);

    @Select("select sum(b.receive_amount) receiveSum,sum(b.remain_amount) remainSum from fee_income_user b where b.state>-2 and b.income_id = #{incomeId} and user_id = #{userId}")
    Map querySumAmount(@Param("incomeId") Integer incomeId,@Param("userId") Integer userId);
}
