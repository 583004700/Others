package com.byefan.xhoa.mapper.sys;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User, Integer> {

    @Select("SELECT * FROM sys_user where name=#{name} and state>-2 ")
    User getByname(@Param("name") String name);

    @Select("SELECT * FROM sys_user where user_name=#{userName} and state>-2 ")
    User getByUserName(@Param("userName") String userName);

    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(User t);

    int addSelective(User record);

    @UpdateProvider(type = ProviderUtil.class, method = "update")
    int update2(User record);

    @Select("SELECT * FROM sys_user where id=#{id} and state>-2")
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "user", column = "mgr_id",
//                    one = @One(select = "com.byefan.xhoa.mapper.sys.UserMapper.getById")),
//            @Result(property = "roles", column = "id",
//                    many = @Many(select = "com.byefan.xhoa.mapper.sys.RoleMapper.queryRoleByUserId")),
//            @Result(property = "depts", column = "id",
//                    many = @Many(select = "com.byefan.xhoa.mapper.sys.DeptMapper.queryDeptByUserId"))
//    })
    User getById(@Param("id") Integer id);

    @Select("SELECT * FROM sys_user where state>-2 order by id desc ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "user", column = "mgr_id",
//                    one = @One(select = "com.byefan.xhoa.mapper.sys.UserMapper.getById")),
//            @Result(property = "roles", column = "id",
//                    many = @Many(select = "com.byefan.xhoa.mapper.sys.RoleMapper.queryRoleByUserId")),
//            @Result(property = "depts", column = "id",
//                    many = @Many(select = "com.byefan.xhoa.mapper.sys.DeptMapper.queryDeptByUserId"))
    })
    List<User> list2();

    @Select({"<script>",
            " SELECT *  FROM sys_user a WHERE a.state>-2 " +
                    " <when test='noQc!=null and noQc!=\"\"'>",
            " AND a.no like '%${noQc}%'",
            " </when>",
            " <when test='userNameQc!=null and userNameQc!=\"\"'>",
            " AND a.user_name like '%${userNameQc}%'",
            " </when>",
            " <when test='deptIdQc!=null and deptIdQc!=\"\"'>",
            " AND a.dept_id = #{deptIdQc} ",
            " </when>",
            " <when test='deptNameQc!=null and deptNameQc!=\"\"'>",
            " AND a.dept_name like '%${deptNameQc}%'",
            " </when>",
            " <when test='nameQc!=null and nameQc!=\"\"'>",
            " AND a.name like '%${nameQc}%'",
            " </when>",
            " <when test='phoneQc!=null and phoneQc!=\"\"'>",
            " AND a.phone like '%${phoneQc}%'",
            " </when>",
            " <when test='roleId!=null and roleId!=\"\"'>",
            " AND EXISTS(SELECT 1 FROM sys_user_role b WHERE a.`id`=b.`user_id` AND b.`role_id`=#{roleId})",
            " </when>",
            " order by a.id desc",
            "</script>"})
    List<User> listPg(Map map);

    @Select("SELECT * FROM sys_user where is_mgr=1 and state>-2 ")
    List<User> queryAllMgr();

    @Select("SELECT sr.* FROM sys_role sr,sys_user su,sys_user_role sur where sr.id=sur.role_id and su.id=sur.user_id and su.id=#{id} and sr.state>-2  and su.state>-2 ")
    List<Role> querySelRoleByUserId(@Param("id") Integer id);

    @Delete("delete from sys_user_role  where  user_id=#{userId}")
    void delUserRoleByUserId(@Param("userId") Integer userId);

    @Insert("insert into sys_user_role (user_id,role_id,creator) values (#{userId},#{roleId},#{creator})")
    void insertUserRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId, @Param("creator") Integer creator);

    @Select("SELECT * FROM sys_user where state>-2 ")
    List<User> listAll();

    @Update("update sys_user set password=#{password} where state>-2 and id=#{id} ")
    void updatePassword(@Param("id") Integer id, @Param("password") String password);

    @Select("SELECT * FROM sys_user where user_name=#{userName} and state>-2 ")
    List<User> queryUserByUserName(@Param("userName") String userName);

    @Select("SELECT u.id userId,\n" +
            "group_concat(r.name,'/') roleName,\n" +
            "u.image image,\n" +
            "u.user_name userName,\n" +
            "u.name name,\n" +
            "u.sex sex,\n" +
            "u.wechat wechat,\n" +
            "u.phone phone,\n" +
            "u.email email\n" +
            " FROM sys_user u \n" +
            " left join sys_user_role ur\n" +
            " on u.id = ur.user_id\n" +
            " left join sys_role r on \n" +
            " ur.role_id = r.id\n" +
            " and r.state >-2\n" +
            " where u.state >-2\n" +
            " group by u.id")
    List<Map> queryUserInfo();

    @Select({"<script>",
            "select u.* from sys_user u,sys_dept d where u.dept_id=d.id and u.state>-2 and d.state>-2 " +
                    "<foreach collection=\"list\" item=\"item\" open=\" and u.dept_id in(\" close=\")\" separator=\",\">\n" +
                    "#{item.id}\n" +
                    "</foreach>\n" +
                    "</script>"})
    List<User> queryUserByDepts(@Param("list") List<Dept> depts);

    @Select({"<script>",
            "select id,name,dept_name deptName from sys_user where state>-2 and is_mgr=1 and dept_name like '%${nameQc}%'and name like'%${bankNoQc}%'",


            "</script>"
    })
    List<Map> deptUser(Map map);

    /**
     * 根据角色类型查询用户列表
     *
     * @param type
     * @return
     */
    @Select("SELECT a.* FROM sys_user a,sys_user_role b,sys_role c WHERE a.id=b.`user_id` AND b.`role_id`=c.`id` and a.state>-2 and c.state>-2 AND c.`type`=#{type}")
    List<User> listByType(@Param("type") String type);

    /**
     * 根据角色类型和角色编号查询用户列表
     *
     * @param type
     * @return
     */
    @Select(" <script>SELECT a.* FROM sys_user a,sys_user_role b,sys_role c WHERE a.id=b.`user_id` AND b.`role_id`=c.`id` and a.state>-2 and c.state>-2" +
            " <when test='type!=null and type!=\"\"'>" +
            " AND c.type=#{type}" +
            " </when>" +
            " AND c.`code`=#{code}" +
            " </script>")
    List<User> listByTypeAndCode(@Param("type") String type, @Param("code") String code);

    /**
     * 查询是否是副总经理以上
     */
    @Select(" <script>SELECT a.* FROM sys_user a,sys_user_role b,sys_role c WHERE a.id=b.`user_id` AND b.`role_id`=c.`id` and a.state>-2 and c.state>-2 AND a.id=#{userId} " +
            " <when test='type!=null and type!=\"\"'>" +
            " AND c.type=#{type}" +
            " </when>" +
            " AND c.`code` in (#{code}) order by a.id" +
            " </script>")
    List<User> getUserRoleInfo(@Param("userId") Integer userId, @Param("type") String type, @Param("code") String code);

    @Select("SELECT b.* FROM sys_user a,sys_dept b WHERE a.dept_id=b.id and a.state>-2 and b.state>-2 AND a.id=#{userId} order by a.id")
    List<Dept> getMJType(@Param("userId") Integer userId);

    @Insert("<script>insert into `t_user_media_type` (`user_id`,`media_type_id`,`state`,`depart_id`) " +
            " values <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">" +
            "(#{item.userId},#{item.mediaTypeId},0,#{item.departId}) </foreach></script>")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addUserMediaType(List<Map> map);

    @Delete("delete from t_user_media_type where user_id=#{userId}")
    int delUserMediaTypeByUserId(@Param("userId") Integer userId);

    @Select({"<script>",
            " SELECT su.* FROM sys_role sr,sys_user su,sys_user_role sur" +
                    " where sr.id=sur.role_id and su.id=sur.user_id and sr.state>-2 and su.state>-2 " +
                    " and sr.id=#{roleId} " +
                    " <when test='name!=null and name!=\"\"'>",
            " AND su.name like '%${name}%'",
            " </when>",
            " <when test='userName!=null and userName!=\"\"'>",
            " AND su.user_name like '%${userName}%'",
            " </when>",
            " <when test='deptName!=null and deptName!=\"\"'>",
            " AND su.dept_name like '%${deptName}%'",
            " </when>",
            " order by su.id desc",
            "</script>"})
    List<User> queryByRoleId(Map map);

    /**
     * 根据媒体ID查询媒介人员列表
     *
     * @param mediaId
     * @return
     */
    @Select("select a.* from sys_user a,t_user_media_type b,t_media c,sys_user_role ur,sys_role r \n" +
            " where a.id = b.`user_id` and b.`media_type_id` = c.`m_type` and a.id = ur.`user_id` \n" +
            "  and r.`id` = ur.`role_id` and r.`type` = 'MJ'and c.id = #{mediaId}")
    List<User> listMJByMediaId(@Param("mediaId") Integer mediaId);

}
