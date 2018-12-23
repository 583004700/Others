package com.byefan.xhoa.controller.biz.statistics;

import com.byefan.xhoa.service.biz.statistics.IBusinessStatisticsService;
import com.byefan.xhoa.service.crm.IStatisticsService;
import com.byefan.xhoa.utils.DataSecurityUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/businessStatistics")
public class BusinessStatisticsController {
    @Autowired
    IBusinessStatisticsService businessStatisticsService;

    @ResponseBody
    @RequestMapping("/statisticsResult")
    public List<Map<String,Object>> statisticsResult(@RequestParam Map map){
        DataSecurityUtil.addSecurity(map);
        return businessStatisticsService.statisticsResult(map);
    }

    @ResponseBody
    @RequestMapping("/statisticsRanking")
    public PageInfo<Map<String,Object>> statisticsRanking(@RequestParam Map map, @PageableDefault(size = 10) Pageable pageable){
        DataSecurityUtil.addSecurity(map);
        return businessStatisticsService.statisticsRanking(map,pageable.getPageNumber(),pageable.getPageSize());
    }
}
