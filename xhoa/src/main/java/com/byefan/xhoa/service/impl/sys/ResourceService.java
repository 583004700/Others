package com.byefan.xhoa.service.impl.sys;

import com.byefan.xhoa.entity.sys.Resource;
import com.byefan.xhoa.mapper.sys.ResourceMapper;
import com.byefan.xhoa.mapper.sys.RoleMapper;
import com.byefan.xhoa.service.sys.IResourceService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class ResourceService implements IResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleMapper roleMapper;
//    @Override
//    public PageInfo<Resource> listAll(int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Resource> list = resourceMapper.listAll();
//        PageInfo<Resource> pages = new PageInfo<>(list);
//        return pages;
//    }

    @Override
//    @Cacheable(value = "resource", key = "'pageNum='+#pageNum")
    public PageInfo<Resource> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Resource> list = resourceMapper.listPg(map);
        PageInfo<Resource> pages = new PageInfo<>(list);
        return pages;
    }

    @Override
    @Cacheable(value = "resource", key = "'pageNum='+#pageable.getPageNumber()")
    public PageInfo<Resource> search(Pageable pageable, Resource resource) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        String name = resource.getName();
        if (StringUtils.isNotEmpty(name))
            resource.setName("%" + name + "%");
        List<Resource> list = resourceMapper.list(resource);
        PageInfo<Resource> pages = new PageInfo<>(list);
        return pages;
    }

