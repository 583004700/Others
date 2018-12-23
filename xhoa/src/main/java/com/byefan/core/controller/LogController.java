package com.byefan.core.controller;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.entity.Log;
import com.byefan.core.log.OperateType;
import com.byefan.core.serivce.ILogService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志管理
 *
 * @author ByeFan Gzw
 * Created by Administrator on 2018/1/7.
 */
@Slf4j
@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    ILogService logService;

    @GetMapping("/")
//    @Log(opType = OperateType.QUERY, note = "查询日志列表", module = "系统管理/日志管理")
    @Verify(code = "/log/list", action = "查询日志列表", module = "系统管理/查询日志列表")
    @ResponseBody
    public PageInfo<com.byefan.core.entity.Log> list(@PageableDefault(value = 15, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return logService.all(pageable);
    }

    @GetMapping("/{id}")
//    @Log(opType =  OperateType.QUERY,note = "查询日志详情",module = "系统管理/日志管理")
    @Verify(code = "/log", action = "查询日志详情", module = "系统管理/查询日志详情")
    @ResponseBody
    public Log get(@PathVariable int id) {
        return logService.get(id);
    }

    @DeleteMapping("/del/{id}")
//    @Log(opType = OperateType.DELETE, note = "删除日志", module = "系统管理/日志管理")
    @Verify(code = "/log/del", action = "删除日志", module = "系统管理/删除日志")
    @ResponseBody
    public ResponseData del(@PathVariable int id) {
        logService.del(id);
        ResponseData data = ResponseData.ok();
        return data;
    }

    @PostMapping("/delBatch")
//    @Log(opType = OperateType.DELETE, note = "批量删除日志", module = "系统管理/日志管理")
    @Verify(code = "/log/delBatch", action = "批量删除日志", module = "系统管理/批量删除日志")
    @ResponseBody
    public ResponseData del(Log[] logs, HttpServletRequest request) {
//        String[] ids = idsStr.split(",");
        ResponseData data = ResponseData.ok();
//        if(!logService.delBatch(ids)) {
//            data = ResponseData.customerError(1001,"删除失败");
//        }
        return data;
    }

    @GetMapping("/opTypes")
//    @Log(opType = OperateType.QUERY, note = "查询操作类型列表", module = "系统管理/日志管理")
//    @Verify(code = "cps:/log/opTypes", action = "查询操作类型列表", module = "系统管理/根据类型查看日志")
    @ResponseBody
    public Map<String, String> operateTypeList() {
        OperateType[] opts = OperateType.values();
        Map<String, String> map = new HashMap<>();
        for (OperateType opt : opts) {
            map.put(opt.name(), opt.getName());
        }
        return map;
    }

    @GetMapping("/search")
//    @Log(opType = OperateType.QUERY, note = "查询操作类型列表", module = "系统管理/日志管理")
//    @Verify(code = "cps:/log/search", action = "查询操作类型列表", module = "系统管理/搜索日志")
    @ResponseBody
    public PageInfo<com.byefan.core.entity.Log> search(Log log,@PageableDefault(value = 20, sort = {"opDate"}, page = 1, direction = Sort.Direction.DESC) Pageable pageable) {
//        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
        return logService.search(log, pageable);
    }

}
