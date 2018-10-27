package com.ry.xk.main.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.main.bo.UserBindDetail;

/**
 * 用户数据层接口
 * 
 * @author 幸仁强
 */
@Component
public interface IUserBindDetailDao
{

    /**
     * 根据openId获取UserId
     * 
     * @Title: bindUserId
     * @author 幸仁强
     * @param bindContent
     * @return
     * @throws Exception
     */
    public int getUserIdByOpenId(String bindContent)
        throws Exception;

    /**
     * 添加用绑定
     * 
     * @Title: insert
     * @author 幸仁强
     * @param userBindDetail
     * @return
     */
    public int insert(UserBindDetail userBindDetail);

    /**
     * 通过用户ID获取用户绑定的信息
     * @param userId
     * @return
     */
    public UserBindDetail getByUserId(int userId);
}