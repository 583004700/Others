package com.byefan.xhoa.flow.listener;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.util.StringUtils;

import com.byefan.core.config.websocket.WebSocketServer;
import com.byefan.core.entity.WSMessage;
import com.byefan.core.utils.DateUtils;
import com.byefan.core.utils.SpringUtils;
import com.byefan.xhoa.entity.crm.Const;
import com.byefan.xhoa.entity.fee.*;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.entity.workbench.Items;
import com.byefan.xhoa.entity.workbench.Message;
import com.byefan.xhoa.service.fee.*;
import com.byefan.xhoa.service.sys.IDeptService;
import com.byefan.xhoa.service.sys.IUserService;
import com.byefan.xhoa.service.workbench.IItemsService;
import com.byefan.xhoa.service.workbench.IMessageService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.byefan.xhoa.utils.IProcess;

import lombok.extern.slf4j.Slf4j;

/**
 * 流程审批的公共业务类；
 *
 * @Author ：Yuan；
 * @Date ：2018/12/6 0006 15:16；
 */
@Slf4j
public abstract class CommonTaskHandler implements TaskListener {
	/**
	 * 部门直属领导审批中需要处理的业务内容：1、更新关联数据的状态；2、更新下一个审批人信息到任务对象中；
	 *
	 * @param delegateTask：任务对象；
	 */
	@Override
	public void notify(DelegateTask delegateTask) {
		// 封装数据；
		handleApproveData(delegateTask);
		// 更新数据的状态；
		updateProcessData(delegateTask);
	}

	/**
	 * 根据流程类型获取对应流程需要更新的审批状态，子类覆盖；
	 *
	 * @param delegateTask：任务对象，用于更新流程审批人；
	 */
	public abstract void handleApproveData(DelegateTask delegateTask);

	/**
	 * 确定审批人并更新消息接收人的用户ID和部门ID；
	 *
	 * @param delegateTask：任务对象；
	 */
	protected void setApproveUser(DelegateTask delegateTask) {
		int state = delegateTask.getVariable("state", Integer.class);
		String nextUser = null;
		String userName = null;
		String[] datas;
		switch (state) {
		// 审批被驳回；
		case IConst.STATE_REJECT:
			delegateTask.setVariable("processState", IProcess.PROCESS_REJECT);
			delegateTask.setVariable("acceptDept", delegateTask.getVariable("initiatorDept", Integer.class));
			delegateTask.setVariable("acceptWorker", delegateTask.getVariable("initiatorWorker", Integer.class));
			nextUser = delegateTask.getVariable("userId", String.class);
			userName = delegateTask.getVariable("userName", String.class);
			break;
		// 直属领导审批；
		case IConst.STATE_BZ:
			User user = AppUtil.getUser();
			Integer deptId = user.getDeptId();
			IDeptService deptService = SpringUtils.getBean("deptService");
			Dept dept = deptService.getById(deptId);
			if (dept != null) {
				delegateTask.setVariable("acceptDept", deptId);
				Integer userId = dept.getMgrLeaderId();
				delegateTask.setVariable("acceptWorker", userId);
				nextUser = userId.toString();
				userName = dept.getMgrLeaderName();
			}
			break;
		// 会计审批；
		case IConst.STATE_KJ:
			datas = getApproveUserId(delegateTask);
			nextUser = datas[0];
			userName = datas[1];
			break;
		// 财务总监审批；
		case IConst.STATE_CFO:
			datas = getApproveUserId(delegateTask);
			nextUser = datas[0];
			userName = datas[1];
			break;
		// 总经理审批；
		case IConst.STATE_CEO:
			datas = getApproveUserId(delegateTask);
			nextUser = datas[0];
			userName = datas[1];
			break;
		// 业务员确认；
		case IConst.STATE_YW:
			delegateTask.setVariable("acceptDept", delegateTask.getVariable("businessDept", Integer.class));
			Integer userId = delegateTask.getVariable("businessId", Integer.class);
			delegateTask.setVariable("acceptWorker", userId);
			nextUser = userId.toString();
			userName = delegateTask.getVariable("businessName", String.class);
			break;
		// 审批完成，更新流程的状态；
		case IConst.STATE_PASS:
			delegateTask.setVariable("processState", IProcess.PROCESS_FINISHED);
			delegateTask.setVariable("acceptDept", delegateTask.getVariable("initiatorDept", Integer.class));
			delegateTask.setVariable("acceptWorker", delegateTask.getVariable("initiatorWorker", Integer.class));
			break;
		// 不存在；
		default:
			break;
		}

		// 设置审批人；
		delegateTask.setAssignee(nextUser);
		// 更新审批人到数据库中；
		delegateTask.setVariable("approveUser", nextUser);
		delegateTask.setVariable("approveUserName", userName);
	}

