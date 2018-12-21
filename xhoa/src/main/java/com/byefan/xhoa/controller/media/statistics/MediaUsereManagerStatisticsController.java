package com.byefan.xhoa.controller.media.statistics;

import com.byefan.xhoa.service.mediauser.statistics.IMediaUsereManagerStatisticsService;
import com.byefan.xhoa.utils.DataSecurityUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/mediaUsereManagerStatistics")

public class MediaUsereManagerStatisticsController {
    @Autowired
    IMediaUsereManagerStatisticsService mediaUsereManagerStatisticsService;

    @RequestMapping("/topOptionSetValue")
    @ResponseBody
    public List<Map> topOptionSetValue(@RequestParam Map map) {
        DataSecurityUtil.addSecurity(map);
        List<Map> list = mediaUsereManagerStatisticsService.topOptionSetValue(map);
        return list;
    }

    //供应商排名
    @RequestMapping("/supplierSort")
    @ResponseBody
    public PageInfo<Map> supplierSort(@RequestParam Map map, Pageable pageable){
        DataSecurityUtil.addSecurity(map);
        List<Map> lists = mediaUsereManagerStatisticsService.supplierSort(map,pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map> pageInfo = new PageInfo<Map>(lists);
        return pageInfo;
    }

    //请款排名
    @RequestMapping("/outgoSort")
    @ResponseBody
    public PageInfo<Map> outgoSort(@RequestParam Map map,Pageable pageable){
        DataSecurityUtil.addSecurity(map);
        List<Map> lists = mediaUsereManagerStatisticsService.outgoSort(map,pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map> pageInfo = new PageInfo<Map>(lists);
        return pageInfo;
    }

    //稿件分布类型
    @RequestMapping("/artTypeFb")
    @ResponseBody
    public List<Map> artTypeFb(@RequestParam Map map) {
        DataSecurityUtil.addSecurity(map);
        List<Map> lists = mediaUsereManagerStatisticsService.artTypeFb(map);
        return lists;
    }
    //供应商列表统计
    @RequestMapping("/supplierListSort")
    @ResponseBody
    public PageInfo<Map> supplierListSort(@RequestParam Map map,Pageable pageable){
        DataSecurityUtil.addSecurity(map);
        List<Map> lists = mediaUsereManagerStatisticsService.supplierListSort(map,pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map> pageInfo = new PageInfo<Map>(lists);
        return pageInfo;
    }

}
