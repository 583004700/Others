package com.byefan.xhoa.mapper.biz.statistics;

import java.util.List;
import java.util.Map;

public interface BusinessStatisticsMapper {
    /**
     * 业务统计结果
     * @param map
     * @return
     */
    List<Map<String,Object>> statisticsResult(Map map);

    /**
     * 最近三个月未成交的客户
     * @param map
     * @return
     */
    List<Map<String,Object>> statisticsRanking(Map map);
}