	/**
	 * 获取审批的用户ID；
	 *
	 * @param delegateTask：任务对象；
	 * @return ：审批的用户ID；
	 */
	private String[] getApproveUserId(DelegateTask delegateTask) {
		// 获取数据服务接口；
		IUserService userService = SpringUtils.getBean("userService");
		User user = null;
		String nextUser = null;
		String userName = null;
		// 获取需要更新的状态；
		int state = delegateTask.getVariable("state", Integer.class);
		switch (state) {
		// 会计审批；
		case IConst.STATE_KJ:
			user = userService.getAccountingInfo();
			break;
		// 财务总监审批；
		case IConst.STATE_CFO:
			user = userService.getCFOInfo();
			break;
		// 出纳审批；
		case IConst.STATE_PASS:
			user = userService.getTellerInfo();
			break;
		// 总经理审批；
		case IConst.STATE_CEO:
			user = userService.getCEOInfo();
			break;
		// 不存在；
		default:
			break;
		}

		// 获取用户信息；
		if (user != null) {
			delegateTask.setVariable("acceptDept", user.getDeptId());
			delegateTask.setVariable("acceptWorker", user.getId());
			nextUser = user.getId().toString();
			userName = user.getName();
		}

		return new String[] { nextUser, userName };
	}

	/**
	 * 根据流程类型，更新对应的数据状态；
	 *
	 * @param delegateTask：任务对象；
	 */
	private void updateProcessData(DelegateTask delegateTask) {
		// 用于保存创建代办事项和消息数据的集合；
		Map<String, Object> map = new HashMap<>();
		// 获取数据需要更新的状态；
		int state = delegateTask.getVariable("state", Integer.class);

		// =================================================通知推送模块开始=================================================
		// 更新消息内容，根据状态来确定消息内容；
		String processName = delegateTask.getVariable("processName", String.class);
		// WebSocket发送消息需要此字段；
		map.put("processName", processName);

		// 发送信息需要的信息；
		// FIXME: 2018/12/11 0011 默认显示图片，如需替换请修改此处；
		String pictureAddress = "/img/noPic.jpg";
		String dataUrl = delegateTask.getVariable("dataUrl", String.class);
		switch (state) {
		// 审批驳回；
		case IConst.STATE_REJECT:
			// 发送信息需要的信息；
			map.put("pic", pictureAddress);
			map.put("content", String.format("您提交的%s在%s中被驳回。", processName, delegateTask.getName()));

			// 增加待办事项需要的信息，跳转的地址需要变更为数据编辑的页面；
			map.put("itemName", String.format("%s - 已被驳回", delegateTask.getVariable("dataName")));
			map.put("itemContent", String.format("您的%s已被驳回，请重新提交", processName));
			// 增加待办事项需要的信息；
			map.put("workType", processName);
			// 更新代办事项的跳转地址，跳转到审批关联数据的列表页面；
			map.put("transactionAddress", dataUrl);
			// 处理完成的待办事项跳转到关联数据的列表页面；
			map.put("finishAddress", dataUrl);
			// 代办事项的紧急程度；
			map.put("urgencyLevel", delegateTask.getVariable("urgencyLevel", Integer.class));
			break;
		// 审批通过；
		// case IConst.STATE_FINISH:
		case IConst.STATE_PASS:
			// 发送信息需要的信息，通知流程发起人；
			map.put("newPic", pictureAddress);
			map.put("newContent", String.format("您提交的%s已审批通过。", processName));

			// ===============================通知出纳===============================
			// 增加待办事项需要的信息；
			map.put("itemName", String.format("%s - 等待处理", delegateTask.getVariable("dataName")));
			map.put("itemContent", String.format("您有新的%s需要处理", processName));
			// 增加待办事项需要的信息；
			map.put("workType", processName);
			// 处理中的待办事项跳转到流程审批页面；
			map.put("transactionAddress", dataUrl);
			// 处理完成的待办事项跳转到关联数据的列表页面；
			map.put("finishAddress", dataUrl);
			// 代办事项的紧急程度；
			map.put("urgencyLevel", delegateTask.getVariable("urgencyLevel", Integer.class));
			// 获取出纳用户信息；
			IUserService userService = SpringUtils.getBean("userService");
			User user = userService.getTellerInfo();
			delegateTask.setVariable("acceptDept", user.getDeptId());
			delegateTask.setVariable("acceptWorker", user.getId());
			// ===============================通知出纳结束===============================
			break;
		// 审批正常流转；
		default:
			// ===============================发起人===============================
			// 发送信息需要的信息，用于在审批操作后通知流程发起人；
			map.put("newPic", pictureAddress);
			map.put("newContent", String.format("您提交的%s状态已更新。", processName));

			// 通知审批人；
			map.put("pic", pictureAddress);
			map.put("content", String.format("您有新的%s需要审批。", processName));
			// ===============================发起人结束===============================

			// ===============================审批人===============================
			// 增加待办事项需要的信息；
			map.put("itemName", String.format("%s - 等待审批", delegateTask.getVariable("dataName")));
			map.put("itemContent", String.format("您有新的%s需要审批", processName));
			// 增加待办事项需要的信息；
			map.put("workType", processName);
			// 处理中的待办事项跳转到流程审批页面；
			map.put("transactionAddress", "/process/queryTask");
			// 处理完成的待办事项跳转到关联数据的列表页面；
			map.put("finishAddress", dataUrl);
			// 代办事项的紧急程度；
			map.put("urgencyLevel", delegateTask.getVariable("urgencyLevel", Integer.class));
			// ===============================审批人结束===============================
			break;
		}

		// 获取流程接收人的信息；
		if (delegateTask.hasVariable("acceptDept")) {
			map.put("acceptDept", delegateTask.getVariable("acceptDept", Integer.class));
			map.put("acceptWorker", delegateTask.getVariable("acceptWorker", Integer.class));
		}

		// 获取流程发起人信息；
		Integer initiatorDept = delegateTask.getVariable("initiatorDept", Integer.class);
		Integer initiatorWorker = delegateTask.getVariable("initiatorWorker", Integer.class);
		map.put("initiatorDept", initiatorDept);
		map.put("initiatorWorker", initiatorWorker);

		// 获取上个待办事项的ID，在添加待办事项的时候更新上个待办事项的状态；
		if (delegateTask.hasVariable("itemId")) {
			updateWork(delegateTask.getVariable("itemId", Integer.class));
		}

		// 发送消息；
		sendMessage(map);
		// 增加待办事项；
		Integer itemId = addWork(map);
		// 更新到数据库，用于在流程流转时更新状态；
		if (itemId != null) {
			delegateTask.setVariable("itemId", itemId);
		}

		// 如果有新消息，通知流程发起人；
		Object object = map.get("newContent");
		if (object != null) {
			map.put("pic", map.get("newPic").toString());
			map.put("content", object.toString());

			// 接收人改为流程发起人；
			map.put("acceptDept", initiatorDept);
			map.put("acceptWorker", initiatorWorker);

			sendMessage(map);
		}
		// =================================================通知推送模块结束=================================================

		// =================================================审批数据更新模块开始==============================================
		// 获取审批的流程类型，类型定义参考接口：com.byefan.xhoa.utils.IProcess；
		int process = delegateTask.getVariable("process", Integer.class);
		// 获取需要审批的数据ID，类型不确定，统一使用字符串获取；
		String dataId = delegateTask.getVariable("dataId", String.class);
		// 当前登录的用户ID；
		int loginUserId = AppUtil.getUser().getId();
		// 流程当前的任务ID；
		String taskId = delegateTask.getId();
		switch (process) {
		// 开票申请；
		case IProcess.PROCESS_BALLOT:
			Invoice invoice = new Invoice();

			invoice.setId(Integer.parseInt(dataId));
			invoice.setState(state);
			// 更新流程当前的任务ID；
			invoice.setTaskId(taskId);
			// 更新待办事项的ID；
			invoice.setItemId(itemId);

			IInvoiceService invoiceService = SpringUtils.getBean("invoiceService");
			invoiceService.edit(invoice);
			break;
		// 借款申请；
		case IProcess.PROCESS_BORROW:
			Borrow borrow = new Borrow();

			borrow.setId(Integer.parseInt(dataId));
			borrow.setState(state);
			borrow.setUpdateUserId(loginUserId);
			// 更新流程当前的任务ID；
			borrow.setTaskId(taskId);
			// 更新待办事项的ID；
			borrow.setItemId(itemId);

			IBorrowService borrowService = SpringUtils.getBean("borrowService");
			borrowService.edit(borrow);
			break;
		// 媒介请款；
		case IProcess.PROCESS_MEDIAREFUND:
			Outgo outgo = new Outgo();

			outgo.setId(Integer.parseInt(dataId));
			outgo.setState(state);
			outgo.setUpdateUserId(loginUserId);
			// 更新流程当前的任务ID；
			outgo.setTaskId(taskId);
			// 更新待办事项的ID；
			outgo.setItemId(itemId);

			IOutgoService outgoService = SpringUtils.getBean("outgoService");
			outgoService.edit(outgo);
			break;
		// 退款申请；
		case IProcess.PROCESS_REFUND:
			Refund refund = new Refund();
			refund.setId(Integer.parseInt(dataId));
			refund.setState(state);
			refund.setUpdateUserId(loginUserId);
			// 更新流程当前的任务ID；
			refund.setTaskId(taskId);
			// 更新待办事项的ID；
			refund.setItemId(itemId);

			IRefundService refundService = SpringUtils.getBean("refundService");
			refundService.edit(refund, loginUserId);
			break;
		// 财务提成；
		case IProcess.PROCESS_ROYALTY:
			Commission commission = new Commission();
			commission.setId(Integer.parseInt(dataId));
			commission.setState(state);
			// 更新流程当前的任务ID；
			commission.setTaskId(taskId);
			// 更新待办事项的ID；
			commission.setItemId(itemId);

			ICommissionService commissionService = SpringUtils.getBean("commissionService");
			commissionService.edit(commission);
			break;
		// 流程不存在；
		default:
			break;
		}
		// =================================================审批数据更新模块结束==============================================
	}

