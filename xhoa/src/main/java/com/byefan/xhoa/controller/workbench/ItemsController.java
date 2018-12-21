package com.byefan.xhoa.controller.workbench;

import com.byefan.xhoa.service.workbench.IItemsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    IItemsService iItemsService;

    /**
     * 查询事项数据
     * @param params
     * @param pageable
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public PageInfo<Map> list(@RequestParam Map params,@PageableDefault(size = 20) Pageable pageable){
        return iItemsService.list(params,pageable);
    }
}
