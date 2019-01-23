package com.common.service;

import com.common.mapper.BaseMapper;
import com.common.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonService {

    @Autowired
    BaseMapper baseMapper;

    public <T> List<Map> selectList(T t){
        Map map = BeanUtil.object2Map(t);
        List<Map> list = baseMapper.selectList(map);
        return list;
    }
}
