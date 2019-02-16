package com.scriptManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scriptManager.data.ThreadDataSourceManager;
import com.scriptManager.mapper.DynamicQueryMapper;

import java.util.List;
import java.util.Map;

@Service
public class DynamicQueryService implements IDynamicQueryService{
    @Autowired
    DynamicQueryMapper dynamicQueryMapper;

    public List<Map> queryList(Map map,String dataSourceKey){
        //设置数据源
        ThreadDataSourceManager.set(dataSourceKey);
        List<Map> list = dynamicQueryMapper.queryList(map);
        //必须手动清除ThreadLocal内容
        ThreadDataSourceManager.remove();
        return list;
    }

}
