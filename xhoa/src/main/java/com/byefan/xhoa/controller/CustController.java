package com.byefan.xhoa.controller;

import com.alibaba.fastjson.JSON;
import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.crm.*;
import com.byefan.xhoa.service.crm.ICustService;
import com.byefan.xhoa.service.crm.IDockingPeopleService;
import com.byefan.xhoa.utils.AppUtil;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/cust")
public class CustController {
    @Autowired
    ICustService custService;
    @Autowired
    IDockingPeopleService dockingPeopleService;

    @PostMapping("/addCust")
    @Verify(code = "/cust/addCust", module = "客户管理/添加客户")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "客户管理/客户登记", note = "客户登记")
    public ResponseData addCust(@RequestParam(value = "op", required = false) String op, @RequestParam(value = "age1", required = false) Integer age1, @RequestParam(value = "areafb", required = false) String areafb, @RequestParam(value = "repeatFlag1", required = false) String repeatFlag1, @RequestParam(value = "file", required = false) MultipartFile file, Cust cust, DockingPeople dockingPeople, ProductInfo productInfo, CustUsers custUsers) {
        try {
            dockingPeopleService.savePhoto(dockingPeople, file);
            dockingPeople.setCreateWorker(AppUtil.getUser().getId());
            //设置负责人
            dockingPeople.setWorker(AppUtil.getUser().getId());
            //设置是否重复
            dockingPeople.setRepeatFlag("是".equals(repeatFlag1) ? 1 : 2);
            custUsers.setAge(age1);
            custUsers.setArea(areafb);
            boolean saveStatus = custService.add(op, cust, dockingPeople, productInfo, custUsers);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status", saveStatus ? "保存成功" : "保存失败");
            return responseData;
        } catch (Exception e) {
            log.error("保存用户信息失败", e);
            ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
            responseData.putDataValue("status", "保存失败");
            return responseData;
        }
    }

    /**
     * 判断对接人是否重复
     *
     * @param companyName
     * @param custName
     * @return
     */
    @PostMapping("/repeat")
    @Log(opType = OperateType.QUERY, module = "客户管理/判断对接人是否重复", note = "判断对接人是否重复")
    @ResponseBody
    public ResponseData repeat(String companyName, String custName) {
        boolean repe = false;
        try {
            repe = custService.isRepeat(companyName, custName);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("repeatResult",repe);
            return responseData;
        } catch (Exception e) {
            log.error("", e);
            ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
            return responseData;
        }
    }

    /**
     * 获取客户列表
     *
     * @param pageable
     * @param map
     * @return
     */
    @Verify(code = "/cust/getCustDockingPeopleVo", module = "客户管理/获取客户列表")
    @RequestMapping("/getCustDockingPeopleVo")
    @ResponseBody
    public PageInfo<Map> getCustDockingPeopleVo(@PageableDefault(size = 10) Pageable pageable, @RequestParam Map map) {
        return custService.getCustDockingPeopleVo(pageable.getPageNumber(), pageable.getPageSize(), map);
    }

    /**
     * 导出全部
     */
    @RequestMapping("/exportAll")
    @Verify(code = "/cust/exportAll", module = "客户管理/导出全部")
    @Log(opType = OperateType.QUERY, module = "客户管理/导出全部", note = "导出全部")
    public void exportAll(HttpServletResponse response, @RequestParam Map map) {
        try {
            response.setContentType("application/binary;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("客户信息表.xls", "UTF-8"));
            OutputStream outputStream = response.getOutputStream();
            custService.exportAll(map, outputStream);
        } catch (Exception e) {
            log.error("导出客户失败", e);
        }
    }

    /**
     * 解除绑定
     *
     * @return
     */
    @PostMapping("/cancelBind")
    @ResponseBody
    public ResponseData cancelBind(DockingPeople peo) {
        try {
            boolean cancelStatus = custService.cancelDocking(peo);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status", cancelStatus ? "解绑成功" : "解绑失败");
            return responseData;
        } catch (Exception e) {
            log.error("解绑对接人失败", e);
            ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
            responseData.putDataValue("status", "解绑失败");
            return responseData;
        }
    }

    @PostMapping("/bind")
    @ResponseBody
    public ResponseData bind(DockingPeople peo) {
        try {
            boolean cancelStatus = custService.bindDocking(peo);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status", cancelStatus ? "认领成功" : "认领失败");
            return responseData;
        } catch (Exception e) {
            log.error("认领对接人失败", e);
            ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
            responseData.putDataValue("status", "认领失败");
            return responseData;
        }
    }

    @ResponseBody
    @PostMapping("/batchBindDocking")
    public ResponseData batchBindDocking(@RequestParam("datas") String peos, @RequestParam("bz") Integer bz, DockingChangeRecord record) {
        try {
            List<DockingPeople> peoples = JSON.parseArray(peos, DockingPeople.class);
            boolean stopOrOpen = custService.batchBindDocking(peoples, record, bz);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status", stopOrOpen ? "交接成功" : "交接失败");
            return responseData;
        } catch (Exception e) {
            log.error("交接失败", e);
            ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
            responseData.putDataValue("status", "交接失败");
            return responseData;
        }
    }

    /**
     * 启用或停用
     *
     * @param peo
     * @return
     */
    @Verify(code = "/cust/stopOrOpen", module = "客户管理/启用停用")
    @ResponseBody
    @PostMapping("/stopOrOpen")
    public ResponseData stopOrOpen(DockingPeople peo) {
        String stat = peo.getDeleteFlag().intValue() != 1 ? "启用" : "停用";
        try {
            boolean stopOrOpen = custService.stopOrOpen(peo);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status", stopOrOpen ? stat + "成功" : stat + "失败");
            return responseData;
        } catch (Exception e) {
            log.error(stat + "对接人失败", e);
            ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
            responseData.putDataValue("status", stat + "失败");
            return responseData;
        }
    }

    /**
     * 获取客户信息详情
     *
     * @param cust
     * @return
     */
    @Verify(code = "/cust/custInfo", module = "客户管理/获取客户详情")
    @RequestMapping("/custInfo")
    @ResponseBody
    public Cust custInfo(Cust cust) {
        Cust custInfo = custService.custInfo(cust.getId());
        return custInfo;
    }

    /**
     * 获取客户信息对接人列表
     *
     * @param cust
     * @return
     */
    @RequestMapping("/dockingInfo")
    @ResponseBody
    public List<DockingPeople> dockingInfo(Cust cust) {
        Cust custInfo = custService.custInfo(cust.getId());
        if (custInfo != null) {
            return custInfo.getDockingPeoples();
        }
        return null;
    }

    /**
     * 获取客户产品列表
     *
     * @param cust
     * @return
     */
    @RequestMapping("/productInfo")
    @ResponseBody
    public List<ProductInfo> productInfo(Cust cust) {
        Cust custInfo = custService.custInfo(cust.getId());
        if (custInfo != null) {
            return custInfo.getProductInfos();
        }
        return null;
    }

    /**
     * 获取客户用户列表
     *
     * @param cust
     * @return
     */
    @RequestMapping("/custUsers")
    @ResponseBody
    public List<CustUsers> custUsers(Cust cust) {
        Cust custInfo = custService.custInfo(cust.getId());
        if (custInfo != null) {
            return custInfo.getCustUsers();
        }
        return null;
    }

    /**
     * 修改公司信息
     *
     * @param cust
     * @return
     */
    @ResponseBody
    @Verify(code = "/cust/updateCompany", module = "客户管理/修改客户信息")
    @PostMapping("/updateCompany")
    public ResponseData updateCompany(Cust cust) {
        try {
            cust.setUpdateTime(new Date());
            boolean status = custService.updateCompany(cust);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("status", status ? "修改成功" : "修改失败");
            return responseData;
        } catch (Exception e) {
            log.error("修改公司信息失败", e);
            ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
            responseData.putDataValue("status", "修改失败");
            return responseData;
        }
    }

    /**
     * 行业下拉框
     *
     * @return
     */
    @ResponseBody
    @PostMapping("/hySelect")
    public List<Map> hySelect() {
        return custService.hySelect();
    }

    /**
     * 开发票获取客户列表
     *
     * @param pageable
     * @param map
     * @return
     */
    @Verify(code = "/cust/getCustDockingPeople", module = "客户管理/获取客户列表")
    @RequestMapping("/getCustDockingPeople")
    @ResponseBody
    public PageInfo<Map> getCustDockingPeople(@PageableDefault(size = 10) Pageable pageable, @RequestParam Map map) {
        return custService.getCustDockingPeople(pageable.getPageNumber(), pageable.getPageSize(), map);
    }


}
