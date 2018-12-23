package com.byefan.xhoa.service.impl.crm;

import com.byefan.core.config.Config;
import com.byefan.core.utils.UUIDUtil;
import com.byefan.xhoa.entity.crm.DockingPeople;
import com.byefan.xhoa.mapper.crm.DockingPeopleMapper;
import com.byefan.xhoa.service.crm.IDockingPeopleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class DockingPeopleService implements IDockingPeopleService {
    @Autowired
    Config config;
    @Autowired
    DockingPeopleMapper dockingPeopleMapper;

    /**
     * 查询单个
     *
     * @param people
     * @return
     */
    public DockingPeople selectOne(DockingPeople people) {
        return dockingPeopleMapper.get(DockingPeople.class, people.getId());
    }

    @Cacheable(value = CACHE_KEY, key = "'id='+#id")
    @Override
    public DockingPeople getById(Integer id) {
        return dockingPeopleMapper.get(DockingPeople.class, id);
    }

    /**
     * 更新对接人信息
     *
     * @param people
     * @return
     */
    public boolean update(DockingPeople people) {
        if (people.getId() == null || people.getId() == 0) {
            return false;
        }
        dockingPeopleMapper.update(people);
        return true;
    }

    /**
     * 保存对接人照片
     *
     * @param dockingPeople
     * @param file
     * @throws Exception
     */
    public void savePhoto(DockingPeople dockingPeople, MultipartFile file) throws Exception {
        if (file != null && StringUtils.isNotBlank(file.getOriginalFilename())) {
            String childPath = "/crm/images/";
            File photoDir = new File(config.getUploadDir(), childPath);
            if (!photoDir.exists()) {
                photoDir.mkdirs();
            }
            String filename = UUIDUtil.get32UUID() + file.getOriginalFilename();
            File fullPath = new File(photoDir, filename);
            dockingPeople.setPhoto(new File(config.getWebDir(), childPath).toString() + File.separator + filename);
            file.transferTo(fullPath);
        }
    }

    public PageInfo<DockingPeople> listDockingPeople(Map map, Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageNumber());
        List<DockingPeople> list = dockingPeopleMapper.listDockingPeople(map);
        PageInfo<DockingPeople> pageInfo = new PageInfo<DockingPeople>(list);
        return pageInfo;
    }

    @Cacheable(value = CACHE_KEY, key = "'custId='+#custId")
    @Override
    public List<DockingPeople> listByCustId(Integer custId) {
        return dockingPeopleMapper.listByCustId(custId);
    }

    @Override
    public List<DockingPeople> listByWorker(Integer worker) {
        return dockingPeopleMapper.listByWorker(worker);
    }

    @Override
    public List<DockingPeople> listDockingPeople(Map map) {
        return dockingPeopleMapper.listDockingPeople(map);
    }
}
