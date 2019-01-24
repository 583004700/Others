package com.scriptManager.mapper;

import java.util.List;
import java.util.Map;

public interface TypeMapper {
    /**
     * 查询列表
     * @param map
     * @return
     */
    List<Map> queryList(Map map);
}