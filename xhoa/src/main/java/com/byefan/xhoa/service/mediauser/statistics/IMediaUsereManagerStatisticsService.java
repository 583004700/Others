package com.byefan.xhoa.service.mediauser.statistics;

import java.util.List;
import java.util.Map;

public interface IMediaUsereManagerStatisticsService {
    List<Map> topOptionSetValue(Map map);
    //供应商排名
    List<Map> supplierSort(Map map,Integer pageNumber,Integer pageSize);
    //请款排名
    List<Map> outgoSort(Map map,Integer pageNumber,Integer pageSize);
    //稿件类型分布
    List<Map> artTypeFb(Map map);
    //稿件供应商排名
    List<Map> supplierListSort(Map map,Integer pageNumber,Integer pageSize);
}

