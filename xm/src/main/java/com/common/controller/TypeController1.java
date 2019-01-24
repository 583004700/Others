package com.common.controller;

import com.common.service.TypeService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/typeController1")
public class TypeController1 {
    @Autowired
    TypeService1 typeService;

    @ResponseBody
    @RequestMapping("/getTypeList")
    public List<Map> getTypeList(){
        System.out.println("你好，你好");
        return typeService.selectList();
    }
}
