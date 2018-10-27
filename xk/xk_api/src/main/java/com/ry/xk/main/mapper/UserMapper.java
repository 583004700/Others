package com.ry.xk.main.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.xk.main.bo.User;

/**
 * 用户信息mapper
 * 
 * @author 幸仁强
 */
@Mapper
public interface UserMapper
{
    /**
     * 根据userId查询用户信息
     * 
     * @Title: get
     * @author 幸仁强
     * @param userId
     * @return
     */
    public User get(@Param("userId") int userId);

    /**
     * 根据UserName（OpenId）查询用户信息
     * 
     * @Title: getByOpenId
     * @author 幸仁强
     * @param openId
     * @return
     */
    public int getUserIdByUserName(@Param("userName") String userName);

    /**
     * 新增用户
     * 
     * @Title: addUser
     * @author 幸仁强
     * @param user
     * @return
     */
    public int insert(User user);

}