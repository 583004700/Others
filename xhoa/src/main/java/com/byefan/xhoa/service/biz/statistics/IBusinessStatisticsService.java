package com.byefan.xhoa.service.biz.statistics;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IBusinessStatisticsService {
    /**
     * 业务统计结果
     * @param map
     * @return
     */
    List<Map<String,Object>> statisticsResult(Map map);

    /**
     * 最近三个月未成交客户
     * @param map
     * @return
     */
    public PageInfo<Map<String,Object>> statisticsRanking(Map map, Integer pageNum, Integer pageSize);
}
