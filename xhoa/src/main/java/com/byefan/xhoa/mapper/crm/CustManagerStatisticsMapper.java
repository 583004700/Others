package com.byefan.xhoa.mapper.crm;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustManagerStatisticsMapper {
    //统计前五项的值
    Map topStatistics(Map map);

    //统计各部门的男女人数
    List<Map> everyDeptUserCount(@Param("list") List<String> list);

    //统计
    Map custPie(Map map);
}
