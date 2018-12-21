package com.byefan.xhoa.controller.fee;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.crm.Const;
import com.byefan.xhoa.entity.workbench.Items;
import com.byefan.xhoa.service.workbench.IItemsService;
import com.byefan.xhoa.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.byefan.core.ResponseData;
import com.byefan.core.entity.Dict;
import com.byefan.core.serivce.IDictService;
import com.byefan.xhoa.entity.fee.Invoice;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.fee.IInvoiceService;
import com.byefan.xhoa.service.impl.flow.ProcessService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/invoice")
@Api(description = "借款流水接口")
public class InvoiceController {

	@Autowired
	private IInvoiceService invoiceService;
	@Autowired
	private IDictService dictService;
	@Autowired
	private ProcessService processService;
	@Autowired
	private IItemsService itemsService;

	@ResponseBody
	@RequestMapping("/listPg")
	// @Log(opType = OperateType.QUERY, module = "角色管理", note = "角色列表")
	// @Verify(code = "/role/listPg", module = "系统管理/角色列表")
	public PageInfo<Map> listPg(@PageableDefault(size = 5) Pageable pageable, @RequestParam Map map) {
		PageInfo<Map> list = null;
		try {
			User user = AppUtil.getUser();
			List<Role> roles = user.getRoles();
			if (roles == null || roles.size() == 0) {
				throw new Exception("未查询到角色信息");
			} else {
				map.put("roleType", roles.get(0).getType());
				map.put("roleCode", roles.get(0).getCode());
				map.put("user", user);
				list = invoiceService.listPg(pageable.getPageNumber(), pageable.getPageSize(), map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/editAjax")
	@ResponseBody
	// @Verify(code = "/role/edit", module = "系统管理/角色编辑")
	public ResponseData editAjax(@RequestParam("id") Integer id) {
		try {
			ResponseData data = ResponseData.ok();
			Invoice entity = invoiceService.getById(id);
			Double total = invoiceService.getSumAmountById(entity.getId());
			List<Dict> taxes = dictService.listByTypeCode("tax");
			data.putDataValue("entity", entity);
			data.putDataValue("taxes", taxes);
			data.putDataValue("total", total);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}
	}

	@RequestMapping(value = "/view")
	@ResponseBody
	// @Verify(code = "/role/view", module = "系统管理/角色查看")
	public ResponseData view(@RequestParam("id") Integer id) {
		try {
			ResponseData data = ResponseData.ok();
			Invoice entity = invoiceService.getById(id);
			List<Dict> taxes = dictService.listByTypeCode("tax");
			data.putDataValue("taxes", taxes);
			data.putDataValue("entity", entity);
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}
	}

	@RequestMapping(value = "/del")
	@ResponseBody
	@Log(opType = OperateType.DELETE, module = "财务管理|发票管理", note = "删除发票")
	@Verify(code = "/invoice/del", module = "财务管理/删除发票")
	public ResponseData del(@RequestParam("id") Integer id) {
		try {
			Invoice entity = invoiceService.getById(id);
			//state=0||state=1才能编辑
			if (entity.getState()==IConst.STATE_REJECT||entity.getState()==IConst.STATE_SAVE) {
				// 还原稿件开票状态
				invoiceService.changeInvoiceStates(id, 0);
				// 删除开票和稿件关系
				invoiceService.delInvoiceArticle(id);
				// 删除开票信息
				invoiceService.delById(id);
				ResponseData data = ResponseData.ok();
				data.putDataValue("message", "操作成功");
				return data;
			}else{
				return ResponseData.customerError(1001, "当前状态不支持删除！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}
	}

    /**
     * 暂不启用 ，saveStepOne替代
     * @param entity
     * @return
     */
	@RequestMapping("/add")
	@ResponseBody
	@Log(opType = OperateType.ADD, module = "财务管理|发票管理", note = "新增发票")
	@Verify(code = "/invoice/add", module = "财务管理/新增发票")
	public ResponseData add(Invoice entity) {
		try {
			User user = AppUtil.getUser();
			entity.setCreator(user.getId());
			invoiceService.add(entity);
			ResponseData data = ResponseData.ok();
			data.putDataValue("message", "操作成功");
			data.putDataValue("entity", entity);

			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}

	}

	@RequestMapping("/edit")
	@ResponseBody
	@Log(opType = OperateType.UPDATE, module = "财务管理|发票管理", note = "修改发票")
	@Verify(code = "/invoice/edit", module = "财务管理/修改发票")
	public ResponseData edit(Invoice entity) {
		try {
			//state=0||state=1才能编辑
			if (entity.getState() == IConst.STATE_SAVE || entity.getState() == IConst.STATE_REJECT) {
//				User user = AppUtil.getUser() ;
				ResponseData data = ResponseData.ok();
				entity.setState(IConst.STATE_BZ);
				invoiceService.edit(entity);
				// 保存的时候提交审批，
				// 紧急程度字段暂不启用
				// taskId为空：首次提交审批；不为空：驳回后提交审批
				processService.addBallotProcess(entity, 3);
				data.putDataValue("message", "操作成功");
				data.putDataValue("entity", entity);
				return data;
			} else {
				return ResponseData.customerError(1001, "当前状态不支持修改");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}

	}

	@RequestMapping("/confirm")
	@ResponseBody
	@Log(opType = OperateType.UPDATE, module = "财务管理|发票管理", note = "财务确认开票")
	@Verify(code = "/invoice/confirm", module = "财务管理/财务确认开票")
	public ResponseData confirm(@RequestParam Map map) {
		try {
			User user = AppUtil.getUser() ;
			Boolean flag = false;

			if (user.getRoles() != null && user.getRoles().size() > 0) {
				for (Role role : user.getRoles()) {
					if (IConst.ROLE_TYPE_CW.equals(role.getType())) {
						flag = true;
					}
				}
			}
			;
			ResponseData data = ResponseData.ok();
			if (flag) {
				// 先处理invocie的发票信息
				Integer id = Integer.parseInt((String) map.get("id2"));
				Double taxPoint = Double.parseDouble((String) map.get("taxPoint2"));
				Double taxAmount = Double.parseDouble((String) map.get("taxAmount2"));
				String no = (String) map.get("no2");
				Invoice entity = invoiceService.getById(id);
				if (entity != null) {
				    if(entity.getState()==IConst.STATE_PASS){
                        entity.setTaxPoint(taxPoint);
                        entity.setTaxAmount(taxAmount);
                        entity.setNo(no);
                        entity.setInvoiceTime(new Date());
                        entity.setState(IConst.STATE_FINISH);
                        invoiceService.edit(entity);
                        // 后处理稿件表的状态
                        invoiceService.changeInvoiceStates(id, 1);

						//待办变已办
						Items items = new Items();
						items.setId(entity.getItemId());
						items.setTransactionState(Const.ITEM_Y);
						itemsService.finishItems(items);
                    }else{
                        return ResponseData.customerError(1001, "当前状态不支持该操作！");
                    }
				}
				data.putDataValue("message", "操作成功");
				data.putDataValue("entity", entity);
				return data;
			} else {
				return ResponseData.customerError(1001,"当前用户没有操作权限！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}

	}

	@ResponseBody
	@RequestMapping("/listPgForSelectedArticle")
	// @Log(opType = OperateType.QUERY, module = "财务管理|请款查询", note = "请款列表")
	// @Verify(code = "/role/listPg", module = "系统管理/角色列表")
	public PageInfo<Map> listPgForSelectedArticle(@PageableDefault(size = 5) Pageable pageable, @RequestParam("id") Integer id) {
		PageInfo<Map> list = invoiceService.listPgForSelectedArticle(pageable.getPageNumber(), pageable.getPageSize(), id);
		return list;
	}

	@RequestMapping(value = "/listPgForSelectArticle")
	@ResponseBody
	// @Verify(code = "/role/view", module = "系统管理/角色查看")
	public PageInfo<Map> listPgForSelectArticle(@PageableDefault(size = 5) Pageable pageable, @RequestParam Map map) {
		User user = AppUtil.getUser();
		map.put("id", user.getId());
		PageInfo<Map> list = invoiceService.listPgForSelectArticle(pageable.getPageNumber(), pageable.getPageSize(), map);
		return list;
	}

	@RequestMapping("/saveStepOne")
	@ResponseBody
	@Log(opType = OperateType.ADD, module = "财务管理|发票管理", note = "新增发票")
	@Verify(code = "/invoice/saveStepOne", module = "财务管理/新增发票")
	public ResponseData saveStepOne(@RequestParam Map map) {
		try {
			ResponseData data = ResponseData.ok();
			if (map.get("custCompanyIdSec") == null && map.get("custIdSec") == null || map.get("articleIdsSec") == null) {
				return ResponseData.customerError(1001, "未选择客户或稿件！");
			} else {
				Invoice entity = invoiceService.saveStepOne(map);
				data.putDataValue("entity", entity);
				data.putDataValue("message", "操作成功");
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseData.customerError(1001, e.getMessage());
		}

	}

}
