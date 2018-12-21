package com.byefan.xhoa.mapper.sys;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.sys.Resource;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ResourceMapper extends BaseMapper<Resource, Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Resource t);

    @Select("select * from sys_resource where state>-2 order by id desc")
    List<Resource> listAll();

    @Select({"<script>",
            " SELECT a.*,b.name parentName,c.id userId,c.user_name userName,c.name uname," +
                    "d.id updateUserId, d.user_name updateUserName, d.name updateName FROM\n" +
                    "  sys_resource a LEFT JOIN sys_user c  ON a.creator = c.id \n" +
                    "  LEFT JOIN sys_user d ON a.`update_user_id` = d.id \n" +
                    "  LEFT JOIN sys_resource b ON a.parent_id = b.id AND b.state > - 2  " +
                    " WHERE a.state>-2 <when test='nameQc!=null and nameQc!=\"\"'>",
            " AND a.name like '%${nameQc}%'", " </when>",
            " <when test='urlQc!=null and urlQc!=\"\"'>",
            " AND a.url like '%${urlQc}%'", " </when>",
            " <when test='parentId!=null and parentId!=\"\"'>",
            " AND a.parent_id = #{parentId}", " </when>",
            " <when test='groupNameQc!=null and groupNameQc!=\"\"'>",
            " AND b.name like '%${groupNameQc}%'", " </when>",
            " order by id desc",
            "</script>"})
    @Results({@Result(column = "userId", property = "user.id"),
            @Result(column = "userName", property = "user.userName"),
            @Result(column = "uname", property = "user.name"),
            @Result(column = "parentName", property = "parent.name"),
            @Result(column = "updateUserId", property = "updateUser.id"),
            @Result(column = "updateUserName", property = "updateUser.userName"),
            @Result(column = "updateName", property = "updateUser.name"),
    })
    List<Resource> listPg(Map map);

    @Select("select * from sys_resource where  state>-2 and  id=#{id}")
    Resource getById(@Param("id") Integer id);

    @Select("select c.* from sys_role a,sys_role_resource b,sys_resource c " +
            " where a.id = b.role_id and b.resource_id = c.id " +
            " and a.state>-2  and c.state>-2 and a.id=#{id}")
    List<Resource> queryByRoleId(@Param("id") Integer id);

    @Select("select * from sys_resource  where state>-2  and parent_id=#{parentId}")
    List<Resource> queryByParentId(@Param("parentId") Integer parentId);

    @Select("SELECT sr.id,sr.name name,sr.url url,sg.`name` groupName FROM sys_resource sr left join sys_group sg on sr.group_id = sg.id  and sg.state>-2 where  sr.state>-2 order by sr.id desc")
    List<Map> listAll2();

    @Select("SELECT * FROM sys_resource where name=#{name} and state>-2 ")
    List<Resource> queryResourceByName(@Param("name") String name);

    @Select(" SELECT  distinct e.* FROM sys_user a, sys_user_role b,\n" +
            " sys_role c, sys_role_resource d, sys_resource e \n" +
            " WHERE a.id = b.user_id AND b.role_id = c.id AND c.id = d.role_id \n" +
            " AND d.resource_id = e.id AND a.state > - 2 AND c.state > - 2 " +
            " AND e.state > -2 AND e.`parent_id`=0 AND e.is_menu=0 AND a.id = #{userId} order by e.sort ")
    List<Resource> queryParentResourceByUserId(@Param("userId") Integer userId);

    @Select(" SELECT distinct e.* FROM sys_user a, sys_user_role b,\n" +
            " sys_role c, sys_role_resource d, sys_resource e \n" +
            " WHERE a.id = b.user_id AND b.role_id = c.id AND c.id = d.role_id \n" +
            " AND d.resource_id = e.id AND a.state > - 2 AND c.state > - 2 " +
            " AND e.state > -2 AND a.id = #{userId} order by e.sort ")
    List<Resource> queryAllResourceByUserId(@Param("userId") Integer userId);

    @Select(" SELECT distinct e.id id,e.parent_id parentId,e.name name,e.url url,e.state state," +
            " e.creator creator,e.create_time createTime,e.update_user_id updateUserId,e.update_time updateTime," +
            " e.is_menu isMenu,e.icon icon,e.sort sort  " +
            " FROM sys_user a, sys_user_role b,\n" +
            " sys_role c, sys_role_resource d, sys_resource e \n" +
            " WHERE a.id = b.user_id AND b.role_id = c.id AND c.id = d.role_id \n" +
            " AND d.resource_id = e.id AND a.state > - 2 AND c.state > - 2 " +
            " AND e.state > -2  AND e.is_menu=0 AND a.id = #{userId} AND e.parent_id = #{parentId} order by e.sort ")
    List<Resource> queryResourceByParentId(@Param("userId") Integer userId, @Param("parentId") Integer parentId);

    @Select(" SELECT * FROM sys_resource where state > -2 AND `parent_id`=0 AND is_menu=0 order by sort ")
    List<Resource> listAllMenus();

    @Select("select `id`,`parent_id`, `name`,`url`,`state`,`creator`,\n" +
            "  `create_time`,`update_user_id`,`update_time`,`is_menu`,\n" +
            "  `icon` from`sys_resource` where parent_id=#{parentId} and is_menu=0 and state>-2 order by sort")
    List<Resource> listByParentId(@Param("parentId") Integer parentId);

    @Select("select * from sys_resource where state>-2 and parent_id=0 order by sort")
    List<Resource> queryParentResource();

}
