package com.byefan.xhoa.service.crm;

import com.byefan.xhoa.entity.crm.DockingPeople;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IDockingPeopleService {

    String CACHE_KEY = "dockingPeople";

    /**
     * 查看和编辑
     *
     * @param people
     * @return
     */
    DockingPeople selectOne(DockingPeople people);

    DockingPeople getById(Integer id);

    boolean update(DockingPeople people);

    void savePhoto(DockingPeople dockingPeople, MultipartFile file) throws Exception;

    PageInfo<DockingPeople> listDockingPeople(Map map, Pageable pageable);

    List<DockingPeople> listDockingPeople(Map map);

    List<DockingPeople> listByWorker(Integer worker);

    List<DockingPeople> listByCustId(Integer custId);

}
