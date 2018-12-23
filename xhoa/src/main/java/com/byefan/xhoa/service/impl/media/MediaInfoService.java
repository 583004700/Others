package com.byefan.xhoa.service.impl.media;

import com.byefan.core.exception.ByeFanException;
import com.byefan.core.serivce.impl.WorkFlowService;
import com.byefan.core.utils.StrUtil;
import com.byefan.xhoa.entity.media.MediaInfo;
import com.byefan.xhoa.entity.media.MediaTerm;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.media.MediaInfoMapper;
import com.byefan.xhoa.service.impl.sys.UserService;
import com.byefan.xhoa.service.media.IMediaInfoService;
import com.byefan.xhoa.service.media.IMediaTermService;
import com.byefan.xhoa.service.media.ISupplierService;
import com.byefan.xhoa.utils.AppUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 媒体服务类
 *
 * @author GZW
 */
@Slf4j
@Service
public class MediaInfoService implements IMediaInfoService {

    @Autowired
    MediaInfoMapper mediaInfoMapper;
    @Autowired
    IMediaTermService mediaTermService;
    @Autowired
    UserService userService;
    @Autowired
    ISupplierService supplierService;

    @Autowired
    CacheManager cacheManager;
    /***
     * 工作流服务
     */
    @Autowired
    WorkFlowService workFlowService;


    /**
     * 查询媒体列表
     *
     * @param mediaInfo 媒体查询条件
     * @param pageable  分页对象
     * @return
     */
    @Override
    @Transactional(readOnly = true)
//    @Cacheable(value = CACHE_KEY, key = "#mediaInfo.id")
    public PageInfo<MediaInfo> list(MediaInfo mediaInfo, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        mediaInfo.setState(1);
        List<MediaInfo> list = mediaInfoMapper.medias(mediaInfo, "id desc");
        Integer mType = mediaInfo.getmType();
        List<MediaTerm> mts = mediaTermService.list(mType);
        if (list != null && !list.isEmpty() && mts != null && !mts.isEmpty()) {
            Class<? extends MediaInfo> cls = mediaInfo.getClass();
            for (MediaInfo m : list) {
                fillMedia(mts, cls, m);
            }
        }
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 填充Media
     *
     * @param mts
     * @param cls
     * @param m
     */
    private void fillMedia(List<MediaTerm> mts, Class<? extends MediaInfo> cls, MediaInfo m) {
        Integer supplierId = m.getSupplierId();
        if (supplierId != null && supplierId != 0)
            m.setSupplier(supplierService.getById(supplierId));
        Cache cache = cacheManager.getCache(CACHE_KEY);
        User user = userService.getById(m.getCreatorId());
        m.setCreator(user);
        m.setUser(userService.getById(m.getUserId()));
        for (MediaTerm mt : mts) {
            String fieldName = mt.getField();
            if (!StringUtils.isEmpty(fieldName)) {
                String fieldName1 = StrUtil.camelCaseName(fieldName);
                try {
                    Field field = cls.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object val = field.get(m);
                    if (field != null && val != null) {
                        String sql = mt.getSql();
                        HashMap<String, Object> map = new HashMap<>();
                        map.put(fieldName, val);
                        if (!StringUtils.isEmpty(sql)) {
                            String sql1 = StrUtil.parse(sql, map);
                            List<Map<String, Object>> datas = (List<Map<String, Object>>) cache.get(sql1, new Callable<Object>() {
                                @Override
                                public Object call() throws Exception {
                                    List<Map<String, Object>> datas = mediaInfoMapper.dictSQL(sql1);
                                    return datas;
                                }
                            });
                            try {
                                if (datas != null && !datas.isEmpty()) {//如果有值则放到对应的字段中
                                    Field dataField = cls.getDeclaredField(fieldName1 + "Data");
                                    dataField.setAccessible(true);
                                    dataField.set(m, datas.get(0));
                                }
                            } catch (Exception e) {
                                log.error("没有这个类型" + e.getMessage());
                            }
                        }
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    @Transactional
    @CachePut(value = CACHE_KEY)
    public void save(MediaInfo mediaInfo) {
        mediaInfoMapper.insert(mediaInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("taskUser", "1001");
        map.put("url", "1001");
        map.put("type", "1001");
        map.put("title", "1001");
        map.put("createDate", new Date());
        map.put("creator", AppUtil.getUser().getName());
        map.put("creatorId", AppUtil.getUser().getId());
    }

    @Override
    @Transactional
    @CacheEvict(value = CACHE_KEY, key = "'id='+#mediaId")
    public void selectToSave(Integer mediaId) {
        mediaInfoMapper.selectToSave(mediaId);
//        return mediaInfoMapper.get(MediaInfo.class, mediaId);
    }

    @Override
    @Transactional
    @CacheEvict(value = CACHE_KEY, key = "'id='+#mediaId")
    public void selectToUpdate(Integer mediaId) {
        mediaInfoMapper.selectToUpdate(mediaId);
    }

    @Override
    @Transactional
    @CachePut(value = CACHE_KEY, key = "'id='+#mediaInfo.id")
    public MediaInfo update(MediaInfo mediaInfo) {
        mediaInfoMapper.update(mediaInfo);
        return mediaInfo;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = CACHE_KEY, key = "'id='+#mType+',mediaName'+#mediaName")
    public boolean getByName(int mType, String mediaName) {
        return mediaInfoMapper.getIdByName(mType, mediaName) > 0;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = CACHE_KEY, key = "'id='+#id")
    public MediaInfo getById(Integer id) {
        MediaInfo mediaInfo = mediaInfoMapper.get(MediaInfo.class, id);
        if (mediaInfo == null)
            return null;
        mediaInfo.setSupplier(supplierService.getById(mediaInfo.getSupplierId()));
        List<MediaTerm> mts = mediaTermService.list(mediaInfo.getmType());
        this.fillMedia(mts, MediaInfo.class, mediaInfo);
        return mediaInfo;
    }

    /**
     * 审核通过
     *
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = CACHE_KEY, key = "'id='+#id")
    @Transactional
    public boolean pass(Integer id) {
        try {
            mediaInfoMapper.modifyStateById(2, id);
            return true;
        } catch (ByeFanException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 审核驳回
     *
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = CACHE_KEY, key = "'id='+#id")
    @Transactional
    public boolean reject(Integer id) {
        try {
            mediaInfoMapper.modifyStateById(3, id);
            return true;
        } catch (ByeFanException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 审核删除
     *
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = CACHE_KEY, key = "'id='+#id")
    @Transactional
    public boolean del(Integer id) {
        try {
            mediaInfoMapper.modifyStateById(-1, id);
            return true;
        } catch (ByeFanException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Transactional
    public void modifyStateById(int i, Integer id) {
        mediaInfoMapper.modifyStateById(i, id);
    }
}
