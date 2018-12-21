package com.byefan.xhoa.service.impl.biz.statistics;

import com.byefan.xhoa.mapper.biz.statistics.BusinessStatisticsMapper;
import com.byefan.xhoa.mapper.crm.StatisticsMapper;
import com.byefan.xhoa.service.biz.statistics.IBusinessStatisticsService;
import com.byefan.xhoa.service.crm.IStatisticsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BusinessStatisticsService implements IBusinessStatisticsService {
    public static final String cacheKey = "businessStatistics";

    @Autowired
    BusinessStatisticsMapper businessStatisticsMapper;

    @Cacheable(value=cacheKey)
    public List<Map<String,Object>> statisticsResult(Map map){
        return businessStatisticsMapper.statisticsResult(map);
    }

    public PageInfo<Map<String,Object>> statisticsRanking(Map map,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(businessStatisticsMapper.statisticsRanking(map));
        return pageInfo;
    }
}
