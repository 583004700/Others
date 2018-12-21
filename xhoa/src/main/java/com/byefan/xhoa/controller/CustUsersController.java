package com.byefan.xhoa.controller;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.crm.Cust;
import com.byefan.xhoa.entity.crm.CustUsers;
import com.byefan.xhoa.entity.crm.DockingPeople;
import com.byefan.xhoa.entity.crm.ProductInfo;
import com.byefan.xhoa.service.crm.ICustUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/custUsers")
public class CustUsersController {
    @Autowired
    ICustUsersService custUsersService;

    @PostMapping("/selectOne")
    @ResponseBody
    public CustUsers selectOne(CustUsers custUsers){
        return custUsersService.selectOne(custUsers);
    }

    @Verify(code = "/custUsers/update", module = "客户管理/更新用户信息")
    @PostMapping("/update")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "更新用户信息", note = "更新用户信息")
    public ResponseData update(Cust cust, DockingPeople dockingPeople, ProductInfo productInfo, CustUsers custUsers, @RequestParam(value = "age1",required = false) Integer age1, @RequestParam(value = "areafb",required = false) String areafb){
        try {
            custUsers.setAge(age1);
            custUsers.setArea(areafb);
            boolean saveStatus = custUsersService.update(custUsers);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status",saveStatus ? "更新成功" : "更新失败");
            return responseData;
        }catch (Exception e){
            log.error("更新用户信息失败",e);
            ResponseData responseData = ResponseData.customerError(1001,e.getMessage());
            responseData.putDataValue("status","更新失败");
            return responseData;
        }
    }
}
