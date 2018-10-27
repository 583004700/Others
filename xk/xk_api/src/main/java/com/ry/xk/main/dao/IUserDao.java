package com.ry.xk.main.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.main.bo.User;

/**
 * 用户数据层接口
 * 
 * @author 幸仁强
 */
@Component
public interface IUserDao
{

    /**
     * 根据userId查询单条记录
     */
    public User get(int userId)
        throws Exception;

    /**
     * 根据openId查询单条记录
     */
    public int getUserIdByUserName(String userName)
        throws Exception;

    /**
     * 新增用户
     * 
     * @Title: addUser
     * @author 幸仁强
     * @param user
     * @return
     */
    public int insert(User user)
        throws Exception;
}