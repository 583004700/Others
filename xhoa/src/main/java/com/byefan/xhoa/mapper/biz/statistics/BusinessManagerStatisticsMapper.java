package com.byefan.xhoa.mapper.biz.statistics;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BusinessManagerStatisticsMapper {
    //设置稿件数量，应收金额...
    List<Map> topOptionSetValue(Map map);

    //查询订单排名
    List<Map> orderSort(Map map);

    //查询稿件排名
    List<Map> articleSort(Map map);

    //统计各个部门的业务情况
    List<Map> everyDeptBusiness(@Param("list") List<String> list, @Param("dateSelect") String dateSelect);

    //统计业务前排名
    List<Map> businessTop(Map map);
}


