package com.byefan.xhoa.mapper.crm;

import com.byefan.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CustDockingPeopleMapper extends BaseMapper<Map,Integer>{
    List<Map> getCustdockingPeopleSearch(Map params);

    /**
     * 开票选择客户
     * @param params
     * @return
     */
    @Select({"<script>",
            "select peo.id id,cust.id custCompanyId,cust.company_name custCompanyName,peo.id custId,\n"+
                    "peo.cust_name custName,peo.job job,peo.`status`,peo.worker worker,\n"+
                    "peo.create_worker createWorker,\n"+
                    "cu.name createWorkerName,\n"+
                    "peo.worker worker,\n"+
                    "wu.name workerName,\n"+
                    "peo.create_time createTime,peo.update_time updateTime,\n"+
                    "peo.delete_flag deleteFlag\n",
                    "from t_crm_cust cust left join t_crm_docking_people peo\n"+
                    "on cust.id = peo.company_id\n"+
                    "left join sys_user cu on peo.create_worker = cu.id\n"+
                    "left join sys_user wu on peo.worker = wu.id\n"+
                    " where 1=1\n",
            "<when test='companyName!=null and companyName!=\"\"'>",
            "AND cust.company_name like '%${companyName}%'",
            "</when>",
            "<when test='custCompanyNameQc1!=null and custCompanyNameQc1!=\"\"'>",
            "AND cust.company_name like '%${custCompanyNameQc1}%'",
            "</when>",
            "<when test='custNameQc1!=null and custNameQc1!=\"\"'>",
            "AND peo.cust_name like '%${custNameQc1}%'",
            "</when>",
            "<when test='custName!=null and custName!=\"\"'>",
            "AND peo.cust_name like '%${custName}%'",
            "</when>",
            "<when test='createWorker!=null and createWorker!=\"\"'>",
            "AND cu.user_name like '%${createWorker}%'",
            "</when>",
            "<when test='worker!=null and worker!=\"\"'>",
            "AND wu.user_name like '%${worker}%'",
            "AND wu.user_name is not null and wu.user_name != ''",
            "</when>",
            "order by cust.id desc",
            "</script>"})
    List<Map> getCustdockingPeople(Map params);

}
