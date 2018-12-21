package com.byefan.xhoa.service.impl.media;

import com.byefan.core.config.websocket.WebSocketServer;
import com.byefan.core.entity.WSMessage;
import com.byefan.core.exception.ByeFanException;
import com.byefan.core.serivce.impl.WorkFlowService;
import com.byefan.core.utils.StrUtil;
import com.byefan.xhoa.entity.media.Media;
import com.byefan.xhoa.entity.media.MediaTerm;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.media.MediaMapper;
import com.byefan.xhoa.service.impl.sys.UserService;
import com.byefan.xhoa.service.media.IMediaInfoService;
import com.byefan.xhoa.service.media.IMediaService;
import com.byefan.xhoa.service.media.IMediaTermService;
import com.byefan.xhoa.service.media.ISupplierService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
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

import com.byefan.core.annotation.Table;
import java.lang.reflect.Field;
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
public class MediaService implements IMediaService {

    @Autowired
    MediaMapper mediaMapper;
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
    @Autowired
    IMediaInfoService mediaInfoService;


    /**
     * 查询媒体列表
     *
     * @param media    媒体查询条件
     * @param pageable 分页对象
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public PageInfo<Media> list(Media media, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        String sql = new SQL() {
            {
                SELECT("*");
                FROM(Media.class.getAnnotation(Table.class).name());
                if (media.getId() != null) {
                    WHERE("id=#{media.id}");
                }
                if (!StringUtils.isEmpty(media.getUserId())) {
                    WHERE("user_id=#{media.userId}");
                }
                if (!StringUtils.isEmpty(media.getName())) {
                    WHERE("name=#{media.name}");
                }
                if (!StringUtils.isEmpty(media.getSupplierId())) {
                    WHERE("supplier_id=#{media.supplierId}");
                }
                if (!StringUtils.isEmpty(media.getPicPath())) {
                    WHERE("pic_path=#{media.picPath}");
                }
                if (!StringUtils.isEmpty(media.getCommStart())) {
                    WHERE("comm_start=#{media.getCommStart}");
                }
                if (!StringUtils.isEmpty(media.getN1())) {
                    WHERE("n1=#{media.n1}");
                }
                if (!StringUtils.isEmpty(media.getN2())) {
                    WHERE("n2=#{media.n2}");
                }
                if (!StringUtils.isEmpty(media.getN3())) {
                    WHERE("n3=#{media.n3}");
                }
                if (!StringUtils.isEmpty(media.getN4())) {
                    WHERE("n4=#{media.n4}");
                }
                if (!StringUtils.isEmpty(media.getN5())) {
                    WHERE("n5=#{media.n5}");
                }
                if (!StringUtils.isEmpty(media.getN6())) {
                    WHERE("n6=#{media.n6}");
                }
                if (!StringUtils.isEmpty(media.getN7())) {
                    WHERE("n7=#{media.n7}");
                }
                if (!StringUtils.isEmpty(media.getN8())) {
                    WHERE("n8=#{media.n8}");
                }
                if (!StringUtils.isEmpty(media.getState())) {
                    if (AppUtil.isRoleType(IConst.ROLE_TYPE_MJ) && AppUtil.isRoleCode(IConst.ROLE_CODE_BZ))//如果是业务部长 可以查询审核中的状态
                        WHERE("(state>#{media.state} or state=0)");
                    else
                        WHERE("(state=0)");
                }
                if (!StringUtils.isEmpty(media.getmType())) {
                    WHERE("m_type=#{media.mType}");
                }
            }
        }.toString();
        List<Media> list = mediaMapper.dictSQLByObject(sql, media);
        Integer mType = media.getmType();
        List<MediaTerm> mts = mediaTermService.list(mType);
        if (list != null && !list.isEmpty() && mts != null && !mts.isEmpty()) {
            Class<? extends Media> cls = media.getClass();
            for (Media m : list) {
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
    private void fillMedia(List<MediaTerm> mts, Class<? extends Media> cls, Media m) {
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
                                    List<Map<String, Object>> datas = mediaMapper.dictSQL(sql1);
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
    public void save(Media media) {
        Integer id = mediaMapper.insert(media);
        System.out.println(id);
        System.out.println(media);
//        Map<String, Object> map = new HashMap<>();
//        map.put("taskUser", "1001");
//        map.put("url", "1001");
//        map.put("type", "1001");
//        map.put("title", "1001");
//        map.put("createDate", new Date());
//        map.put("creator", AppUtil.getUser().getName());
//        map.put("creatorId", AppUtil.getUser().getId());
//        workFlowService.addExpense("test", map);
    }

    @Override
    @Transactional
    @CachePut(value = CACHE_KEY, key = "'id='+#media.id")
    public Media update(Media media) {
        media.setState(0);
        mediaMapper.update(media);
        mediaInfoService.modifyStateById(0, media.getId());
        return media;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean getByName(int mType, String mediaName) {
        return mediaMapper.getIdByName(mType, mediaName) > 0?true:false;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = CACHE_KEY, key = "'id='+#id")
    public Media getById(Integer id) {
        Media media = mediaMapper.get(Media.class, id);
        media.setSupplier(supplierService.getById(media.getSupplierId()));
        List<MediaTerm> mts = mediaTermService.list(media.getmType());
        this.fillMedia(mts, Media.class, media);
        return media;
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

            Media media = this.getById(id);
            int state = media.getState();
            //判断是否是业务部长 如果是业务部长则将state改为1 业务组长就改为2
            state = (AppUtil.isRoleType(IConst.ROLE_TYPE_MJ) && AppUtil.isRoleCode(IConst.ROLE_CODE_BZ)) ? 1 : (state == 0 ? 2 : state + 1);
            mediaMapper.modifyStateById(state, id);
            //state=1表示已经审核通过 状态，0未审核 1审核通过，大于1表示审核中，-1是审核不通过
            if (state == 1) {//查看媒体信息表中是否存在数据,如果存在就更新不存在则插入
//                MediaInfo mediaInfo = new MediaInfo();
//                BeanUtils.copyProperties(media, mediaInfo);
                if (mediaInfoService.getById(id) == null) {
                    mediaInfoService.selectToSave(id);
                } else {
//                    mediaInfoService.update(mediaInfo);
                    mediaInfoService.selectToUpdate(id);
                }
            }
            if (state == 1) {
                WSMessage message = new WSMessage();
                message.setReceiveUserId(media.getCreatorId() + "");
                message.setReceiveName(media.getCreator().getName());
                message.setSendName(AppUtil.getUser().getName());
                message.setSendUserId(AppUtil.getUser().getId() + "");
                message.setSendUserImage(AppUtil.getUser().getImage());
                message.setContent("恭喜你！你录入的媒体信息已经审核通过！");
                message.setSubject("媒体信息审核通过！");
                WebSocketServer.sendMessage(message);
            }
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
            mediaMapper.modifyStateById(-1, id);
            //审核驳回 将mediaInfo表中数据改成1的状态
            mediaInfoService.modifyStateById(1, id);
            Media media = this.getById(id);
            WSMessage message = new WSMessage();
            message.setReceiveUserId(media.getCreatorId() + "");
            message.setReceiveName(media.getCreator().getName());
            message.setSendName(AppUtil.getUser().getName());
            message.setSendUserId(AppUtil.getUser().getId() + "");
            message.setSendUserImage(AppUtil.getUser().getImage());
            message.setContent("很遗憾！你录入的媒体信息已经驳回！，请修改后再提交");
            message.setSubject("媒体审核已被驳回！");
//            message.setUrl("http://");
            WebSocketServer.sendMessage(message);
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
    public boolean del(Integer id) {
        try {
            mediaMapper.modifyStateById(-999, id);
            return true;
        } catch (ByeFanException e) {
            e.printStackTrace();
            return false;
        }
    }
}
