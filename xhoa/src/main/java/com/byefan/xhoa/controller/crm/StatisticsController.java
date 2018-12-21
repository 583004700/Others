package com.byefan.xhoa.controller.crm;

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
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    IStatisticsService statisticsService;

    @ResponseBody
    @RequestMapping("/statisticsResult")
    public List<Map<String,Object>> statisticsResult(@RequestParam Map map){
        DataSecurityUtil.addSecurity(map);
        return statisticsService.statisticsResult(map);
    }

    @ResponseBody
    @RequestMapping("/statisticsRanking")
    public PageInfo<Map<String,Object>> statisticsRanking(@RequestParam Map map, @PageableDefault(size = 10) Pageable pageable){
        DataSecurityUtil.addSecurity(map);
        return statisticsService.statisticsRanking(map,pageable.getPageNumber(),pageable.getPageSize());
    }

    /**
     * 根据权限和角色查询用户
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/deptUsers")
    public List<Map> deptUsers(@RequestParam Map map){
        DataSecurityUtil.addSecurity(map);
        return statisticsService.deptUsers(map);
    }
}
