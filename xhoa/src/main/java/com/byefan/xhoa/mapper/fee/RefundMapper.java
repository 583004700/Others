package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Refund;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface RefundMapper extends BaseMapper<Refund,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Refund t);

    @Select({"<script>",
            " SELECT a.id id ,a.code code,a.title title,a.type type,a.cust_id custId,a.cust_name custName," +
                    " a.cust_company_id custCompanyId,a.cust_company_name custCompanyName," +
                    " a.account_id accountId,a.account_name accountName,a.account_bank_no accountBankNo," +
                    " a.account_bank_name accountBankName,a.out_account_id outAccountId,a.out_account_name outAccountName," +
                    " a.refund_amount refundAmount,a.other_pay otherPay,a.apply_amount applyAmount," +
                    " DATE_FORMAT(a.apply_time,\"%Y-%m-%d %H:%i:%s\") applyTime, " +
                    " DATE_FORMAT(a.pay_time,\"%Y-%m-%d %H:%i:%s\") payTime, " +
                    " a.pay_amount payAmount,a.state state,a.creator creator,a.create_time createTime," +
                    " a.update_user_id updateUserId,a.update_time updateTime,a.task_id taskId,a.item_id itemId," +
                    " a.apply_name applyName,a.dept_name deptName " +
                " FROM fee_refund a" +
                " WHERE a.state > -2 " +
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
                    " <when test='titleQc!=null and titleQc!=\"\"'>",
                    " AND a.title like '%${titleQc}%'",
                    " </when>",
                    " <when test='recNameQc!=null and recNameQc!=\"\"'>",
                    " AND a.rec_name like '%${recNameQc}%'",
                    " </when>",
                    " <when test='bankNoQc!=null and bankNoQc!=\"\"'>",
                    " AND a.rec_bank_no like '%${bankNoQc}%'",
                    " </when>",
                    " <when test='bankNameQc!=null and bankNameQc!=\"\"'>",
                    " AND a.rec_bank_name like '%${bankNameQc}%'",
                    " </when>",
                    " <when test='applyNameQc!=null and applyNameQc!=\"\"'>",
                    " AND a.apply_name like '%${applyNameQc}%'",
                    " </when>",
                    " <when test='startTimeQc!=null and startTimeQc!=\"\"'>",
                    " AND a.pay_time &gt;= #{startTimeQc}",
                    " </when>",
                    " <when test='endTimeQc!=null and endTimeQc!=\"\"'>",
                    " AND a.pay_time &lt;= #{endTimeQc}",
                    " </when>",
                    " <when test='payAmountQc!=null and payAmountQc!=\"\"'>",
                    " AND a.pay_amount like '%${payAmountQc}%'",
                    " </when>",
                " order by id desc",
            "</script>"})
    List<Map> listPg(Map map);

    @Select("select * from fee_refund where state>-2 and id = #{id}")
    Refund getById(Integer id);

    /**
     * 查询没有退款和提成的稿件，已提成和已退款的稿件不支持退款操作
     * @param map
     * @return
     */
    @Select({"<script>",
            "select a.id id,a.media_name mediaName,a.supplier_name supplierName,\n" +
                    "    a.media_user_name mediaUserName,a.brand brand,a.title title,a.link link,\n" +
                    "    a.sale_amount saleAmount,a.income_amount incomeAmount,a.taxes taxes,\n" +
                    "    a.price_column priceColumn,a.price_type priceType,a.pay_amount payAmount,\n" +
                    "    a.outgo_amount outgoAmount,a.promise_date promiseDate,a.income_date incomeDate,\n" +
                    "    a.other_pay otherPay,a.refund_amount refundAmount,a.remarks remarks,\n" +
                    "    a.commission commission,b.company_name companyName,b.cust_name custName,\n" +
                    "    b.user_name userName,b.no no" +
                    "    from t_biz_article a\n" +
                    "    left join t_biz_order b on a.order_id=b.id\n" +
                    "    where a.state>-2 and b.state>-2  and a.commission_states !=1 and a.income_states=1 and a.refund_states=0 " +
                    " and  b.company_id=#{custCompanyIdSec} and b.cust_id=#{custIdSec} " +
                    " <when test='mediaUserNameQc!=null and mediaUserNameQc!=\"\"'>",
            " AND a.media_user_name like '%${mediaUserNameQc}%'",
            " </when>",
            " <when test='mediaNameQc!=null and mediaNameQc!=\"\"'>",
            " AND a.media_name like '%${mediaNameQc}%'",
            " </when>",
            " order by a.id desc",
            "</script>"})
    List<Map> listPgForSelectArticle(Map map);

    /**
     *
     * @param id 退款订单id
     * @return 关联了退款订单的稿件列表
     */
    @Select({"<script>",
            " select a.id incomeId,c.id articleId,\n" +
                    "c.supplier_name supplierName,c.media_name mediaName,c.media_user_name mediaUserName,\n" +
                    "c.title title,c.link link, c.income_amount incomeAmount,c.outgo_amount outgoAmount,c.issued_date issueDate, " +
                    "c.sale_amount saleAmount,c.refund_amount refundAmount,c.other_pay otherPay,c.pay_amount payAmount," +
                    "d.company_name companyName,d.user_name userName,d.no no\n" +
                    " FROM fee_refund a,fee_refund_article b,t_biz_article c,t_biz_order d\n" +
                    " where a.id=b.refund_id and b.article_id=c.id and c.order_id=d.id " +
                    " and a.state>-2 and c.state>-2 and d.state>-2 and a.id=#{id} " +
                    " order by c.id desc",
            "</script>"})
    List<Map> listPgForSelectedArticle(Integer id);

    @Insert("insert into fee_refund_article (refund_id,article_id) values (#{refundId},#{articleId})")
    void insertRefundArticle(@Param("refundId") Integer refundId, @Param("articleId") Integer articleId);

    @Delete("delete from fee_refund_article where refund_id=#{refundId}")
    void delRefundArticle(@Param("refundId") Integer refundId) ;

    @Select("select sum(c.refund_amount) sumRefundAmount,sum(c.other_pay) sumOtherPay " +
            " from fee_refund a,fee_refund_article b,t_biz_article c,t_biz_order d " +
            " where a.id=b.refund_id and b.article_id=c.id and c.order_id=d.id " +
            "and a.state > -2 and c.state > -2 and d.state>-2 " +
            " and a.id=#{id}")
    Map querySumAmountById(@Param("id") Integer id) ;

    @Select("select c.* " +
            " from fee_refund a,fee_refund_article b,t_biz_article c" +
            " where a.id=b.refund_id and b.article_id=c.id " +
            " and a.state > -2 and c.state > -2 and a.id=#{refundId}")
    List<Article> queryArticleById(@Param("refundId") Integer refundId) ;
}
