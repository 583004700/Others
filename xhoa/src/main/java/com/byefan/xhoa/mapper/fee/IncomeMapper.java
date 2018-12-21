package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Income;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IncomeMapper extends BaseMapper<Income,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Income t);

    @Select({"<script>",
            " SELECT a.* " +
                    " ,CONVERT(GROUP_CONCAT(b.name,':',b.receive_amount)USING utf8) receiveInfo" +
                " FROM fee_income a left join fee_income_user b on a.id=b.income_id and b.state>-2 " +
                " where a.state > -2 " +
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
                        " and #{deptId} in (select d.dept_id from fee_account_dept d where d.account_id=a.account_id)",
                        " </when>",
                        " <when test='roleCode==\"ZZ\"'>",
                        " and #{deptId} in (select d.dept_id from fee_account_dept d where d.account_id=a.account_id)",
                        " </when>",
                        " <when test='roleCode==\"BZ\"'>",
                        " and #{deptId} in (select d.dept_id from fee_account_dept d where d.account_id=a.account_id)",
                        " </when>",
                        " <when test='roleCode==\"ZJ\"'>",
                        " and #{deptId} in (select d.dept_id from fee_account_dept d where d.account_id=a.account_id)",
                        " </when>",
                        "</choose>",
                    " </when>",
                    " <otherwise>",
                    " and 1=3",
                    " </otherwise>",
                    " </choose>",
                    " <when test='accountNameQc!=null and accountNameQc!=\"\"'>",
                    " AND a.account_name like '%${accountNameQc}%'",
                    " </when>",
                    " <when test='bankNoQc!=null and bankNoQc!=\"\"'>",
                    " AND a.bank_no like '%${bankNoQc}%'",
                    " </when>",
                    " <when test='tradeManQc!=null and tradeManQc!=\"\"'>",
                    " AND a.trade_man like '%${tradeManQc}%'",
                    " </when>",
                    " <when test='tradeBankQc!=null and tradeBankQc!=\"\"'>",
                    " AND a.trade_bank like '%${tradeBankQc}%'",
                    " </when>",
                    " <when test='startTimeQc!=null and startTimeQc!=\"\"'>",
                    " AND a.trade_time &gt;= #{startTimeQc}",
                    " </when>",
                    " <when test='endTimeQc!=null and endTimeQc!=\"\"'>",
                    " AND a.trade_time &lt;= #{endTimeQc}",
                    " </when>",
                    " <when test='tradeAmountQc!=null and tradeAmountQc!=\"\"'>",
                    " AND a.trade_amount like '%${tradeAmountQc}%'",
                    " </when>",
                "  group by a.id order by a.id desc",
            "</script>"})
    List<Map> listPg(Map map);

    @Select("select * from fee_income where state>-2 and id = #{id}")
    Income getById(Integer id);

    /**
     * 查询分款未完成和未提成的稿件，用于分款
     * @param map
     * @return 未分款的稿件列表
     */
    @Select({"<script>",
            " SELECT a.*,b.no no,b.user_name userName,b.company_name companyName,b.cust_name custName " +
                " FROM t_biz_article a,t_biz_order b " +
                " where a.order_id=b.id and a.state>-2 and b.state>-2 " +
                    "and a.income_states!=1 and a.issue_states=4 " +
                    "and a.commission_states=0 and b.user_id=#{userId} " +
                    " <when test='custCompanyNameQc!=null and custCompanyNameQc!=\"\"'>",
                    " AND b.supplier_name like '%${custCompanyNameQc}%'",
                    " </when>",
                    " <when test='titleQc!=null and titleQc!=\"\"'>",
                    " AND b.title like '%${titleQc}%'",
                    " </when>",
            "  order by a.id desc",
            "</script>"})
    List<Map> queryArticleForAssign(Map map);

    @Insert("insert into fee_income_article (income_id,article_id,state) values (#{incomeId},#{articleId},0)")
    void insertIncomeArticle(@Param("incomeId") Integer incomeId, @Param("articleId") Integer articleId);


    @Select({"<script>",
            " select a.id incomeId,c.id articleId,a.code code," +
                    "c.supplier_name supplierName,c.media_name mediaName,c.media_user_name mediaUserName," +
                    "c.title title,c.link link, c.income_amount incomeAmount,c.outgo_amount outgoAmount,c.issued_date issueDate, " +
                    "c.sale_amount saleAmount,c.pay_amount payAmount,b.amount assignAmount,d.user_name userName," +
                    " DATE_FORMAT(b.date,\"%Y-%m-%d %H:%i:%s\") assignDate," +
                    " d.no no,d.company_name companyName" +
                    " FROM fee_income a,fee_income_article b,t_biz_article c,t_biz_order d" +
                    " where a.id=b.income_id and b.article_id=c.id and a.id=#{id} and c.order_id=d.id " +
                    " and a.state >-2 and b.state>-2 and c.state>-2 and d.state>-2 " +
                    " order by c.id desc",
            "</script>"})
    List<Map> listPgForSelectedArticle(Integer id);

    @Select({"select inc.*,inart.date date,inart.amount amount from fee_income inc left join fee_income_article inart on inc.id = inart.income_id where inc.state>-2 and inart.article_id = #{id}"})
    List<Map> listPgByArticleId(Article article);

    @Select("select t.* from fee_income t where t.state>-2 and t.account_id=#{accountId}")
    List<Income> queryIncomeByAccountId(Integer accountId);
}
