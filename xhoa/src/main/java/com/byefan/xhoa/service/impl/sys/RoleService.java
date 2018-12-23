package com.byefan.xhoa.service.impl.sys;

import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.sys.RoleMapper;
import com.byefan.xhoa.service.sys.IRoleService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    //    @Override
//    public SysRole updateById(SysRole sysRole) {
//        roleMapper.update(sysRole);
//        SysRole sr = roleMapper.findRoleByName(sysRole.toString());
//        return sr;
//    }
    @Override
//    @CacheEvict(value = CHACHE_KEY, key = "'id='+#id")
    public Role delById(Integer id, Integer userId) {
        Role role = roleMapper.get(Role.class, id);
        role.setState(IConst.STATE_DELETE);
        role.setUpdateUserId(userId);
        role.setUpdateTime(new Date());
        roleMapper.update(role);
        return role;
    }
//    @Override
//    public SysRole findByName(String name) {
//        SysRole sr = roleMapper.findRoleByName(name);
//        return sr;
//    }

//    @Override
//    public SysRole findByType(String roleType) {
//        SysRole sr = roleMapper.findRoleByType(roleType);
//        return sr;
//    }

    @Override
//    @Cacheable(value = CHACHE_KEY_LIST, key = "")
    public List<Role> listAll() {
        List<Role> roles = roleMapper.listAll();
        return roles;
    }

    @Override
//    @Cacheable(value = CHACHE_KEY_LIST, key = "'pageNum='+#pageNum")
    public PageInfo<Role> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roles = roleMapper.listPg(map);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        return pageInfo;
    }
//    @Override
//    public PageInfo<SysRole> list2(SysRole sysRole, int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<SysRole> sysRoles = roleMapper.list(sysRole);
//        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoles);
//        return pageInfo;
//    }

//    @Override
//    public PageInfo<Role> listAll(int pageNum, int pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Role> roles = roleMapper.listAll();
//        PageInfo<Role> pageInfo = new PageInfo<>(roles);
//        return pageInfo;
//    }

    @Override
//    @Cacheable(value = CHACHE_KEY, key = "'id='+#id")
    public Role getRoleById(Integer id) {
//        System.out.println("id=" + id);
        Role role = roleMapper.getById(id);
        return role;
    }

    //    @Override
//    public String queryresourceByRoleId(Integer id) {
//        return roleMapper.queryresourceList(id);
//    }
//    @Override
//    public Role submitRole(Role role, Integer id) {
//        if (role.getId() == null) {
//            role.setState(0);
//            role.setCreator(id);
//            role.setCreateTime(new Date());
//            saveRole(role);
//        } else {
//            role.setUpdateUserId(id);
//            role.setUpdateTime(new Date());
//            updateRole(role);
//        }
//        return role;
//    }

//    @CachePut(value = CHACHE_KEY, key = "'id='+#roleId")
    public void saveRole(Role role) {
        role.setState(IConst.STATE_FINISH);
        role.setCreateTime(new Date());
        roleMapper.insert2(role);
    }

//    @CacheEvict(value = CHACHE_KEY, key = "'id='+#role.getId()")
    public void updateRole(Role role) {
        role.setUpdateTime(new Date());
        roleMapper.update(role);
    }

    @Override
//    @CacheEvict(value = "roleResource", key = "'id='+#roleId")
    public void delRoleResourceByRoleId(Integer roleId) {
        roleMapper.delRoleResourceByRoleId(roleId);
    }

    @Override
//    @CachePut(value = "roleResource", key = "'id='+#roleId")
    public void insertRoleResource(Integer roleId, Integer resourceId) {
        roleMapper.insertRoleResource(roleId, resourceId);
    }

    ;

    @Override
//    @Cacheable(value = CHACHE_KEY_LIST, key = "")
    public List<Role> queryAllRole() {
        List<Role> roleList = roleMapper.listAll();
        return roleList;
    }

    @Override
//    @Cacheable(value = CHACHE_KEY, key = "'name='+#name")
    public Role getRoleByName(String name) {
        Role role = roleMapper.getRoleByName(name);
        return role;
    }

    @Override
//    @Cacheable(value = CHACHE_KEY, key = "'roleType='+#roleType")
    public Role getRoleByType(String roleType) {
        Role role = roleMapper.getRoleByType(roleType);
        return role;
    }

    @Override
//    @Cacheable(value = CHACHE_KEY_LIST, key = "'name='+#name")
    public List<Role> queryRoleByName(String name) {
        List<Role> list = roleMapper.queryRoleByName(name);
        return list;
    }

    /**
     * 查询某个用户的所有角色列表
     *
     * @param userId 用户ID
     * @return
     */
    @Override
//    @Cacheable(value = CHACHE_KEY_LIST, key = "'userId='+#userId")
    public List<Role> listRoleByUserId(Integer userId) {
        return roleMapper.querySelRoleByUserId(userId);
    }

    /**
     * 判断某个用户是否是某个角色
     *
     * @param userId   用户ID
     * @param roleType 角色名称
     * @return
     */
    @Override
//    @Cacheable(value = "role_isRole", key = "'userId='+#userId")
    public boolean isRole(Integer userId, String roleType) {
        List<Role> list = this.listRoleByUserId(userId);
        if (list != null)
            for (Role role : list) {
                if (role.getType().indexOf(roleType) > -1)
                    return true;
            }
        return false;
    }

    @Override
    @Cacheable(value = CHACHE_KEY_LIST, key = "'deptId='+#deptId")
    public List<Role> queryRoleByDeptId(Integer deptId) {
        return roleMapper.queryRoleByDeptId(deptId);
    }
}
