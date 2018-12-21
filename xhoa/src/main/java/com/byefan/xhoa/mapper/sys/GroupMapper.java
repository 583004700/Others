package com.byefan.xhoa.mapper.sys;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.sys.Group;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface GroupMapper extends BaseMapper<Group,Integer> {
//    @UpdateProvider(type = ProviderUtil.class, method = "update")
//    void update(SysGroup t, HttpSession session);

    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Group t);

    @Select("select * from sys_group where state>-2 order by id desc")
    List<Group> queryGroup();

    @Select({"<script>",
            " SELECT id id,name name,state state,creator creator," +
                    " create_time createTime,update_user_id updateUserId,update_time updateTime" +
                    " FROM sys_group " +
                    " WHERE state>-2 " +
                    " <when test='nameQc!=null and nameQc!=\"\"'>",
            " AND name like '%${nameQc}%'",
            " </when>",
            " order by id desc",
            "</script>"})
    List<Map> listPg(Map map);

    @Select("select * from sys_group where  state>-2 and  id=#{id}")
    Group getById(@Param("id") Integer id);

    @Select("SELECT * FROM sys_group where name=#{name} and state>-2 ")
    List<Group> queryGroupByName(@Param("name") String name);

}
