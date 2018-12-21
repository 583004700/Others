package com.byefan.xhoa.service.crm;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IStatisticsService {
    /**
     * 客户统计结果
     * @param map
     * @return
     */
    List<Map<String,Object>> statisticsResult(Map map);

    /**
     * 统计客户排名
     * @param map
     * @return
     */
    public PageInfo<Map<String,Object>> statisticsRanking(Map map, Integer pageNum,Integer pageSize);

    /**
     * 查询部门的用户
     * @param map
     * @return
     */
    List<Map> deptUsers(Map map);
}
