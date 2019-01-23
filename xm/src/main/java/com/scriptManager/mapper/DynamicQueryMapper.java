package com.scriptManager.mapper;

import java.util.List;
import java.util.Map;

public interface DynamicQueryMapper {
    List<Map> queryList(Map map);
}