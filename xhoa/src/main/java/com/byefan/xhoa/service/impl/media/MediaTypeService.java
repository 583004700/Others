package com.byefan.xhoa.service.impl.media;

import com.byefan.xhoa.entity.media.MediaType;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.media.MediaTypeMapper;
import com.byefan.xhoa.service.media.IMediaTypeService;
import com.byefan.xhoa.service.sys.IRoleService;
import com.byefan.xhoa.utils.IConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MediaTypeService implements IMediaTypeService {

    @Autowired
    MediaTypeMapper mediaTypeMapper;
    @Autowired
    IRoleService roleService;

    @Override
    @Cacheable(value = CACHE_KEY_LIST)
    public List<MediaType> list(MediaType mediaType) {
        List<MediaType> list = mediaTypeMapper.list(mediaType);
        return list;
    }

    /**
     * 根据父级媒体ID类型查询媒体类型列表parentId=0表示查询板块列表
     *
     * @param parentId
     * @return
     */
    @Override
    public List<MediaType> listByParentId(Integer parentId, User user) {
        if (parentId > 0)//
            return mediaTypeMapper.getByParentId(parentId);
        List<MediaType> list = null;
        if (user != null) {
            list = this.listByUserId(user.getId());
        } else {
            list = mediaTypeMapper.getByParentId(parentId);
        }
        return list;
    }

    @Override
    public List<MediaType> listByParentId(Integer parentId) {
        return mediaTypeMapper.getByParentId(parentId);
    }

    public List<MediaType> listByParentId(Integer parentId, User user, String isFlag) {
        if (parentId > 0)//
            return mediaTypeMapper.getByParentId(parentId);
        boolean flag = false;
        if (isFlag != null)
            flag = roleService.isRole(user.getId(), IConst.ROLE_TYPE_MJ);
        List<MediaType> list = null;
        if (flag) {
            list = this.listByUserId(user.getId());
        } else {
            list = mediaTypeMapper.getByParentId(parentId);
        }
        return list;
    }

    @Override
    public MediaType getById(Integer id) {
        return mediaTypeMapper.getById(id);
    }

    @Override
    public MediaType getByMediaId(Integer mediaId) {
        return mediaTypeMapper.getByMediaId(mediaId);
    }

    /**
     * 根据用户Id查询媒体类型
     *
     * @param userId 媒介ID
     * @return
     */
    @Override
//    @Cacheable(value = CACHE_KEY, key = "'userId'+#userId")
    public List<MediaType> listByUserId(Integer userId) {
        return mediaTypeMapper.listByUserId(userId);
    }
}
