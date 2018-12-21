package com.byefan.xhoa.service.sys;

import com.byefan.xhoa.entity.sys.Resource;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IResourceService {
//    PageInfo<Resource> listAll(int pageNum, int pageSize);

    PageInfo<Resource> search(Pageable pageable, Resource resource);

//    PageInfo<List<Map>> listAll2(int pageNum, int pageSize);

    PageInfo<Resource> listPg(int pageNum, int pageSize, Map map);

    //    @Override
//    public PageInfo<List<Map>> listAll2(int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum,pageSize) ;
//        List<Map> list = resourceMapper.listAll2() ;
//        PageInfo<List<Map>> pages = new PageInfo(list) ;
//        return pages;
//    }
//    PageInfo<Map> listAll2(Integer pageNum, Integer pageSize);

    Resource add(Resource Resource, Integer userId);

    Resource edit(Resource Resource, Integer userId);

    Resource delById(Integer id);

    Resource getById(Integer id);

    List<Resource> queryResourceByName(String name);

    @Cacheable(value = "resource", key = "'id='+#userId")
    List<Resource> listByParentId(Integer userId);

    List<Resource> queryResourceByUserId(Integer userId);

    @Cacheable(value = "resources", key = "'userId='+#userId")
    List<Resource> queryAllResourceByUserId(Integer userId);

    @Cacheable(value = "listAllMenus")
    List<Resource> listAllMenus();

    //    @Cacheable(value = "groupResource")
    List<Map> allParentsAndResources(Integer roleId);

    @Cacheable(value = "groupResource")
    List<Map> getUserResources(Integer roleId);

//    Set<Resource> findUserMenus(Intege);

}
