package com.common.mapper;

import java.util.List;
import java.util.Map;

/**
 * 单表的常用操作
 */
public interface BaseMapper {
    /**
     * 查询列表
     * @param map
     * @return
     */
    List<Map> selectList(Map map);
}