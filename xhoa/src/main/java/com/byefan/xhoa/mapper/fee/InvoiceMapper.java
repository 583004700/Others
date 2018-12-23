package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Invoice;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface InvoiceMapper extends BaseMapper<Invoice,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Invoice t);

    @Select({"<script>",
            " SELECT id id,code code,no,no,cust_company_id custCompanyId,cust_company_name custCompanyName," +
                    " cust_id custId,cust_name custName," +
                    " type type,invoice_type invoiceType,title title,tax_code taxCode," +
                    " bank_no bankNo,bank_name bankName,address address,phone phone,amount amount," +
                    " tax_point taxPoint,tax_amount taxAmount,invoice_desc invoiceDesc," +
                    " state state,creator creator," +
                    " DATE_FORMAT(invoice_time,\"%Y-%m-%d %H:%i:%s\") invoiceTime," +
                    " DATE_FORMAT(apply_time,\"%Y-%m-%d %H:%i:%s\") applyTime," +
                    " apply_id applyId,apply_name applyName,dept_id deptId,dept_name deptName," +
                    " task_id taskId,item_id itemId,tax_type taxType" +
                " FROM fee_invoice " +
                " WHERE state >-2 " +
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
                            " and apply_id = #{user.id}",
                            " </when>",
                            " <when test='roleCode==\"ZZ\"'>",
                            " and dept_id=#{user.deptId}",
                            " </when>",
                            " <when test='roleCode==\"BZ\"'>",
                                " <foreach collection='user.deptIdSet' item='item' open='and dept_id in (' close=')' separator=','>",
                                " #{item}",
                                " </foreach>",
                            " </when>",
                            " <when test='roleCode==\"ZJ\"'>",
                                " <foreach collection='user.deptIdSet' item='item' open='and dept_id in (' close=')' separator=','>",
                                " #{item}",
                                " </foreach>",
                            " </when>",
                            "<when test='roleCode==\"FZ\"'>",
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
                    " AND title like '%${titleQc}%'",
                    " </when>",
                    " <when test='invoiceTypeQc!=null and invoiceTypeQc!=\"\"'>",
                    " AND invoice_type like '%${invoiceTypeQc}%'",
                    " </when>",
                    " <when test='typeQc!=null and typeQc!=\"\"'>",
                    " AND type like '%${typeQc}%'",
                    " </when>",
                    " <when test='startTimeQc!=null and startTimeQc!=\"\"'>",
                    " AND invoice_time &gt;= #{startTimeQc}",
                    " </when>",
                    " <when test='endTimeQc!=null and endTimeQc!=\"\"'>",
                    " AND invoice_time &lt;= #{endTimeQc}",
                    " </when>",
                " order by id desc",
            "</script>"})
    List<Map> listPg(Map map);

    @Select("select * from fee_invoice where state>-2 and id = #{id}")
    Invoice getById(Integer id);

    @Select({"<script>",
            "select a.id id,a.media_name mediaName,a.supplier_name supplierName,\n" +
                    "    a.media_user_name mediaUserName,a.brand brand,a.title title,a.link link,\n" +
                    "    a.sale_amount saleAmount,a.income_amount incomeAmount,a.taxes taxes,\n" +
                    "    a.price_column priceColumn,a.price_type priceType,a.pay_amount payAmount,\n" +
                    "    a.outgo_amount outgoAmount,a.promise_date promiseDate,a.income_date incomeDate,\n" +
                    "    a.other_pay otherPay,a.refund_amount refundAmount,a.remarks remarks,\n" +
                    "    a.commission commission,b.company_name companyName,b.cust_name custName," +
                    "    b.user_name userName,b.no no\n" +
                    "    from t_biz_article a\n" +
                    "    left join t_biz_order b on a.order_id=b.id\n" +
                    "    where a.state>-2 and b.state>-2 and a.invoice_states=0 and income_states=1 " +
                    " and  b.company_id=#{custCompanyIdSec} and b.cust_id=#{custIdSec}" +
                    " <when test='mediaUserNameQc!=null and mediaUserNameQc!=\"\"'>",
            " AND a.media_user_name like '%${mediaUserNameQc}%'",
            " </when>",
            " <when test='mediaNameQc!=null and mediaNameQc!=\"\"'>",
            " AND a.media_name like '%${mediaNameQc}%'",
            " </when>",
            " order by a.id desc",
            "</script>"})
    List<Map> listPgForSelectArticle(Map map);

    @Select({"<script>",
            " select a.id incomeId,c.id articleId,\n" +
                    "c.supplier_name supplierName,c.media_name mediaName,c.media_user_name mediaUserName,\n" +
                    "c.title title,c.link link, c.income_amount incomeAmount,c.outgo_amount outgoAmount,c.issued_date issueDate, " +
                    "c.sale_amount saleAmount,c.pay_amount payAmount,d.no no,d.company_name companyName," +
                    "d.user_id userId,d.user_name userName,d.no no\n" +
                    " FROM fee_invoice a,fee_invoice_article b,t_biz_article c,t_biz_order d\n" +
                    " where a.id=b.invoice_id and b.article_id=c.id and c.order_id=d.id and a.id=#{id} " +
                    " and a.state>-2 and c.state>-2 and d.state>-2 " +
                    " order by c.id desc",
            "</script>"})
    List<Map> listPgForSelectedArticle(Integer id);

    @Insert("insert into fee_invoice_article (invoice_id,article_id) values (#{invoiceId},#{articleId})")
    void insertInvoiceArticle(@Param("invoiceId") Integer invoiceId, @Param("articleId") Integer articleId);

    @Delete("delete from fee_invoice_article where invoice_id=#{invoiceId}")
    void delInvoiceArticle(@Param("invoiceId") Integer invoiceId) ;

    @Select("select sum(c.income_amount) from fee_invoice a,fee_invoice_article b,t_biz_article c " +
            " where a.id=b.invoice_id and b.article_id=c.id " +
            " and a.state>-2 and c.state>-2 " +
            " and a.id=#{id}")
    Double getSumAmountById(@Param("id") Integer id) ;

    @Select("select c.* " +
            " from fee_invoice a,fee_invoice_article b,t_biz_article c" +
            " where a.id=b.invoice_id and b.article_id=c.id " +
            " and a.state>-2 and c.state>-2 and a.id=#{invoiceId}")
    List<Article> queryArticleById(@Param("invoiceId") Integer invoiceId) ;

}