	/**
	 * 给子类使用的公用方法，用于给流程的处理人发送提醒消息；
	 *
	 * @param map：保存审批信息的集合；
	 */
	private void sendMessage(Map<String, Object> map) {
		// 发送消息；
		Object object = getNewObject(map, Message.class);
		if (object != null) {
			Message message = (Message) object;
			if (!StringUtils.isEmpty(message.getContent())) {
				// 系统右侧消息推送；
				IMessageService messageService = SpringUtils.getBean("messageService");
				messageService.addMessage(message);

				// WebSocket的消息推送；
				WSMessage wsMessage = new WSMessage();

				// 接收消息的用户信息；
				Integer userId = message.getAcceptWorker();
				wsMessage.setReceiveUserId(userId.toString());
				IUserService userService = SpringUtils.getBean("userService");
				User user = userService.getById(userId);
				wsMessage.setReceiveName(user.getName());

				// 发送消息的用户信息；
				User loginUser = AppUtil.getUser();
				wsMessage.setSendName(loginUser.getName());
				wsMessage.setSendUserId(loginUser.getId().toString());
				wsMessage.setSendUserImage(loginUser.getImage());

				// 消息内容；
				wsMessage.setContent(message.getContent());
				wsMessage.setSubject(map.get("processName").toString());
				// 提交信息；
				WebSocketServer.sendMessage(wsMessage);
			}
		}
	}

