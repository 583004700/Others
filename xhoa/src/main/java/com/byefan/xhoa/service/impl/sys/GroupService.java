package com.byefan.xhoa.service.impl.sys;

import com.byefan.xhoa.entity.sys.Group;
import com.byefan.xhoa.entity.sys.Resource;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.sys.GroupMapper;
import com.byefan.xhoa.mapper.sys.ResourceMapper;
import com.byefan.xhoa.mapper.sys.RoleMapper;
import com.byefan.xhoa.service.sys.IGroupService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class GroupService implements IGroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleMapper roleMapper;

//    @Override
//    public PageInfo<Group> listAll(int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Group> list = groupMapper.queryGroup();
//        PageInfo<Group> pages = new PageInfo<>(list);
//        return pages;
//    }

    @Override
//    @Cacheable(value = "group", key = "'pageNum='+#pageNum")
    public PageInfo<Map> listPg(int pageNum, int pageSize,Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = groupMapper.listPg(map);
        PageInfo<Map> pages = new PageInfo<>(list);
        return pages;
    }

    @Override
    @Cacheable(value = "group", key = "")
    public List<Group> allGroups() {
        List<Group> list = groupMapper.queryGroup();
        return list;
    }

    /**
     * 角色权限编辑
     * @param roleId
     * @return
     */
    @Override
//    @Cacheable(value = "groupResource")
    public List<Map> allGroupsAndResources(Integer roleId) {
        //查询所有权限组
        List<Group> groupList = groupMapper.queryGroup();
        List<Map> list = new ArrayList<Map>();
        for (Group group : groupList) {
            Map map = new HashMap<>();
            map.put("group", group);
            List<Map> pmsInfoList = new ArrayList<>();
            //获取所在权限组的权限信息
            List<Resource> resourceList = resourceMapper.queryByParentId(group.getId());
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
//                            System.out.println( "pid"+pid);
//                            System.out.println("selectedresourceListId"+resource.getId());
//                            System.out.println(pid == resource.getId());
                            //Integer比较大小必须用equals
                            if (pid.equals(resource.getId())) {
//                                System.out.println("角色所拥有权限编号：                                                   "+pid);
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


//    public Group submitGroup(Group group, Integer id) {
//        if (group.getId() == null) {
//            group.setState(0);
//            group.setCreateTime(new Date());
//            saveGroup(group);
//        } else {
//            group.setUpdateTime(new Date());
//            group.setUpdateUserId(id);
//            updateGroup(group) ;
//        }
//        return group;
//    }

//    @CachePut(value = "group", key = "'id='+#group.getId()")
    public void saveGroup(Group group){
        group.setState(IConst.STATE_FINISH);
        group.setCreateTime(new Date());
        groupMapper.insert2(group);
    }
//    @CacheEvict(value = "group", key = "'id='+#group.getId()")
    public void updateGroup(Group group){
        group.setUpdateTime(new Date());
        groupMapper.update(group);
    }
    @Override
    @CacheEvict(value = "group", key = "'id='+#id")
    public Group delById(Integer id) {
        Group sysGroup = groupMapper.get(Group.class, id);
//        SysGroup sysGroup = groupMapper.findGroupById(id);
        sysGroup.setState(IConst.STATE_DELETE);
        sysGroup.setUpdateTime(new Date());
        groupMapper.update(sysGroup);
        return sysGroup;
    }

    @Override
    @Cacheable(value = "group", key = "'id='+#id")
    public Group getGroupById(Integer id) {
//        System.out.println("id=" + id);

//        SysRole sysRole1 = roleMapper.get(SysRole.class,id) ;
//        SysRole sysRole = roleMapper.get(SysRole.class,id);
        Group sysGroup = groupMapper.getById(id);
        return sysGroup;
    }

    @Override
    @Cacheable(value = "group", key = "'name='+#name")
    public List<Group> queryGroupByName(String name) {
        List<Group> list = groupMapper.queryGroupByName(name);
        return list;
    }
}
