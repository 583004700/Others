package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.fee.Borrow;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BorrowMapper extends BaseMapper<Borrow,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Borrow t);

    @Select({"<script>",
            " SELECT a.id id,a.code code,a.title title,a.type type," +
                    " a.account_id accountId,a.account_name accountName,a.account_bank_no accountBankNo," +
                    " a.account_bank_name accountBankName,a.apply_id applyId,a.apply_name applyName," +
                    " DATE_FORMAT(a.apply_time,\"%Y-%m-%d %H:%i:%s\") applyTime," +
                    " a.apply_amount applyAmount,DATE_FORMAT(a.expert_pay_time,\"%Y-%m-%d %H:%i:%s\") expertPayTime," +
                    " a.out_account_id outAccountId,a.out_account_name outAccountName,a.pay_amount payAmount," +
                    " DATE_FORMAT(a.pay_time,\"%Y-%m-%d %H:%i:%s\") payTime,a.pay_user_id payUserId," +
                    " a.state state,a.remark remark,a.affix_name affix_name,a.affix_link affixLink," +
                    " a.repay_amount repayAmount,a.repay_flag repayFlag,a.remain_amount remainAmount," +
                    " DATE_FORMAT(a.repay_time,\"%Y-%m-%d %H:%i:%s\") repayTime," +
                    " a.creator creator,a.create_time createTime," +
                    " a.update_user_id updateUserId,a.update_time updateTime,a.task_id taskId,item_id itemId," +
                    " a.dept_name deptName,a.repaying repaying " +
                " FROM fee_borrow a" +
                " WHERE a.state >-2 " +
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
                            " <foreach collection='user.deptIdSet' item='item' open='and a.dept_id in (' close=')' separator=','>",
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
                            " <foreach collection='user.deptIdSet' item='item' open='and a.dept_id in (' close=')' separator=','>",
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

    @Select("select * from fee_borrow where state>-2 and id = #{id}")
    Borrow getById(Integer id);

    @Select("select c.* " +
            " from fee_outgo a,fee_outgo_borrow b,fee_borrow c" +
            " where a.id=b.outgo_id and b.borrow_id=c.id " +
            " and a.state>-2 and c.state>-2 and a.id=#{outgoId}")
    List<Borrow> queryByOutgoId(@Param("outgoId") Integer outgoId) ;

    @Select("select c.*,b.amount amount " +
            " from fee_outgo a,fee_outgo_borrow b,fee_borrow c" +
            " where a.id=b.outgo_id and b.borrow_id=c.id " +
            " and a.state>-2 and c.state>-2 and a.id=#{outgoId}")
    List<Map> queryByOutgoId2(@Param("outgoId") Integer outgoId) ;

    /**
     * 查询出已借款并且未还款的
     * @param map
     * @return
     */
    @Select({"<script>",
            " SELECT a.id id,a.code code,a.title title,a.type type," +
                    " a.account_id accountId,a.account_name accountName,a.account_bank_no accountBankNo," +
                    " a.account_bank_name accountBankName,a.apply_id applyId,a.apply_name applyName," +
                    " DATE_FORMAT(a.apply_time,\"%Y-%m-%d %H:%i:%s\") applyTime," +
                    " a.apply_amount applyAmount,DATE_FORMAT(a.expert_pay_time,\"%Y-%m-%d %H:%i:%s\") expertPayTime," +
                    " a.out_account_id outAccountId,a.out_account_name outAccountName,a.pay_amount payAmount," +
                    " DATE_FORMAT(a.pay_time,\"%Y-%m-%d %H:%i:%s\") payTime,a.pay_user_id payUserId," +
                    " a.state state,a.remark remark,a.affix_name affix_name,a.affix_link affixLink," +
                    " a.repay_amount repayAmount,a.repay_flag repayFlag,a.remain_amount remainAmount," +
                    " DATE_FORMAT(a.repay_time,\"%Y-%m-%d %H:%i:%s\") repayTime," +
                    " a.creator creator,a.create_time createTime," +
                    " a.update_user_id updateUserId,a.update_time updateTime," +
                    " a.dept_name deptName" +
                    " FROM fee_borrow a" +
                    " WHERE a.state = 1 and a.repay_flag!=1 " +
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
    List<Map> listPgForOutgo(Map map);
}
