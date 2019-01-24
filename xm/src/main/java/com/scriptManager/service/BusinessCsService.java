package com.scriptManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.scriptManager.mapper.BusinessCsMapper;

import java.util.List;
import java.util.Map;

@Service
public class BusinessCsService implements IBusinessCsService{
    @Autowired
    BusinessCsMapper businessCsMapper;

    public List<Map> queryList(Map map){
        return businessCsMapper.queryList(map);
    }
}
