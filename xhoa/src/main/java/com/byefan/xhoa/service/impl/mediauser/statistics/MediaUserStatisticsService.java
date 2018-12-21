package com.byefan.xhoa.service.impl.mediauser.statistics;

import com.byefan.xhoa.mapper.mediauser.MediaUserStatisticsMapper;
import com.byefan.xhoa.service.mediauser.statistics.IMediaUserStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MediaUserStatisticsService implements IMediaUserStatisticsService {

    public static final String cacheKey = "mediaUserStatistics";

    @Autowired
    MediaUserStatisticsMapper mediaUserStatisticsMapper;

    @Cacheable(value=cacheKey)
    public List<Map> mediaUserResult(Map map){
        return mediaUserStatisticsMapper.mediaUserResult(map);
    }

    @Cacheable(value=cacheKey)
    public List<Map> supplierResult(Map map){
        return mediaUserStatisticsMapper.supplierResult(map);
    }
}