	/**
	 * 给子类使用的公用方法，用于给流程的处理人增加代办事项；
	 *
	 * @param map：保存审批信息的集合；
	 */
	private Integer addWork(Map<String, Object> map) {
		Integer itemId = null;
		// 创建代办事项；
		Object object = getNewObject(map, Items.class);
		if (object != null) {
			Items items = (Items) object;
			if (!StringUtils.isEmpty(items.getItemName())) {
				IItemsService itemsService = SpringUtils.getBean("itemsService");
				Date date = new Date();
				items.setStartTime(date);
				// FIXME: 2018/12/8 0008 默认期限为3天，如需修改请在此处编辑；
				items.setEndTime(DateUtils.getAfterDay(date, 3));
				itemsService.addItemsReturnId(items);
				itemId = items.getId();
			}
		}
		return itemId;
	}

	/**
	 * 更新待办事项的状态；
	 * 
	 * @param itemId：待办事项ID；
	 */
	private void updateWork(int itemId) {
		Items items = new Items();
		items.setId(itemId);
		items.setTransactionState(Const.ITEM_Y);
		IItemsService itemsService = SpringUtils.getBean("itemsService");
		itemsService.finishItems(items);
	}

	/**
	 * 封装Map的值到指定类型的POJO对象；
	 *
	 * @param map：保存类审批信息的集合；
	 * @param object：需要反射的对象类型；
	 * @return ：封装完毕的对象；
	 */
	private Object getNewObject(Map<String, Object> map, Class<?> object) {
		Object target = null;
		try {
			target = object.newInstance();
			Field[] fields = object.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				field.set(target, map.get(field.getName()));
			}
		} catch (InstantiationException e) {
			log.error("类初始化异常。");
		} catch (IllegalArgumentException e) {
			log.error("参数异常。");
		} catch (IllegalAccessException e) {
			log.error("类入口异常。");
		}
		return target;
	}
}