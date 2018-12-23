package com.byefan.xhoa.mapper.mediauser;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MediaUserManagerStatisticsMapper {
    //统计稿件数量，应付金额，已付金额，请款金额
    List<Map> topOptionSetValue(Map map);
    //统计供应商排名
    List<Map> supplierSort(Map map);
    //请款排名
    List<Map> outgoSort(Map map);
    //稿件类型分布
    List<Map> artTypeFb(Map map);
    //供应商列表排名
    List<Map> supplierListSort(Map map);
}


