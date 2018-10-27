package com.demo.mapper;
import com.demo.pojo.WxMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WxMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxMessage record);

    int insertSelective(WxMessage record);

    WxMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxMessage record);

    int updateByPrimaryKey(WxMessage record);

    @Select("select * from wx_message")
    List<WxMessage> getAll();
}