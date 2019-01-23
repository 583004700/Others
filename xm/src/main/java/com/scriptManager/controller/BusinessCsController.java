package com.scriptManager.controller;

import com.scriptManager.service.IBusinessCsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/businessCs")
public class BusinessCsController {
    @Autowired
    IBusinessCsService businessCsService;


    @RequestMapping("/queryList")
    @ResponseBody
    public List<Map> queryList(@RequestParam Map map){
        return businessCsService.queryList(map);
    }
}
