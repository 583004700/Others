package com.byefan.xhoa.mapper.sys;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.sys.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends BaseMapper<Role, Integer> {

    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Role t);

//    @Select("select * from sys_role where state='0' and  role_type=#{roleType}")
//    SysRole findRoleByType(@Param("roleType") String roleType);
//
//    @Select("select * from sys_role where state='0' and name=#{name}")
//    SysRole findRoleByName(@Param("name") String name);

    @Select("select * from sys_role where state>-2 order by id desc")
    List<Role> listAll();

    @Select({"<script>",
            " SELECT a.id id,c.name type,d.name code,a.name name,a.remark remark,b.id userId,b.user_name userName,b.name uname FROM sys_role a " +
                    " left join sys_dict c on a.type=c.code and c.type_code='ROLE_TYPE' " +
                    " left join sys_dict d on a.code=d.code and d.type_code='ROLE_CODE', " +
                    " sys_user b  WHERE a.creator=b.id and a.state>-2  " +
                    " <when test='typeQc!=null and typeQc!=\"\"'>",
            " AND c.name like '%${typeQc}%'",
            " </when>",
            " <when test='nameQc!=null and nameQc!=\"\"'>",
            " AND a.name like '%${nameQc}%'",
            " </when>",
            " order by a.id desc",
            "</script>"})
    @Results({@Result(column="userId",property="user.id"),@Result(column="userName",property="user.userName"),@Result(column="uname",property="user.name")})
    List<Role> listPg(Map map);

    @Select("select resource_id resourceId from sys_role_resource where  role_id=#{roleId} ")
    List<Integer> queryResourceList(@Param("roleId") Integer roleId);

//    @Select("select resource_id resourceId from sys_role_resource where  role_id=#{roleId} ")
//    List<Integer> submitRoleResource(@Param("roleId") Integer roleId);

//    @Select("select t.id,t.rolt_type,t.name,t.roleDesc from sys_role ")
//    List<SysRole> listAll();

//    @Select("select * from sys_role where  state='0' and  id=#{id}")
//    SysRole findRoleById(@Param("id") Integer id);

    //    @Update("update sys_role set role_type=#{sysRole.roleType},name=#{sysRole.name},role_desc=#{sysRole.roleDesc} where id=#{sysRole.id}")
//    void updateRole(@Param("sysRole") SysRole sysRole);
    @Update("delete from sys_role_resource where role_id=#{roleId}")
    void delRoleResourceByRoleId(@Param("roleId") Integer roleId);

    @Insert("insert into sys_role_resource (role_id,resource_id) values (#{roleId},#{resourceId})")
    void insertRoleResource(@Param("roleId") Integer roleId, @Param("resourceId") Integer resourceId);

    @Select("select * from sys_role where state>-2 and name=#{name} ")
    Role getRoleByName(@Param("name") String name);

    @Select("select * from sys_role where state>-2 and type=#{roleType} ")
    Role getRoleByType(@Param("roleType") String roleType);

    @Select("select * from sys_role where state>-2 and id=#{id} ")
    @Results({
            @Result(property = "dept", column = "dept_id",
                    one = @One(select = "com.byefan.xhoa.mapper.sys.DeptMapper.getById"))
    })
    Role getById(@Param("id") Integer id);

    @Select("select * from sys_role where state>-2 ")
    @Results({
            @Result(property = "dept", column = "dept_id",
                    one = @One(select = "com.byefan.xhoa.mapper.sys.DeptMapper.getById"))
    })
    List<Role> queryRoleByDeptId(@Param("id") Integer id);

    @Select("select * from sys_role where state>-2 and id in (select role_id from sys_user_role where  user_id=#{id})")
    List<Role> queryRoleByUserId(@Param("id") Integer id);

    @Select("SELECT sr.* FROM sys_role sr,sys_user su,sys_user_role sur " +
            " where sr.id=sur.role_id and su.id=sur.user_id " +
            " and sr.state>-2 and su.state>-2 and su.id=#{id} ")
    List<Role> querySelRoleByUserId(@Param("id") Integer id);

    @Select("SELECT * FROM sys_role where name=#{name} and state>-2 ")
    List<Role> queryRoleByName(@Param("name") String name);

}
