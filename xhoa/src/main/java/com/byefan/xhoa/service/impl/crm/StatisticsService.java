package com.byefan.xhoa.service.impl.crm;

import com.byefan.xhoa.mapper.crm.StatisticsMapper;
import com.byefan.xhoa.service.crm.IStatisticsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户统计
 */
@Service
public class StatisticsService implements IStatisticsService{
    public final static String cacheKey = "statistics";
    @Autowired
    StatisticsMapper statisticsMapper;

    @Cacheable(value=cacheKey)
    public List<Map<String,Object>> statisticsResult(Map map){
        return statisticsMapper.statisticsResult(map);
    }

    public PageInfo<Map<String,Object>> statisticsRanking(Map map,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(statisticsMapper.statisticsRanking(map));
        return pageInfo;
    }

    @Cacheable(value=cacheKey)
    public List<Map> deptUsers(Map map){
        return statisticsMapper.deptUsers(map);
    }
}
