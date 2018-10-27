package com.demo.wx.mapper;

import com.demo.wx.model.WxMessage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WxMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxMessage record);

    int insertSelective(WxMessage record);

    WxMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxMessage record);

    int updateByPrimaryKey(WxMessage record);
}