package scriptManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scriptManager.data.ThreadDataSourceManager;
import scriptManager.mapper.DynamicQueryMapper;

import java.util.List;
import java.util.Map;

@Service
public class DynamicQueryService implements IDynamicQueryService{
    @Autowired
    DynamicQueryMapper dynamicQueryMapper;

    public List<Map> queryList(Map map,String dataSourceKey){
        //设置数据源
        ThreadDataSourceManager.set(dataSourceKey);
        return dynamicQueryMapper.queryList(map);
    }

}