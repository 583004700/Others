package com.byefan.xhoa.mapper.workbench;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.workbench.Items;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ItemsMapper extends BaseMapper<Items,Integer>{
    @Select({"<script>",
            "SELECT it.id id,it.item_name itemName,\n"+
            "it.item_type itemType,\n"+
            "it.work_type workType,\n"+
            "it.start_time startTime,\n"+
            "it.create_time createTime,\n"+
            "it.end_time endTime,\n"+
            "it.transaction_address transactionAddress,\n"+
            "it.finish_address finishAddress,\n"+
            "it.transaction_state transactionState,\n"+
            "iu.name initiatorWorkerName FROM t_index_items it\n"+
            "left join sys_user iu\n"+
            "on it.initiator_worker = iu.id\n"+
            "left join sys_dept fdept\n"+
            "on it.initiator_dept = fdept.id\n"+
            "where ( accept_worker = #{acceptWork}\n"+
            "or (accept_worker is null and accept_dept = #{userDept})\n"+
            "or (accept_worker is null and accept_dept is null) )\n"+
            "<when test='transactionState!=null and transactionState!=\"\"'>",
            "AND it.transaction_state = #{transactionState}",
            "</when>",
            "<when test='workType!=null and workType!=\"\"'>",
            "AND it.work_type like '%${workType}%'",
            "</when>",
            "<when test='urgencyLevel!=null and urgencyLevel!=\"\"'>",
            "AND it.urgency_level = #{urgencyLevel}",
            "</when>",
            "<when test='itemName!=null and itemName!=\"\"'>",
            "AND it.item_name like '%${itemName}%'",
            "</when>",
            "<when test='initiatorDeptName!=null and initiatorDeptName!=\"\"'>",
            "AND fdept.name like '%${initiatorDeptName}%'",
            "</when>",
            "<when test='initiatorWorker!=null and initiatorWorker!=\"\"'>",
            "AND iu.name like '%${initiatorWorker}%'",
            "</when>",
            "<when test='startTimeStart!=null and startTimeStart!=\"\"'>",
            "AND it.start_time &gt;= #{startTimeStart}",
            "</when>",
            "<when test='startTimeEnd!=null and startTimeEnd!=\"\"'>",
            "AND it.start_time &lt;= #{startTimeEnd}",
            "</when>",
            "<when test='updateStart!=null and updateStart!=\"\"'>",
            "AND it.end_time &gt;= #{updateStart}",
            "</when>",
            "<when test='updateEnd!=null and updateEnd!=\"\"'>",
            "AND it.end_time &lt;= #{updateEnd}",
            "</when>",
            "order by it.start_time desc",
            "</script>"
    })
    List<Map> listPg(Map params);

    /**
     * 添加一个事项
     * @param item
     * @return
     */
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addItems(Items item);
}
