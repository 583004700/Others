package com.byefan.xhoa.service.sys;

import com.byefan.xhoa.entity.sys.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IRoleService {

    String CHACHE_KEY = "role";
    String CHACHE_KEY_LIST = "rolelIST";

    Role delById(Integer id, Integer userId);

    List<Role> listAll();

    PageInfo<Role> listPg(int pageNum, int pageSize, Map map);

//    PageInfo<Role> listAll(int pageNum, int pageSize);

    Role getRoleById(Integer id);

//    String queryresourceByRoleId(Integer id);

    void saveRole(Role role);

    void updateRole(Role role);

    void delRoleResourceByRoleId(Integer roleId);

    void insertRoleResource(Integer roleId, Integer resourceId);

    List<Role> queryAllRole();

    Role getRoleByName(String name);

    Role getRoleByType(String roleType);

    List<Role> queryRoleByName(String name);
//    SysRole updateById(SysRole sysRole) ;
//    SysRole findByName(String name) ;
//    SysRole findByType(String roleType) ;
//    List<SysRole> list2(SysRole sysRole);
//    SysRole submitRole(SysRole sysRole) throws Exception;

    /**
     * 查询某个用户的所有角色列表
     *
     * @param userId 用户ID
     * @return
     */
    List<Role> listRoleByUserId(Integer userId);

    /**
     * 判断某个用户是否是某个角色
     *
     * @param userId   用户ID
     * @param roleType 角色类型
     * @return
     */
    boolean isRole(Integer userId, String roleType);

    List<Role> queryRoleByDeptId(Integer deptId);
}
