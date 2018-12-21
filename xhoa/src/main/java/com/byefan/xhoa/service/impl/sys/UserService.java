package com.byefan.xhoa.service.impl.sys;

import com.byefan.core.utils.IpUtils;
import com.byefan.core.utils.MD5Utils;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.sys.DeptMapper;
import com.byefan.xhoa.mapper.sys.UserMapper;
import com.byefan.xhoa.service.sys.IDeptService;
import com.byefan.xhoa.service.sys.IRoleService;
import com.byefan.xhoa.service.sys.IUserService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.DeptParseUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    IRoleService roleService;
    @Autowired
    IDeptService deptService;


    @Override
//    @CachePut(value = CACHE_KEY, key = "'id='+#user.id")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public int add(User user) {
        user.setCreateTime(new Date());
        return userMapper.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public int addSelective(User user) {
        return userMapper.addSelective(user);
    }

    @Override
//    @Cacheable(value = CHACHE_KEY, key = "'id='+#id")
    @Transactional(readOnly = true)
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
//    @CacheEvict(value = CACHE_KEY, key = "'id='+#user.id")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public int update(User user) {
        return userMapper.update2(user);
    }

//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
//    public int updateById(SysUser user) {
//        return userMapper.update(user);
//    }

    @Override
//    @Cacheable(value = "listPg", key = "'list' + #pageNum")
    public PageInfo<User> listPg(int pageNum, int pageSize) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<User> list = userMapper.list2();
            PageInfo<User> pageInfo = new PageInfo<>(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
//    @Cacheable(value = CHACHE_KEY, key = "'list' + #pageNum+'pageSize='+#pageSize")
    public PageInfo<User> listPg(int pageNum, int pageSize, Map map) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<User> list = userMapper.listPg(map);
            for (User user : list) {
                Integer userId = user.getId();
                user.setRoles(roleService.listRoleByUserId(userId));
//                user.setDept(deptService.getById(user.getDeptId()));
                user.setMJ(roleService.isRole(userId, IConst.ROLE_TYPE_MJ));
            }
            PageInfo<User> pageInfo = new PageInfo<>(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
//    @Cacheable(value = CHACHE_KEY)
    public PageInfo<User> list() {
        PageHelper.startPage(1, 2);
        List<User> list = userMapper.all(User.class);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @Override
    @Cacheable(value = CACHE_LIST_KEY)
    public List<User> list(User user) {
        List<User> list = userMapper.list(user);
        return list;
    }

    @Override
    //@Cacheable(value = "login", key = "'userName=' + #user.userName+'&pwd='+#user.password")
    public User login(User user) {
        User user1 = userMapper.getByUserName(user.getUserName());
        String pwd = user.getPassword();
        String pwd1 = MD5Utils.encode(pwd);
        if (user1 == null) {
            throw new RuntimeException("用户名输入错误!");
        }
        if (pwd.equals(user1.getPassword()) || pwd1.equals(user1.getPassword())) {
            //所有部门
            List<Dept> depts = deptService.listAll();
            //当前用户部门
            List<Dept> userDepts = deptService.listParam(user1.getId());
            DeptParseUtil deptParseUtil = new DeptParseUtil(depts);
            if (userDepts != null && userDepts.size() > 0) {
                //设置用户部门
                deptParseUtil.parse(userDepts.get(0));
                user1.setDept(userDepts.get(0));
            }

            user1.setRoles(roleService.listRoleByUserId(user1.getId()));

            //deptIds所属部门和子部门id
            Set set = new HashSet();
            getDeptStr(user1.getDeptId(), set);
            user1.setDeptIdSet(set);
            user1.setCurrentDeptQx(currentDept(user1));
            user1.setCurrentCompanyQx(currentCompanyQx(user1));
//            user1.getRoles().addAll(roles);
            HttpServletRequest request = AppUtil.getRequest();
            String ip = IpUtils.getIpAddress(request);
            user1.setLoginIp(ip);
            try {
                user1.setMac(IpUtils.getMACAddress(ip));
                user1.setLoginTime(new Date());
                this.update(user1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user1;
        } else {
            throw new RuntimeException("密码输入错误!");
        }
    }

    /**
     * 判断当前用户是否具有当前部门的权限
     * @return
     */
    public boolean currentDept(User user){
        boolean b = false;
        int level = user.getDept().getLevel();
        List<Role> roles = user.getRoles();
        if(roles != null){
            for(Role r : roles){
                if ("ZJ".equals(r.getCode()) || "ZJL".equals(r.getCode()) || "FZ".equals(r.getCode())) {
                    if(level >= 0) {
                        return true;
                    }
                }
                if("BZ".equals(r.getCode())){
                    if(level >= 2) {
                        return true;
                    }
                }
                if("ZZ".equals(r.getCode())){
                    if(level >= 2) {
                        return true;
                    }
                }
            }
        }
        return b;
    }

    /**
     * 判断用户是否有当前公司的权限
     * @param user
     * @return
     */
    public boolean currentCompanyQx(User user){
        List<Role> roles = user.getRoles();
        if(roles != null){
            for(Role r : roles){
                if ("ZJ".equals(r.getCode()) || "ZJL".equals(r.getCode()) || "FZ".equals(r.getCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set getDeptStr(Integer deptId, Set set) {
        //加入它本身
        set.add(deptId);
        //加入子集
        List<Dept> list = deptMapper.queryDeptByParentId(deptId);
        for (Dept dept : list) {
            getDeptStr(dept.getId(), set);
        }
//        sb.substring(sb.length()-1,sb.length()) ;
        return set;
    }

    @CachePut(value = CACHE_KEY, key = "'id='+#user.id")
    public User save(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
//    @Cacheable(value = "queryAllMgr", key = "")
    public List<User> queryAllMgr() {
        return userMapper.queryAllMgr();
    }

    @Override
//    @Cacheable(value = "userRole", key = "'id='+#id")
    public List<Role> queryUserRole(Integer id) {
        //用户所对应的角色信息
        List<Role> userRoleList = roleService.listRoleByUserId(id);
        return userRoleList;
    }

    @Override
//    @Cacheable(value = "userRole", key = "'id='+#id")
    public List<Map> viewUserRole(Integer id) {
        List<Map> list = new ArrayList<>();
//        List<Dept> allDepts = deptMapper.queryAllDept();
//        map.put("deptList",allDepts) ;
        List<Dept> selectedDepts = deptMapper.queryDeptByUserId(id);
        for (Dept dept : selectedDepts) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("dept", dept);
            List<Map> inList = new ArrayList<>();
            List<Role> lists = roleService.queryRoleByDeptId(dept.getId());
            List<Role> selLists = userMapper.querySelRoleByUserId(id);
            for (Role tempRole : lists) {
                Map<String, Object> inMap = new HashMap<>();
                if (selLists != null && selLists.size() > 0) {
                    for (Role selRole : selLists) {
                        if (tempRole.getId() == selRole.getId()) {
                            inMap.put("id", tempRole.getId());
                            inMap.put("name", tempRole.getName());
                            inMap.put("chk", "checked");
                            inList.add(inMap);
                        }
                    }
                }
            }
            map.put("roleList", inList);
            list.add(map);
        }
        return list;
    }

    @Override
//    @CacheEvict(value = "userRole", key = "'id='+#userId")
    public void delUserRoleByUserId(Integer userId) {
        userMapper.delUserRoleByUserId(userId);
    }


    @Override
//    @CachePut(value = "userRole", key = "'id='+#userId")
    public void insertUserRole(Integer userId, Integer roleId, Integer creator) {
        userMapper.insertUserRole(userId, roleId, creator);
    }


//    @Override
//    @CacheEvict(value = "userDept", key = "'id='+#userId")
//    public void delUserDeptByUserId(Integer userId) {
//        userMapper.delUserDeptByUserId(userId);
//    }
//
//
//    @Override
//    @CachePut(value = "userDept", key = "'id='+#userId")
//    public void insertUserDept(Integer userId, Integer deptId, Integer creator) {
//        userMapper.insertUserDept(userId, deptId, creator);
//    }


    @Override
    @CacheEvict(value = CACHE_KEY, key = "'id='+#id")
    public User delById(Integer id) {
        User user = userMapper.get(User.class, id);
        user.setState(IConst.STATE_DELETE);
        user.setUpdateTime(new Date());
        userMapper.update(user);
        return user;
    }

//    @CacheEvict(value = CACHE_LIST_KEY)
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public void updatePassword(Integer id, String password) {
        userMapper.updatePassword(id, password);
    }


    @Override
    @Cacheable(value = CACHE_LIST_KEY, key = "'name='+#userName")
    public List<User> queryUserByUserName(String userName) {
        List<User> list = userMapper.queryUserByUserName(userName);
        return list;
    }

    @Override
//    @Cacheable(value = CACHE_LIST_KEY, key = "'pageNum='+#pageable.getPageNumber()")
    public PageInfo<Map> queryUserInfo(Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Map> list = userMapper.queryUserInfo();
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        for (Map m : pageInfo.getList()) {
            if (m.get("roleName") != null)
                m.put("roleName", new String((byte[]) m.get("roleName")));
        }
        return pageInfo;
    }

    /**
     * 通过部门ID查询所有用户
     *
     * @param deptId
     * @return
     */
    @Cacheable(value = CACHE_LIST_KEY, key = "'deptId='+#deptId")
    public List<User> queryUserByDeptId(Integer deptId) {
        Dept dept = new Dept();
        dept.setId(deptId);
        List<Dept> allDepts = deptService.listAll();
        DeptParseUtil deptParseUtil = new DeptParseUtil(allDepts);
        deptParseUtil.parse(dept);
        //得到所有子部门
        List<Dept> depts = dept.getChildDepts();
        List<User> users = userMapper.queryUserByDepts(depts);
        return users;
    }

    /**
     * 根据角色类型查询用户列表
     *
     * @param type 角色类型
     * @return
     */
    @Override
    @Cacheable(value = CACHE_LIST_KEY, key = "'type='+#type")
    public List<User> listByType(String type) {
        return userMapper.listByType(type);
    }

    /**
     * 根据角色类型查询用户列表
     *
     * @param type 角色类型
     * @return
     */
    @Override
    @Cacheable(value = CACHE_LIST_KEY, key = "'type='+#type+',code='+#code")
    public List<User> listByTypeAndCode(String type, String code) {
        return userMapper.listByTypeAndCode(type, code);
    }

    @Override
//    @Cacheable(value = CACHE_LIST_KEY, key = "'type='+#pageSize+',code='+#pageSize")
    public List<Map> deptUser(Integer pageSize, Integer pageNum, Map map) {
        PageHelper.startPage(pageSize, pageNum);
        List<Map> list = userMapper.deptUser(map);
        return list;
    }

    @Override
    @Transactional
    public boolean batchSave(List<Map> params) {
        Integer userId = (Integer) params.get(0).get("userId");
        userMapper.delUserMediaTypeByUserId(userId);
        int retInt = userMapper.addUserMediaType(params);
        log.debug(retInt + "---");
        return true;
    }
    //获取财务总监信息
    @Override
    public User getCFOInfo(){
        List<User> list = userMapper.listByTypeAndCode(IConst.ROLE_TYPE_CW,"ZJ") ;
        return list.get(0) ;
    }
    //获取出纳信息
    @Override
    public User getTellerInfo(){
        List<User> list = userMapper.listByTypeAndCode(IConst.ROLE_TYPE_CW,"CN") ;
        return list.get(0) ;
    }
    //获取会计信息
    @Override
    public User getAccountingInfo(){
        List<User> list = userMapper.listByTypeAndCode(IConst.ROLE_TYPE_CW,"KJ") ;
        return list.get(0) ;
    }
    //获取总经理CEO信息
    @Override
    public User getCEOInfo(){
        List<User> list = userMapper.listByTypeAndCode("","ZJL") ;
        return list.get(0) ;
    }

    /**
     *
     * @return 副总以上返回true，否则返回false
     */
    @Override
    public Boolean getCEOFlag(Integer userId){
        List<User> list = userMapper.getUserRoleInfo(userId,"", "ZJL,FZ");
        if(list!=null && list.size()>0)
            return true ;
        else
            return false ;
    }

    /**
     *
     * @param userId
     * @return 返回String，新媒体=XMT,网络=WL
     */
    @Override
    public String getMJType(Integer userId){
        List<Dept> list = userMapper.getMJType(userId) ;
        if(list!=null && list.size()>0)
           return list.get(0).getType() ;
        else
            return null ;
    }

    /**
     * 根据角色查用户信息
     * @return
     */
    @Override
    public PageInfo<User> queryByRoleId(int pageNum, int pageSize,Map map) {
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<User> list = userMapper.queryByRoleId(map) ;
            PageInfo<User> pageInfo = new PageInfo<>(list);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 根据媒体ID查询媒介人员列表
     *
     * @param mediaId
     * @return
     */
    @Override
    public List<User> listMJByMediaId(Integer mediaId) {
        return userMapper.listMJByMediaId(mediaId);
    }
}
