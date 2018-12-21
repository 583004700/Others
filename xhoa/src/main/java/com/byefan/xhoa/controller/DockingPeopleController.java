package com.byefan.xhoa.controller;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.crm.Cust;
import com.byefan.xhoa.entity.crm.CustUsers;
import com.byefan.xhoa.entity.crm.DockingPeople;
import com.byefan.xhoa.entity.crm.ProductInfo;
import com.byefan.xhoa.service.crm.IDockingPeopleService;
import com.byefan.xhoa.service.impl.sys.RoleService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/dockingPeople")
public class DockingPeopleController {
    @Autowired
    IDockingPeopleService dockingPeopleService;
    @Autowired
    RoleService roleService;

    @PostMapping("/selectOne")
    @ResponseBody
    public DockingPeople selectOne(DockingPeople dockingPeople) {
        return dockingPeopleService.selectOne(dockingPeople);
    }

    @Verify(code = "/dockingPeople/update", module = "客户管理/更新对接人")
    @PostMapping("/update")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "更新对接人", note = "更新对接人")
    public ResponseData update(@RequestParam(value = "repeatFlag1", required = false) String repeatFlag1, @RequestParam(value = "file", required = false) MultipartFile file, Cust cust, DockingPeople dockingPeople, ProductInfo productInfo, CustUsers custUsers) {
        try {
            dockingPeopleService.savePhoto(dockingPeople, file);
            //设置是否重复
            dockingPeople.setRepeatFlag("是".equals(repeatFlag1) ? 1 : 2);
            boolean saveStatus = dockingPeopleService.update(dockingPeople);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status", saveStatus ? "更新成功" : "更新失败");
            return responseData;
        } catch (Exception e) {
            log.error("更新用户信息失败", e);
            ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
            responseData.putDataValue("status", "更新失败");
            return responseData;
        }
    }

    @RequestMapping("/listDockingPeople")
    @ResponseBody
    public PageInfo<DockingPeople> listDockingPeople(@RequestParam Map map, Pageable pageable) {
        return dockingPeopleService.listDockingPeople(map, pageable);
    }

    @GetMapping("/listByCustId/{custId}")
    @ResponseBody
    public List<DockingPeople> listByCustId(@PathVariable("custId") Integer custId) {
        Integer userId = AppUtil.getUser().getId();
        boolean flag = roleService.isRole(userId, IConst.ROLE_TYPE_YW);
        Map map = new HashMap();
        map.put("custId", custId);
        if (flag) {//如果是业务员下单只查询自己负责的客户的对接人
            map.put("worker", userId);
        }

        return dockingPeopleService.listDockingPeople(map);
    }
//        return dockingPeopleService.listByCustId(custId);

}
