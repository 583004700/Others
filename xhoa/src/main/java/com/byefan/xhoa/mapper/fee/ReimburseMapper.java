package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.fee.Reimburse;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ReimburseMapper extends BaseMapper<Reimburse,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Reimburse t);

    @Select({"<script>",
            " SELECT a.id id,a.code code,a.title title,a.type type," +
                    " a.rec_id recId,a.rec_name recName,a.rec_bank_no recBankNo,a.rec_bank_name recBankName," +
                    " a.apply_id applyId,a.apply_name applyName,DATE_FORMAT(a.apply_time,\"%Y-%m-%d %H:%i:%s\") applyTime," +
                    " a.apply_amount applyAmount,a.expert_pay_time expertPayTime," +
                    " a.out_account_id outAccountId,a.out_account_name outAccountName," +
                    " a.pay_amount payAmount,DATE_FORMAT(a.pay_time,\"%Y-%m-%d %H:%i:%s\") payTime,a.pay_user_id payUserId," +
                    " a.state state,a.remark remark,a.affix affix,a.flag flag," +
                    " creator creator,create_time createTime,update_user_id updateUserId,update_time updateTime" +
                " FROM fee_reimburse a" +
                " WHERE state=0 " +
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

    @Select("select * from fee_reimburse where state=0 and id = #{id}")
    Reimburse getById(Integer id);
}
