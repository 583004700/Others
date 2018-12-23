package com.byefan.xhoa.mapper.sys;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.sys.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends BaseMapper<Dept, Integer> {

    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Dept t);

    @Select("select * from sys_dept where state>=0 order by id ")
    List<Dept> listAll();

    @Select({
            "<script>",
            "select d.* from sys_user u\n",
            "inner join sys_dept d\n",
            "on d.id = u.dept_id\n",
            "where u.state>-2 and d.state>-2 \n",
            "<when test='userId!=null and userId!=\"\"'>",
            "and u.id = #{userId}",
            "</when>",
            "</script>"
    })
    List<Dept> listParam(@Param("userId") Integer userId);

    @Select("select * from sys_dept where state>-2 and id=#{id} ")
    Dept getById(@Param("id") Integer id);

    @Select("select Max(level) maxLevel from sys_dept where state>-2")
    Integer getMaxLevel();

    @Select("SELECT * FROM sys_dept where  state>-2 " )
    List<Dept> queryAllDept() ;

//    @Select("select * from sys_dept where state=0 id in (select dept_id from sys_user_dept where state=0 user_id=#{id})")
    @Select("select a.* from sys_dept a,sys_user u where a.state>-2 and a.id=u.dept_id and u.state>-2 and u.id=#{id}")
    List<Dept> queryDeptByUserId(@Param("id") Integer id)  ;

    @Select("select * from sys_dept where state>-2 and parent_id=#{parentId}")
    List<Dept> queryDeptByParentId(@Param("parentId") Integer id) ;

    @Select("SELECT * FROM sys_dept where name=#{name} and state>-2 ")
    List<Dept> queryDeptByName(@Param("name") String name);

    @Select({
            "<script>",
            "select * from sys_dept d where d.state>-2 \n"+
            "<when test='type!=null and type!=\"\"'>",
            "and d.type = #{type}",
            "</when>",
            "</script>"
    })
    List<Dept> listPara(Map map);
}
