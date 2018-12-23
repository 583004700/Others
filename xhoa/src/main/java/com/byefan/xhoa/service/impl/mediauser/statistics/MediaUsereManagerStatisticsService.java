package com.byefan.xhoa.service.impl.mediauser.statistics;

import com.byefan.xhoa.mapper.mediauser.MediaUserManagerStatisticsMapper;
import com.byefan.xhoa.service.mediauser.statistics.IMediaUsereManagerStatisticsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MediaUsereManagerStatisticsService implements IMediaUsereManagerStatisticsService{

    public static final String cacheKey = "mediaUsereManagerStatistics";

    @Autowired
    MediaUserManagerStatisticsMapper mediaUserManagerStatisticsMapper;

    @Cacheable(value = cacheKey)
    public List<Map> topOptionSetValue(Map map){
        return mediaUserManagerStatisticsMapper.topOptionSetValue(map);
    }

    /**
     * 供应商排名
     * @param map
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<Map> supplierSort(Map map,Integer pageNumber,Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        return mediaUserManagerStatisticsMapper.supplierSort(map);
    }

    /**
     * 请款排名
     * @param map
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<Map> outgoSort(Map map,Integer pageNumber,Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        return mediaUserManagerStatisticsMapper.outgoSort(map);
    }

    /**
     * 稿件类型分布
     * @param map
     * @return
     */
    @Cacheable(value = cacheKey)
    public List<Map> artTypeFb(Map map){
        return mediaUserManagerStatisticsMapper.artTypeFb(map);
    }

    /**
     * 供应商排名统计
     * @param map
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public List<Map> supplierListSort(Map map,Integer pageNumber,Integer pageSize){
        PageHelper.startPage(pageNumber,pageSize);
        return mediaUserManagerStatisticsMapper.supplierListSort(map);
    }

}
