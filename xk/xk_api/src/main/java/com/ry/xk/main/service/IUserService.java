package com.ry.xk.main.service;

import com.ry.xk.main.bo.User;

/**
 * 用户业务接口
 * 
 * @ClassName: IUserService
 * @author 幸仁强
 * @date 2018年5月29日
 */
public interface IUserService
{
    /**
     * 根据主键获取用户信息
     * 
     * @Title: get
     * @author 幸仁强
     * @param userId
     *            主鍵
     * @return User
     */
    public User get(int userId)
        throws Exception;

    /**
     * 校验并绑定用户
     * 
     * @Title: checkAndBindUser
     * @author 幸仁强
     * @param partnerId
     * @param openId
     * @return
     * @throws Exception 
     */
    public int checkAndBindUser(int partnerId, String openId) throws Exception;
}
