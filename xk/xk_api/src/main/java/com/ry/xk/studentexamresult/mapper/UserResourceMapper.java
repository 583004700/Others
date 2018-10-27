package com.ry.xk.studentexamresult.mapper;


import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.bo.UserResource;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * 用户资源表mapper
 */
@Mapper
public interface UserResourceMapper
{
    /**
     * 通过用户ID和资源类型获取用户资源
     * @return
     */
    public List<UserResource> getUserResource(@Param("userId") int userId,@Param("resourceTypeId") int resourceTypeId);

    /**
     * 添加一条记录
     * @param userResource
     * @return
     */
    public int addUserResource(UserResource userResource);

    /**
     * 通过主键获取一条记录
     * @param userResource
     * @return
     */
    public UserResource getUserResourceByPrimary(UserResource userResource);

    /**
     * 批量添加userResource
     * @param userResource
     * @return
     */
    public int addUserResourceList(List<UserResource> userResource);
}