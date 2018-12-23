package com.byefan.xhoa.service.sys;

import com.byefan.xhoa.entity.sys.Group;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface IGroupService {
//    PageInfo<Group> listAll(int pageNum, int pageSize);

    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    List<Group> allGroups();

    List<Map> allGroupsAndResources(Integer roleId);

    void saveGroup(Group group);

    void updateGroup(Group group);

    Group delById(Integer id);

    Group getGroupById(Integer id);

    List<Group> queryGroupByName(String name);
}
