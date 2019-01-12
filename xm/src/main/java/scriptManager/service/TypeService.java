package scriptManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scriptManager.mapper.TypeMapper;

import java.util.List;
import java.util.Map;

@Service
public class TypeService implements ITypeService{
    @Autowired
    TypeMapper typeMapper;

    public List<Map> queryList(Map map){
        return typeMapper.queryList(map);
    }
}
