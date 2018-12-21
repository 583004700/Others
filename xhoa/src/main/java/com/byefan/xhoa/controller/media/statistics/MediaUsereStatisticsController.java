package com.byefan.xhoa.controller.media.statistics;

import com.byefan.xhoa.service.mediauser.statistics.IMediaUserStatisticsService;
import com.byefan.xhoa.utils.DataSecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mediaUsereStatistics")

public class MediaUsereStatisticsController {
    @Autowired
    IMediaUserStatisticsService mediaUsereStatisticsService;

    @RequestMapping("/mediaUserResult")
    @ResponseBody
    public List<Map> mediaUserResult(@RequestParam Map map) {
        DataSecurityUtil.addSecurity(map);
        List<Map> list = mediaUsereStatisticsService.mediaUserResult(map);
        return list;
    }

    @RequestMapping("/supplierResult")
    @ResponseBody
    public List<Map> supplierResult(@RequestParam Map map) {
        DataSecurityUtil.addSecurity(map);
        List<Map> list = mediaUsereStatisticsService.supplierResult(map);
        return list;
    }

}
