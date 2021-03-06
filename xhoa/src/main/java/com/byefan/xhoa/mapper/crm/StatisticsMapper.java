package com.byefan.xhoa.mapper.crm;

import java.util.List;
import java.util.Map;

public interface StatisticsMapper {
    /**
     * 客户统计结果
     * @param map
     * @return
     */
    List<Map<String,Object>> statisticsResult(Map map);

    /**
     * 客户排名统计
     * @param map
     * @return
     */
    List<Map<String,Object>> statisticsRanking(Map map);

    /**
     * 根据权限或角色查询当前部门或者当前用户
     * @param map
     * @return
     */
    List<Map> deptUsers(Map map);
}
