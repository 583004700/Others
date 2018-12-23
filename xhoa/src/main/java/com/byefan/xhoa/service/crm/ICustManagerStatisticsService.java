package com.byefan.xhoa.service.crm;

import java.util.List;
import java.util.Map;

public interface ICustManagerStatisticsService {
    Map topStatistics(Map map);

    List<Map> everyDeptUserCount(List<String> list);

    Map custPie(Map map);
}
