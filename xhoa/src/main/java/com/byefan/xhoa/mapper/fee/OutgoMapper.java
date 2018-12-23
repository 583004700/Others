package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Outgo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface OutgoMapper extends BaseMapper<Outgo,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Outgo t);

    @Select({"<script>",
            " SELECT a.id id ,a.code code,a.title title,a.supplier_id supplierId,a.supplier_name supplierName," +
                    " a.account_id accountId,a.account_name accountName,a.account_bank_no accountBankNo," +
                    " a.account_bank_name accountBankName,a.out_account_id outAccountId,a.out_account_name outAccountName," +
                    " a.apply_id applyId,a.apply_name applyName,a.dept_id deptId,a.dept_name deptName," +
                    " a.apply_amount applyAmount," +
                    " DATE_FORMAT(a.expert_pay_time,\"%Y-%m-%d %H:%i:%s\") expertPayTime, " +
                    " DATE_FORMAT(a.pay_time,\"%Y-%m-%d %H:%i:%s\") payTime, " +
                    " DATE_FORMAT(a.apply_time,\"%Y-%m-%d %H:%i:%s\") applyTime, " +
                    " a.pay_amount payAmount," +
                    " a.state state,a.creator creator,a.create_time createTime," +
                    " a.update_user_id updateUserId,a.update_time updateTime,a.fund_flag fundFlag,a.fund_amount fundAmount," +
                    " a.task_id taskId,a.item_id itemId" +
                " FROM fee_outgo a  " +
                " WHERE a.state > -2 " +
                        " <choose>",
                        " <when test='roleType==\"LD\"'>",
                        " and 1=1",
                        " </when>",
                        " <when test='roleType==\"CW\"'>",
                        " and 1=1",
                        " </when>",
                        " <when test='roleType==\"MJ\"'>",
                            " <choose>",
                            " <when test='roleCode==\"YG\"'>",
                            " and a.apply_id = #{user.id}",
                            " </when>",
                            " <when test='roleCode==\"ZZ\"'>",
                            " and a.dept_id=#{user.deptId}",
                            " </when>",
                            " <when test='roleCode==\"BZ\"'>",
                            " <foreach collection='user.deptIdSet' item='item' open='and a.dept_id in (' close=')' separator=','>",
                            " #{item}",
                            " </foreach>",
                            " </when>",
                            " <when test='roleCode==\"ZJ\"'>",
                            " AND 1=1",
                            " </when>",
                            " <when test='roleCode==\"FZ\"'>",
                            " AND 1=1",
                            " </when>",
                            " <when test='roleCode==\"ZJL\"'>",
                            " AND 1=1",
                            " </when>",
                            "</choose>",
                        " </when>",
                        " <otherwise>",
                        " and 1=3",
                        " </otherwise>",
                        " </choose>",
                    " <when test='supplierNameQc!=null and supplierNameQc!=\"\"'>",
                    " AND a.supplier_name like '%${supplierNameQc}%'",
                    " </when>",
                    " <when test='supplierNameQc!=null and supplierNameQc!=\"\"'>",
                    " AND a.supplier_name like '%${supplierNameQc}%'",
                    " </when>",
                    " <when test='accountNameQc!=null and accountNameQc!=\"\"'>",
                    " AND a.account_name like '%${accountNameQc}%'",
                    " </when>",
                    " <when test='accountBankNoQc!=null and accountBankNoQc!=\"\"'>",
                    " AND a.account_bank_no like '%${accountBankNoQc}%'",
                    " </when>",
                    " <when test='outAccountNameQc!=null and outAccountNameQc!=\"\"'>",
                    " AND a.out_account_name like '%${outAccountNameQc}%'",
                    " </when>",
                    " <when test='applyStartTimeQc!=null and applyStartTimeQc!=\"\"'>",
                    " AND a.apply_time &gt;= #{applyStartTimeQc}",
                    " </when>",
                    " <when test='applyEndTimeQc!=null and applyEndTimeQc!=\"\"'>",
                    " AND a.create_time &lt;= #{applyEndTimeQc}",
                    " </when>",
                    " <when test='PayStartTimeQc!=null and PayStartTimeQc!=\"\"'>",
                    " AND a.create_time &gt;= #{PayStartTimeQc}",
                    " </when>",
                    " <when test='payEndTimeQc!=null and payEndTimeQc!=\"\"'>",
                    " AND a.pay_time &lt;= #{payEndTimeQc}",
                    " </when>",
                    " <when test='applyAmountQc!=null and applyAmountQc!=\"\"'>",
                    " AND a.apply_amount like '%${applyAmountQc}%'",
                    " </when>",
                    " <when test='payAmountQc!=null and payAmountQc!=\"\"'>",
                    " AND a.pay_amount &gt;= #{payAmountQc}",
                    " </when>",
                " order by a.id desc",
            "</script>"})
    List<Map> listPg(Map map);

    @Select("select * from fee_outgo where state>-2 and id = #{id}")
    Outgo getById(Integer id);

    @Insert("insert into fee_outgo_article (outgo_id,article_id,state) values (#{outgoId},#{articleId},0)")
    void insertOutgoArticle(@Param("outgoId") Integer outgoId, @Param("articleId") Integer articleId);

    @Delete("delete from fee_outgo_article where outgo_id=#{outgoId}")
    void delOutgoArticle(@Param("outgoId") Integer outgoId) ;

    @Select({"<script>",
            " select a.id outgoId,c.id articleId,\n" +
                    "c.supplier_name supplierName,c.media_name mediaName,c.media_user_name mediaUserName,\n" +
                    "c.title,c.link, c.income_amount incomeAmount,c.outgo_amount outgoAmount," +
                    "c.sale_amount saleAmount,c.pay_amount payAmount," +
                    "d.user_name userName,d.no no,d.company_name companyName,d.cust_name custName " +
                    " FROM fee_outgo a,fee_outgo_article b,t_biz_article c,t_biz_order d\n" +
                    " where a.id=b.outgo_id and b.article_id=c.id and c.order_id=d.id " +
                    " and a.state>-2 and c.state>-2 and d.state>-2 and a.id=#{id} " +
            " order by c.id desc",
            "</script>"})
    List<Map> listPgForSelectedArticle(Integer id);

    @Select({"<script>",
            "select a.id id,a.media_name mediaName,a.supplier_name supplierName,\n" +
                    "    a.media_user_name mediaUserName,a.brand brand,a.title title,a.link link,\n" +
                    "    a.sale_amount saleAmount,a.income_amount incomeAmount,a.taxes taxes,\n" +
                    "    a.price_column priceColumn,a.price_type priceType,a.pay_amount payAmount,\n" +
                    "    a.outgo_amount outgoAmount,a.promise_date promiseDate,a.income_date incomeDate,\n" +
                    "    a.other_pay otherPay,a.refund_amount refundAmount,a.remarks remarks,\n" +
                    "    a.commission commission,b.company_name companyName,b.cust_name custName," +
                    "    b.user_name userName,b.no no \n" +
                    "    from t_biz_article a\n" +
                    "    left join t_biz_order b on a.order_id=b.id\n" +
                    "    where a.state>-2 and b.state>-2 and a.outgo_states=0" +
                    " and  a.supplier_id=#{supplierIdSec}" +
                    " <when test='mediaUserNameQc!=null and mediaUserNameQc!=\"\"'>",
            " AND a.media_user_name like '%${mediaUserNameQc}%'",
            " </when>",
            " <when test='mediaNameQc!=null and mediaNameQc!=\"\"'>",
            " AND a.media_name like '%${mediaNameQc}%'",
            " </when>",
            " order by a.id desc",
            "</script>"})
    List<Map> listPgForSelectArticle(Map map);

    @Select("select c.* " +
            " from fee_outgo a,fee_outgo_article b,t_biz_article c" +
            " where a.id=b.outgo_id and b.article_id=c.id " +
            " and a.state>-2 and c.state>-2 and a.id=#{outgoId}")
    List<Article> queryArticleById(@Param("outgoId") Integer outgoId) ;

    @Select("select sum(c.outgo_amount) sumAmount " +
            " from fee_outgo a,fee_outgo_article b,t_biz_article c" +
            " where a.id=b.outgo_id and b.article_id=c.id " +
            " and a.state>-2 and c.state>-2 and a.id=#{outgoId}")
    Double getSumAmountById(@Param("outgoId") Integer outgoId) ;

    @Select("select b.amount,c.* " +
            " from fee_outgo a,fee_outgo_borrow b,fee_borrow c" +
            " where a.id=b.outgo_id and b.borrow_id=c.id " +
            " and a.state>-2 and c.state>-2 and a.id=#{outgoId}")
    List<Map> queryBorrowById(@Param("outgoId") Integer outgoId) ;

}
