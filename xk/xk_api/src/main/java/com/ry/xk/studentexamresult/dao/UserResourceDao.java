package com.ry.xk.studentexamresult.dao;


import com.ry.xk.common.DatabaseType;
import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.springbootframe.datasource.MyDataSource;
import com.ry.xk.studentexamresult.bo.UserResource;
import com.ry.xk.studentexamresult.bo.UserResourceList;
import com.ry.xk.studentexamresult.mapper.UserResourceMapper;
import com.ry.xk.utils.CacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserResourceDao implements IUserResourceDao
{

    private static final Logger log = LoggerFactory.getLogger(IShareDao.class);

    @Autowired
    UserResourceMapper userResourceMapper;

    /**
     * 从数据库或者缓存中取出用户的资源
     * 
     * @param userId
     * @param resourceTypeId
     * @return
     */
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public UserResourceList getUserResource(int userId, int resourceTypeId)
    {
        UserResourceList userResourceList = new UserResourceList();
        userResourceList.setUserId(userId);
        userResourceList.setResourceTypeId(resourceTypeId);
        UserResourceList newuserResourceList = CacheUtil.get(userResourceList, () -> {
            UserResourceList fullUserResourceList = new UserResourceList();
            fullUserResourceList.setUserId(userId);
            fullUserResourceList.setResourceTypeId(resourceTypeId);
            List<UserResource> userResources = userResourceMapper.getUserResource(userId, resourceTypeId);
            if (userResources != null && userResources.size() > 0)
            {
                fullUserResourceList.setUserResource(userResources);
            }
            return fullUserResourceList;
        });
        if(newuserResourceList.getUserResource() == null){
            newuserResourceList.setUserResource(new ArrayList<UserResource>());
        }
        return newuserResourceList;
    }

    /**
     * 添加一条用户资源数据
     * 
     * @param userResource
     * @return
     */
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public int addUserResource(UserResource userResource)
    {
        if (userResource.getResourceId() == 0 || userResource.getResourceTypeId() == 0 || userResource.getUserId() == 0)
        {
            return 0;
        }
        int rowCount = userResourceMapper.addUserResource(userResource);
        if (rowCount > 0)
        {
            UserResource fullUserResource = userResourceMapper.getUserResourceByPrimary(userResource);
            UserResourceList userResourceList = getUserResource(userResource.getUserId(), userResource.getResourceTypeId());
            long count = userResourceList.getUserResource().stream().filter(o -> o.getResourceId() == userResource.getResourceId()).count();
            if (count < 1)
            {
                userResourceList.getUserResource().add(fullUserResource);
                CouchBaseFactory.update(userResourceList);
            }
        }
        return rowCount;
    }

    /**
     * 批量添加
     * @param userResource
     * @return
     */
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public int addUserResourceList(List<UserResource> userResource){
        return userResourceMapper.addUserResourceList(userResource);
    }
}
