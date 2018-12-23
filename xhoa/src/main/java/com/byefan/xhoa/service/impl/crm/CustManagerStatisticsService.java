package com.byefan.xhoa.service.impl.crm;

import com.byefan.xhoa.mapper.crm.CustManagerStatisticsMapper;
import com.byefan.xhoa.mapper.crm.StatisticsMapper;
import com.byefan.xhoa.service.crm.ICustManagerStatisticsService;
import com.byefan.xhoa.service.crm.IStatisticsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustManagerStatisticsService implements ICustManagerStatisticsService{

    public static final String cacheKey = "custManagerStatistics";

    @Autowired
    CustManagerStatisticsMapper custManagerStatisticsMapper;

    @Cacheable(value = cacheKey)
    public Map topStatistics(Map map){
        return custManagerStatisticsMapper.topStatistics(map);
    }

    /**
     * 统计各部门的男女人数
     * @param list
     * @return
     */
    @Cacheable(value = cacheKey)
    public List<Map> everyDeptUserCount(List<String> list){
        return custManagerStatisticsMapper.everyDeptUserCount(list);
    }

    //统计各种类型的客户
    @Cacheable(value = cacheKey)
    public Map custPie(Map map){
        return custManagerStatisticsMapper.custPie(map);
    }
}
