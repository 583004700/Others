package com.byefan.xhoa.mapper.media;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.media.MediaInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface MediaInfoMapper extends BaseMapper<MediaInfo, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(MediaInfo record);

    MediaInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MediaInfo record);

    int updateByPrimaryKey(MediaInfo record);

    //    @Select("select * from t_media_info where m_type=#{media.mType}")
    @SelectProvider(type = ProviderUtil.class, method = "listByOrder")
//    @Results({
//            @Result(property = "user", column = "user_id", one = @One(select = "com.byefan.xhoa.mapper.sys.UserMapper.getById")),
//            @Result(property = "creator", column = "user_id", one = @One(select = "com.byefan.xhoa.mapper.sys.UserMapper.getById"))}
//    )
    List<MediaInfo> medias(@Param("t") MediaInfo mediaInfo, @Param("orders") String... order);

//    @Select("select * from t_media_info where m_type=#{mType}")
//    @Results({
//            @Result(property = "user", column = "user_id", one = @One(select = "com.byefan.xhoa.mapper.sys.UserMapper.getById")),
//            @Result(property = "creator", column = "user_id", one = @One(select = "com.byefan.xhoa.mapper.sys.UserMapper.getById"))}
//    )
//    List<MediaPass> mediasByMediaType(@Param("mType") Integer mType);

    @Select("select count(id) from t_media_info where m_type = #{mType} and name=#{name}")
    int getIdByName(@Param("mType") Integer mType, @Param("name") String name);

    @Update("update t_media_info set state=#{state} where id=#{id}")
    int modifyStateById(@Param("state") int state, @Param("id") Integer id);

    @Insert("insert into t_media_info select * from t_media where id=#{mediaId} ")
    int selectToSave(@Param("mediaId") Integer mediaId);

    @Update("UPDATE t_media_info a, t_media b SET a.`name`=b.`name`,a.`remarks`=b.`remarks`,a.`creator_id`=b.`creator_id`," +
            "a.`create_date`=b.`create_date`,a.`user_id`=b.`user_id`,a.`update_date`=b.`update_date`,a.`supplier_id`=b.`supplier_id`," +
            " a.`supplier_name`=b.`supplier_name`,a.`pic_path`=b.`pic_path`,a.`comm_start`=b.`comm_start`,a.`m_type`=b.`m_type`, " +
            " a.`state`=b.`state`,a.`discount`=b.`discount`,a.`d1`=b.`d1`, a.`d2`=b.`d2`,a.`n1`=b.`n1`,a.`c1`=b.`c1`,  " +
            "a.`c2`=b.`c2`,a.`c3`=b.`c3`,a.`c4`=b.`n1`,a.`n2`=b.`n2`,a.`n3`=b.`n3`, a.`n4`=b.`n4`,a.`n5`=b.`n5`," +
            "a.`n6`=b.`n6`,a.`n7`=b.`n7`,a.`n8`=b.`n8`,a.`f1`=b.f1, a.`f2`=b.`f2`, a.`f3`=b.`f3`,a.`f4`=b.`f4`,  " +
            "a.`f5`=b.`f5`,a.`f6`=b.`f6`,a.`f7`=b.`f7`,a.`f8`=b.`f8`,a.`f9`=b.`f9`,a.`f10`=b.`f10` WHERE a.`id`=b.`id` AND a.`id`=#{mediaId}")
    int selectToUpdate(@Param("mediaId") Integer mediaId);
}