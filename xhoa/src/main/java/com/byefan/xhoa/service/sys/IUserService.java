package com.byefan.xhoa.service.sys;

import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface IUserService {

    String CACHE_KEY = "user";
    String CACHE_LIST_KEY = "users";

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    int add(User user);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    int addSelective(User user);

    //    @Cacheable(value = "userInfo", key = "'getById' + #id")
    User getById(Integer id);

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    int update(User user);

//    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
//    int updateById(SysUser user);

    //    @Cacheable(value = "list", key = "'list' + #pageNum")
    PageInfo<User> listPg(int pageNum, int pageSize, Map map);

    PageInfo<User> listPg(int pageNum, int pageSize);

    //    @Cacheable(value = "list")
    PageInfo<User> list();

    //    @Cacheable(value = "list")
    List<User> list(User user);

    //    @Cacheable(value = "login", key = "'userName=' + #user.userName+'&pwd='+#user.password")
    User login(User user);

    List<User> queryAllMgr();

    List<Role> queryUserRole(Integer id);

    List<Map> viewUserRole(Integer id);

    void delUserRoleByUserId(Integer userId);

    void insertUserRole(Integer userId, Integer roleId, Integer creator);

//    void delUserDeptByUserId(Integer userId);
//
//    void insertUserDept(Integer userId, Integer roleId, Integer creator);

    User delById(Integer id);

    List<User> listAll();

    void updatePassword(Integer id, String password);

    List<User> queryUserByUserName(String userName);

    PageInfo<Map> queryUserInfo(Pageable pageable);

    List<User> queryUserByDeptId(Integer deptId);

    @Cacheable(value = CACHE_LIST_KEY, key = "'type='+type")
    List<User> listByType(String type);

    @Cacheable(value = CACHE_LIST_KEY, key = "'type='+type+',code='+code")
    List<User> listByTypeAndCode(String type, String code);

    List<Map> deptUser(Integer PageSize, Integer PageNum, Map map);

    boolean batchSave(List<Map> params);

    User getCFOInfo();

    //获取出纳信息
    User getTellerInfo();

    //获取会计信息
    User getAccountingInfo();

    User getCEOInfo();

    Boolean getCEOFlag(Integer userId);

    //获取总经理CEO信息
    String getMJType(Integer userId);

    PageInfo<User> queryByRoleId(int pageNum, int pageSize, Map map) ;

    /**
     * 根据媒体ID查询媒介人员列表
     *
     * @param mediaId
     * @return
     */
    List<User> listMJByMediaId(Integer mediaId);
}
