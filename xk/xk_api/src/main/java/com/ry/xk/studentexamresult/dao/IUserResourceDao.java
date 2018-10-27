package com.ry.xk.studentexamresult.dao;

import com.ry.xk.common.DatabaseType;
import com.ry.xk.springbootframe.datasource.MyDataSource;
import com.ry.xk.studentexamresult.bo.UserResource;
import org.springframework.stereotype.Component;

import com.ry.xk.studentexamresult.bo.UserResourceList;

import java.util.List;

@Component
public interface IUserResourceDao {
    /**
     * 根据用户ID和资源类型获取用户资源
     * @param userId
     * @param resourceTypeId
     * @return
     */
    public UserResourceList getUserResource(int userId, int resourceTypeId);
    /**
     * 添加一条用户资源数据
     *
     * @param userResource
     * @return
     */
    public int addUserResource(UserResource userResource);

    /**
     * 批量添加userresource数据
     * @param userResource
     * @return
     */
    public int addUserResourceList(List<UserResource> userResource);
}
