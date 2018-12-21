package com.byefan.xhoa.service.biz.statistics;

import java.util.List;
import java.util.Map;

public interface IBusinessManagerStatisticsService {
    List<Map> topOptionSetValue(Map map);

    List<Map> orderSort(Map map,Integer pageNum,Integer pageSize);

    List<Map> articleSort(Map map,Integer pageNum,Integer pageSize);

    List<Map> everyDeptBusiness(List<String> list,String dateSelect);

    List<Map> businessTop(Map map);
}
