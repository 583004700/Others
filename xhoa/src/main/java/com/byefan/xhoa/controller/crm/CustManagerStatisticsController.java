package com.byefan.xhoa.controller.crm;

import com.byefan.xhoa.service.crm.ICustManagerStatisticsService;
import com.byefan.xhoa.service.crm.IStatisticsService;
import com.byefan.xhoa.utils.DataSecurityUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/custManagerStatistics")
public class CustManagerStatisticsController {
    @Autowired
    ICustManagerStatisticsService custManagerStatisticsService;

    @RequestMapping("/topStatistics")
    @ResponseBody
    public Map topStatistics(@RequestParam Map map){
        DataSecurityUtil.addSecurity(map);
        return custManagerStatisticsService.topStatistics(map);
    }

    //查询各个部门的男女人数
    @RequestMapping("/everyDeptUserCount")
    @ResponseBody
    public List<Map> everyDeptUserCount(@RequestParam(required = false,value = "list") String list){
        try {
            if (list == null || list.split(",").length < 1) {
                return new ArrayList();
            }
        }catch(Exception e){
            log.error("查询部门男女人数异常",e);
        }
        List<String> depts = Arrays.asList(list.split(","));
        return custManagerStatisticsService.everyDeptUserCount(depts);
    }

    @RequestMapping("/custPie")
    @ResponseBody
    public Map custPie(@RequestParam Map map){
        DataSecurityUtil.addSecurity(map);
        return custManagerStatisticsService.custPie(map);
    }
}
