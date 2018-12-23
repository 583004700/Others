package com.byefan.xhoa.mapper.biz;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.sys.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ArticleMapper extends BaseMapper<Article, Integer> {

    List<Article> list();

    @InsertProvider(type = ProviderUtil.class, method = "insert")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer save(Article article);

    @Select("select * from t_biz_article where order_id=#{orderId}")
    List<Article> listByOrderId(@Param("orderId") Integer orderId);


    @Select("update t_biz_article set file_path=#{filePath} where id=#{id}")
    List<Article> updatePathById(@Param("id") Integer id, @Param("filePath") String filePath);

    @Select("select b.* from t_biz_order a,t_biz_article b where a.id = b.order_id and b.income_states=0 and a.user_id =#{userId}")
    List<Map> queryArticleForIncome(@Param("userId") Integer userId);

    @Select("select b.* from t_biz_order a,t_biz_article b where a.id = b.order_id and b.outgo_states=0 and a.user_id =#{userId}")
    List<Map> queryArticleForOutgo(@Param("userId") Integer userId);

    @Update("update t_biz_article set income_states=1,income_amount=#{amount} where id=#{id} ")
    void updateAssignStatus(@Param("id") Integer id, @Param("amount") Double amount);

    @Update("update t_biz_article set income_amount=#{amount} where id=#{id}")
    void updateIncomeAmount(@Param("id") Integer id, @Param("amount") Double amount);

    @Select({"<script>",
            "select a.id id,a.media_id mediaId,a.media_name mediaName,a.supplier_id supplierId," +
                    " a.supplier_name supplierName,a.media_user_id mediaUserId,a.media_user_name mediaUserName," +
                    " a.brand brand,DATE_FORMAT(a.issued_date,\"%Y-%m-%d %H:%i:%s\") issuedDate,a.title title," +
                    " a.link link,a.num num,a.sale_amount saleAmount,a.income_amount incomeAmount,a.taxes taxes," +
                    " a.price_column priceColumn,a.price_type priceType,a.pay_amount payAmount," +
                    " a.outgo_amount outgoAmount,DATE_FORMAT(a.promise_date,\"%Y-%m-%d %H:%i:%s\") issuedDate," +
                    " DATE_FORMAT(a.income_date,\"%Y-%m-%d %H:%i:%s\") incomeDate,a.other_pay otherPay," +
                    " a.refund_amount refundAmount,a.remarks remarks,a.commission commission," +
                    " b.company_id companyId,b.company_name companyName,b.cust_id custId,b.cust_name custName," +
                    " b.user_id userId,b.user_name userName,b.amount amount,b.order_type orderType,b.no no " +
                    " from t_biz_article a\n" +
                    "    left join t_biz_order b on a.order_id=b.id\n" +
                    "    where 1=1" +
                    " and  a.supplier_id=#{supplierId}" +
                    " <when test='mediaUserNameQc!=null and mediaUserNameQc!=\"\"'>",
            " AND a.media_user_name like '%${mediaUserNameQc}%'",
            " </when>",
            " <when test='mediaNameQc!=null and mediaNameQc!=\"\"'>",
            " AND a.media_name like '%${mediaNameQc}%'",
            " </when>",
            " order by a.id desc",
            "</script>"})
    List<Map> queryArticleBySupplierId(@Param("supplierId") Integer supplierId, Map map);

    @Select({"<script>",
            "select a.id id,a.media_id mediaId,a.media_name mediaName,a.supplier_id supplierId," +
                    " a.supplier_name supplierName,a.media_user_id mediaUserId,a.media_user_name mediaUserName," +
                    " a.brand brand,DATE_FORMAT(a.issued_date,\"%Y-%m-%d %H:%i:%s\") issuedDate,a.title title," +
                    " a.link link,a.num num,a.sale_amount saleAmount,a.income_amount incomeAmount,a.taxes taxes," +
                    " a.price_column priceColumn,a.price_type priceType,a.pay_amount payAmount," +
                    " a.outgo_amount outgoAmount,DATE_FORMAT(a.promise_date,\"%Y-%m-%d %H:%i:%s\") issuedDate," +
                    " DATE_FORMAT(a.income_date,\"%Y-%m-%d %H:%i:%s\") incomeDate,a.other_pay otherPay," +
                    " a.refund_amount refundAmount,a.remarks remarks,a.commission commission," +
                    " b.company_id companyId,b.company_name companyName,b.cust_id custId,b.cust_name custName," +
                    " b.user_id userId,b.user_name userName,b.amount amount,b.order_type orderType,b.no no " +
                    " from t_biz_article a\n" +
                    "    left join t_biz_order b on a.order_id=b.id\n" +
                    "    where 1=1 " +
                    " and  b.user_id=#{userId,jdbcType=INTEGER} and a.year=#{year,jdbcType=SMALLINT} and a.month=#{month,jdbcType=TINYINT}" +
                    " <when test='supplierNameQc!=null and supplierNameQc!=\"\"'>",
            " AND a.supplier_name like '%${supplierNameQc}%'",
            " </when>",
            " <when test='mediaUserNameQc!=null and mediaUserNameQc!=\"\"'>",
            " AND a.media_user_name like '%${mediaUserNameQc}%'",
            " </when>",
            " <when test='mediaNameQc!=null and mediaNameQc!=\"\"'>",
            " AND a.media_name like '%${mediaNameQc}%'",
            " </when>",
            " order by a.id desc",
            "</script>"})
    List<Map> queryArticleForComm(Map map);

    @Select("select a.* from t_biz_article a left join t_biz_order b on a.order_id=b.id and b.state>-2 where a.state>-2 " +
            " b.user_id=#{userId} and a.year={year} and a.month={month}")
    List<Article> queryArticleForComm2(@Param("userId") Integer userId,@Param("year") Integer year,@Param("month") Integer month) ;

    @Select("select a.* from sys_user a left join t_biz_order b on a.id=b.user_id and b.state>-2 " +
            " left join t_biz_article c on b.id=c.order_id and c.state>-2 " +
            " where a.state>-2 and c.id=#{articleId} " +
            " ")
    User getUserByArticleId(@Param("articleId") Integer articleId) ;

    @Delete("delete from t_biz_article where order_id=#{orderId}")
    int delByOrderId(@Param("orderId") Integer orderId);
}
