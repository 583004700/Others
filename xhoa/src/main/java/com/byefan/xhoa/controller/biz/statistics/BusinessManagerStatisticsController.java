package com.byefan.xhoa.controller.biz.statistics;

import com.byefan.xhoa.service.biz.statistics.IBusinessManagerStatisticsService;
import com.byefan.xhoa.utils.DataSecurityUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 业务统计
 */
@Slf4j
@Controller
@RequestMapping("/businessManagerStatistics")
public class BusinessManagerStatisticsController {
    @Autowired
    IBusinessManagerStatisticsService businessManagerStatisticsService;

    @RequestMapping("/topOptionSetValue")
    @ResponseBody
    public List<Map> topOptionSetValue(@RequestParam Map map){
        //添加数据权限的控制代码
        DataSecurityUtil.addSecurity(map);
        return businessManagerStatisticsService.topOptionSetValue(map);
    }

    @RequestMapping("/orderSort")
    @ResponseBody
    public PageInfo<Map> orderSort(@RequestParam Map map, Pageable pageable){
        //添加数据权限的控制代码
        DataSecurityUtil.addSecurity(map);
        List<Map> lists = businessManagerStatisticsService.orderSort(map,pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map> pageInfo = new PageInfo<Map>(lists);
        return pageInfo;
    }

    @RequestMapping("/articleSort")
    @ResponseBody
    public PageInfo<Map> articleSort(@RequestParam Map map,Pageable pageable){
        //添加数据权限的控制代码
        DataSecurityUtil.addSecurity(map);
        List<Map> lists = businessManagerStatisticsService.articleSort(map,pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map> pageInfo = new PageInfo<Map>(lists);
        return pageInfo;
    }

    //查询各个部门的
    @RequestMapping("/everyDeptBusiness")
    @ResponseBody
    public List<Map> everyDeptBusiness(@RequestParam(required = false,value = "list") String list,@RequestParam(required = false,value = "dateSelect") String dateSelect){
        try {
            if (list == null || list.split(",").length < 1) {
                return new ArrayList();
            }
        }catch(Exception e){
            log.error("查询部门数据异常",e);
        }
        List<String> depts = Arrays.asList(list.split(","));
        return businessManagerStatisticsService.everyDeptBusiness(depts,dateSelect);
    }

    //统计业务前5名
    @RequestMapping("/businessTop")
    @ResponseBody
    public List<Map> businessTop(@RequestParam Map map){
        return businessManagerStatisticsService.businessTop(map);
    }
}
