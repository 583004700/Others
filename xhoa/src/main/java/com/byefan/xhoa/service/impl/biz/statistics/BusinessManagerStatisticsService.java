package com.byefan.xhoa.service.impl.biz.statistics;

import com.byefan.xhoa.mapper.biz.statistics.BusinessManagerStatisticsMapper;
import com.byefan.xhoa.service.biz.statistics.IBusinessManagerStatisticsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BusinessManagerStatisticsService implements IBusinessManagerStatisticsService{

    public static final String cacheKey = "businessManagerStatistics";

    @Autowired
    BusinessManagerStatisticsMapper businessManagerStatisticsMapper;

    @Cacheable(value = cacheKey)
    public List<Map> topOptionSetValue(Map map){
        return businessManagerStatisticsMapper.topOptionSetValue(map);
    }

    //订单排名
    public List<Map> orderSort(Map map,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return businessManagerStatisticsMapper.orderSort(map);
    }

    //稿件排名
    public List<Map> articleSort(Map map,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return businessManagerStatisticsMapper.articleSort(map);
    }

    /**
     * 统计各个部门的业务
     * @param list
     * @return
     */
    @Cacheable(value = cacheKey)
    public List<Map> everyDeptBusiness(List<String> list,String dateSelect){
        return businessManagerStatisticsMapper.everyDeptBusiness(list,dateSelect);
    }

    /**
     * 统计本部门业务排名
     * @param map
     * @return
     */
    @Cacheable(value = cacheKey)
    public List<Map> businessTop(Map map){
        return businessManagerStatisticsMapper.businessTop(map);
    }
}