//    /**
//     * 关联sys_group表中的权限组名称
//     *
//     * @param pageNum
//     * @param pageSize
//     * @return
//     */
//    @Override
//    public PageInfo<List<Map>> listAll2(int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum,pageSize) ;
//        List<Map> list = resourceMapper.listAll2() ;
//        PageInfo<List<Map>> pages = new PageInfo(list) ;
//        return pages;
//    }
//    @Override
//    public PageInfo<Map> listAll2(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Map> list = resourceMapper.listAll2();
//        PageInfo<Map> pageInfo = new PageInfo(list);
//        return pageInfo;
//    }

    /**
     * 添加权限
     *
     * @param resource
     * @return
     */
    @CachePut(value = "resource", key = "'id='+#resource.getId()")
    public Resource add(Resource resource, Integer userId) {
        //0代表有效，1无效
//      resource.setState(IConst.STATE_FINISH);
        resource.setCreateTime(new Date());
        resource.setCreator(userId);
        resourceMapper.insert2(resource);
        return resource;
    }

    /**
     * 编辑权限
     *
     * @param resource
     * @return
     */
    @CachePut(value = "resource", key = "'id='+#resource.getId()")
    @CacheEvict(value = "resource")
    public Resource edit(Resource resource, Integer userId) {
        resource.setUpdateTime(new Date());
        resource.setUpdateUserId(userId);
        resourceMapper.update(resource);
        return resource;
    }

    @Override
    @CacheEvict(value = "resource", key = "'id='+#id")
    public Resource delById(@RequestParam("id") Integer id) {
        Resource resource = resourceMapper.getById(id);
        resource.setState(IConst.STATE_DELETE);
        resource.setUpdateTime(new Date());
        resourceMapper.update(resource);
        return resource;
    }

    @Override
    @Cacheable(value = "resource", key = "'id='+#id")
    public Resource getById(Integer id) {
        Resource resource = resourceMapper.getById(id);
        return resource;
    }

    @Override
    @Cacheable(value = "resource", key = "'name='+#name")
    public List<Resource> queryResourceByName(String name) {
        List<Resource> list = resourceMapper.queryResourceByName(name);
        return list;
    }

    @Override
    @Cacheable(value = "resource", key = "'parentId='+#parentId")
    public List<Resource> listByParentId(Integer parentId) {
        return resourceMapper.listByParentId(parentId);
    }

    @Override
    @Cacheable(value = "resource", key = "'userId='+#userId")
    public List<Resource> queryResourceByUserId(Integer userId) {
        List<Resource> set = null;
        if (userId == -1) {
            set = resourceMapper.listAllMenus();
            for (Resource resource : set) {
                List<Resource> childs = listByParentId(resource.getId());
                resource.setChilds(childs);
            }
        } else {
            set = resourceMapper.queryParentResourceByUserId(userId);
            for (Resource resource : set) {
                List<Resource> childs = resourceMapper.queryResourceByParentId(userId, resource.getId());
                resource.setChilds(childs);
            }
        }

        return set;
    }

    @Override
    @Cacheable(value = "resources", key = "'userId='+#userId")
    public List<Resource> queryAllResourceByUserId(Integer userId) {
        return resourceMapper.queryAllResourceByUserId(userId) ;
    }

    @Override
    @Cacheable(value = "listAllMenus")
    public List<Resource> listAllMenus() {
        return resourceMapper.listAllMenus();
    }

    @Override
    @Cacheable(value = "groupResource")
    public List<Map> allParentsAndResources(Integer roleId) {
        //查询所有权限组
        List<Resource> parentList = resourceMapper.queryParentResource();
        List<Map> list = new ArrayList<Map>();
        for (Resource parent : parentList) {
            Map map = new HashMap<>();
            map.put("parentList", parent);
            List<Map> pmsInfoList = new ArrayList<>();
            //获取所在权限组的权限信息
            List<Resource> resourceList = resourceMapper.queryByParentId(parent.getId());
            int len1 = resourceList.size();
            if (resourceList != null && len1 > 0) {
                for (Resource resource : resourceList) {
                    Map pmsInfoMap = new HashMap<>();
                    pmsInfoMap.put("id", resource.getId());
                    pmsInfoMap.put("name", resource.getName());
                    pmsInfoMap.put("link", resource.getUrl());
                    //查询指定角色的权限信息
                    List<Integer> selectedresourceListId = roleMapper.queryResourceList(roleId);
                    if (selectedresourceListId != null) {
                        for (Integer pid : selectedresourceListId) {
                            //Integer比较大小必须用equals
                            if (pid.equals(resource.getId())) {
//                                System.out.println("角色所拥有权限编号： "+pid);
                                pmsInfoMap.put("checkInfo", "true");
                            }
                        }
                    }
                    pmsInfoList.add(pmsInfoMap);
                }
            }
            map.put("resourceList", pmsInfoList);
            list.add(map);
        }

        return list;
    }
    @Override
    @Cacheable(value = "groupResource")
    public List<Map> getUserResources(Integer roleId) {
        //查询所有权限组
        List<Resource> parentList = resourceMapper.queryParentResource();
        List<Map> list = new ArrayList<Map>();
        for (Resource parent : parentList) {
            Map map = new HashMap<>();
            map.put("parentList", parent);
            List<Map> pmsInfoList = new ArrayList<>();
            //获取所在权限组的权限信息
            List<Resource> resourceList = resourceMapper.queryByParentId(parent.getId());
            int len1 = resourceList.size();
            if (resourceList != null && len1 > 0) {
                for (Resource resource : resourceList) {
                    Map pmsInfoMap = new HashMap<>();
                    pmsInfoMap.put("id", resource.getId());
                    pmsInfoMap.put("name", resource.getName());
                    pmsInfoMap.put("link", resource.getUrl());
                    //查询指定角色的权限信息
                    List<Integer> selectedresourceListId = roleMapper.queryResourceList(roleId);
                    if (selectedresourceListId != null) {
                        for (Integer pid : selectedresourceListId) {
                            //Integer比较大小必须用equals
                            if (pid.equals(resource.getId())) {
//                                System.out.println("角色所拥有权限编号： "+pid);
                                pmsInfoMap.put("checkInfo", "true");
                            }
                        }
                    }
                    pmsInfoList.add(pmsInfoMap);
                }
            }
            map.put("resourceList", pmsInfoList);
            list.add(map);
        }

        return list;
    }
}
