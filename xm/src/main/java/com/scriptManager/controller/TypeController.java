package com.scriptManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.scriptManager.service.ITypeService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    ITypeService typeService;


    @RequestMapping("/queryList")
    @ResponseBody
    public List<Map> queryList(@RequestParam Map map){
        return typeService.queryList(map);
    }
}
