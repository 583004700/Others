package com.ry.xk.main.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.xk.main.bo.UserBindDetail;

/**
 * 打印机组mapper
 * 
 * @author 幸仁强
 */
@Mapper
public interface UserBindDetailMapper
{
    /**
     * 根据userId查询单条记录
     */
    public int getUserIdByOpenId(@Param("bindContent") String bindContent);

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
     * 通过用户ID查询用户绑定信息
     * @param userId
     * @return
     */
    public UserBindDetail getByUserId(int userId);
}