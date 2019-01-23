package com.common.service;

import com.common.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TypeService1 {
    @Autowired
    CommonService commonService;

    public List<Map> selectList(){
        return commonService.selectList(new Type());
    }
}
