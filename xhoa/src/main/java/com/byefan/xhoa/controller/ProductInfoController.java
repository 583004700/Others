package com.byefan.xhoa.controller;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.crm.Cust;
import com.byefan.xhoa.entity.crm.CustUsers;
import com.byefan.xhoa.entity.crm.DockingPeople;
import com.byefan.xhoa.entity.crm.ProductInfo;
import com.byefan.xhoa.service.crm.IProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("product")
public class ProductInfoController {
    @Autowired
    IProductInfoService productInfoService;

    @PostMapping("/selectOne")
    @ResponseBody
    public ProductInfo selectOne(ProductInfo productInfo){
        return productInfoService.selectOne(productInfo);
    }

    @Verify(code = "/product/selectOne", module = "客户管理/更新产品信息")
    @PostMapping("/update")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "更新产品信息", note = "更新产品信息")
    public ResponseData update(Cust cust, DockingPeople dockingPeople, ProductInfo productInfo, CustUsers custUsers){
        try {
            boolean saveStatus = productInfoService.update(productInfo);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status",saveStatus ? "更新成功" : "更新失败");
            return responseData;
        }catch (Exception e){
            log.error("更新产品信息失败",e);
            ResponseData responseData = ResponseData.customerError(1001,e.getMessage());
            responseData.putDataValue("status","更新失败");
            return responseData;
        }
    }
}
