package com.byefan.xhoa.controller.media;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.byefan.core.ResponseData;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.media.Supplier;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.media.ISupplierService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/supplier")
@Api(description = "媒体供应商接口")
public class SupplierController {
	@Autowired
	ISupplierService supplierService;

	@PostMapping("/listall")
	@ResponseBody
	@ApiOperation(value = "分页查询媒体供应商列表", notes = "分页查询媒体供应商列表", response = PageInfo.class)
	public PageInfo<Supplier> listall(@ApiParam("媒体供应商筛选条件") Supplier supplier, @ApiParam("分页对象") Pageable pageable) {
		return supplierService.listall(supplier, pageable);
	}

	@GetMapping("/list")
	@ResponseBody
	public List<Supplier> list(Supplier supplier) {
		return supplierService.list(supplier);
	}

	@GetMapping("/get")
	@ResponseBody
	@Log(opType = OperateType.QUERY, module = "媒体管理|供应商管理", note = "根据id查询供应商")
	public ResponseData getById(Integer id) {
		try {
			Supplier supplier = supplierService.getById(id);
			ResponseData data = ResponseData.ok();
			data.putDataValue("message", "操作成功");
			data.putDataValue("supplier", supplier);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}
	}

	/**
	 * 判断供应商+联系人是否重复
	 *
	 * @param supplierName
	 * @param contactor
	 * @return
	 */
	@PostMapping("/repeat")
	@ResponseBody
	public ResponseData repeat(String supplierName, String contactor) {
		boolean repe = false;
		try {
			repe = supplierService.isRepeat(supplierName, contactor);
			ResponseData responseData = ResponseData.ok();
			responseData.putDataValue("repeatResult", repe);
			return responseData;
		} catch (Exception e) {
			log.error("", e);
			ResponseData responseData = ResponseData.customerError(1001, e.getMessage());
			return responseData;
		}
	}

	@RequestMapping("/add")
	@ResponseBody
	@Log(opType = OperateType.ADD, module = "媒体管理|供应商管理", note = "新增供应商")
	// @Verify(code = "/income/add", module = "系统管理/角色提交")
	public ResponseData add(Supplier entity, HttpSession session) {
		try {
			// 编辑和新增公用一个页面，导致页面id可能有值，以防万一，新增时删掉id
			entity.setId(null);
			User user = (User) session.getAttribute(IConst.USER_KEY);
			entity.setCreator(user.getId());
			entity.setCreateTime(new Date());
			supplierService.save(entity);
			ResponseData data = ResponseData.ok();
			data.putDataValue("message", "添加成功");
			data.putDataValue("entity", entity);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}
	}

	@RequestMapping("/edit")
	@ResponseBody
	@Log(opType = OperateType.UPDATE, module = "媒体管理|供应商管理", note = "修改供应商")
	// @Verify(code = "/income/add", module = "系统管理/角色提交")
	public ResponseData edit(Supplier entity, HttpSession session) {
		try {
			User user = (User) session.getAttribute(IConst.USER_KEY);
			entity.setUpdateUserId(user.getId());
			supplierService.update(entity);
			ResponseData data = ResponseData.ok();
			data.putDataValue("message", "操作成功");
			data.putDataValue("entity", entity);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}
	}

	/**
	 * 按照id设置供应商信息的状态，状态：0正常、1停用、2、注销
	 *
	 * @param id
	 * @param session
	 * @return ResponseData
	 */
	@RequestMapping("/del")
	@ResponseBody
	@Log(opType = OperateType.DELETE, module = "媒体管理|供应商管理", note = "删除供应商")
	public ResponseData del(Integer id, HttpSession session) {
		try {
			Supplier supplier = supplierService.getById(id);
			supplier.setState(1);
			User user = (User) session.getAttribute(IConst.USER_KEY);
			supplier.setUpdateUserId(user.getId());
			supplierService.update(supplier);
			ResponseData data = ResponseData.ok();
			data.putDataValue("message", "操作成功");
			data.putDataValue("entity", supplier);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}
	}

	@RequestMapping("/querySupplierList")
	@ResponseBody
	public PageInfo<Map> querySupplierList(@PageableDefault(size = 5) Pageable pageable, @RequestParam Map map) {
		return supplierService.querySupplierList(pageable.getPageNumber(), pageable.getPageSize(), map);
	}
}