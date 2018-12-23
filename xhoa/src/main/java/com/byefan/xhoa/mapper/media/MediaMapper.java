package com.byefan.xhoa.mapper.media;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.xhoa.entity.media.Media;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface MediaMapper extends BaseMapper<Media, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Media record);

    Media selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Media record);

    int updateByPrimaryKey(Media record);

//    @SelectProvider(type = ProviderUtil.class, method = "listByOrder")
    @Select({"<script>select * from t_media a where a where 1=1" +
            "<when test='id!=null and id!=\"\"'>",
            "AND id = #{id}",
            "</when>",
            "</script>"})
    List<Media> medias(Media media, String... order);



//    @Select("select * from t_media where m_type=#{mType}")
//    @Results({
//            @Result(property = "user", column = "user_id", one = @One(select = "com.byefan.xhoa.mapper.sys.UserMapper.getById")),
//            @Result(property = "creator", column = "user_id", one = @One(select = "com.byefan.xhoa.mapper.sys.UserMapper.getById"))}
//    )
//    List<Media> mediasByMediaType(@Param("mType") Integer mType);

    @Select("select count(id) from t_media where state >= 0 and m_type = #{mType} and name=#{name}")
    int getIdByName(@Param("mType") Integer mType, @Param("name") String name);

    @Update("update t_media set state=${state} where id=#{id}")
    int modifyStateById(@Param("state") int state, @Param("id") Integer id);
}