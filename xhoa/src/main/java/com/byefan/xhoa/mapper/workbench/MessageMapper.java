package com.byefan.xhoa.mapper.workbench;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.workbench.Message;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MessageMapper extends BaseMapper<Message,Integer>{
    @Select({"<script>",
            "SELECT mes.id id,mes.pic pic,\n"+
            "mes.content content,\n"+
            "mes.create_time createTime,\n"+
            "case when mr.message_id is null then 1 else 2 end state,\n"+
            "iu.image image,\n",
            "iu.user_name initiatorWorkerName FROM t_index_message mes\n"+
            "left join t_index_message_read mr\n"+
            "on mr.user_id = #{userId} and mr.message_id = mes.id\n"+
            "left join sys_user iu\n"+
            "on mes.initiator_worker = iu.id\n"+
            "left join sys_dept fdept\n"+
            "on mes.initiator_dept = fdept.id\n"+
            "where ( mes.accept_worker = #{acceptWork}\n"+
            "or (mes.accept_worker is null and mes.accept_dept = #{userDept})\n"+
            "or (mes.accept_worker is null and mes.accept_dept is null) )\n"+
            "<when test='state!=null and state!=\"\"'>",
            "AND mes.state = #{state}",
            "</when>",
            "order by mes.id desc",
            "</script>"
    })
    List<Map> listMsg(Map params);
}
