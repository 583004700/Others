package com.byefan.xhoa.service.impl.flow;

import java.util.*;

import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ManagementService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
import org.flowable.variable.api.history.HistoricVariableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.byefan.core.utils.DateUtils;
import com.byefan.core.utils.SpringUtils;
import com.byefan.xhoa.entity.fee.*;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.flow.listener.DeleteHistoryTaskCommand;
import com.byefan.xhoa.flow.listener.JumpTaskCommand;
import com.byefan.xhoa.flow.listener.UpdateHistoryTaskCommand;
import com.byefan.xhoa.service.flow.IProcessService;
import com.byefan.xhoa.service.sys.IUserService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.byefan.xhoa.utils.IProcess;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 开票流程的流程服务实现类；
 *
 * @Author ：Yuan；
 * @Date ：2018/12/6 0006 19:56；
 */
@Service
public class ProcessService implements IProcessService {
	// 流程引擎管理服务；
	@Autowired
	private ManagementService managementService;
	// 任务的运行服务；
	@Autowired
	private RuntimeService runtimeService;
	// 任务的业务服务；
	@Autowired
	private TaskService taskService;
	// 审批记录的业务服务；
	@Autowired
	private HistoryService historyService;
	// 用户的业务服务；
	@Autowired
	private IUserService userService;

	/**
	 * 发起开票审批流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param invoice：需要审批的开票对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	@Override
	public String addBallotProcess(Invoice invoice, int urgencyLevel) {
		return startProcess(new HashMap<>(), IProcess.PROCESS_BALLOT, String.valueOf(invoice.getId()), invoice.getTitle(), invoice.getTaskId(), urgencyLevel);
	}

	/**
	 * 发起借款审批流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param borrow：需要审批的借款对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	@Override
	public String addBorrowProcess(Borrow borrow, int urgencyLevel) {
		Map<String, Object> map = new HashMap<>();
		// 设置第一个网关，判断流程申请人的职务是否符合要求；
		map.put("gateCheckA", userService.getCEOFlag(AppUtil.getUser().getId()));
		// 获取系统定义的网关金额；
		double definedMoney = Double.parseDouble(SpringUtils.get("borrowMoney"));
		// 设置第二个网关，判断金额是否符合要求；
		map.put("gateCheckB", borrow.getApplyAmount() >= definedMoney);
		return startProcess(map, IProcess.PROCESS_BORROW, String.valueOf(borrow.getId()), borrow.getTitle(), borrow.getTaskId(), urgencyLevel);
	}

	/**
	 * 发起媒介请款审批流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param outgo：需要审批的媒介请款对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	@Override
	public String addMediaRefundProcess(Outgo outgo, int urgencyLevel) {
		Map<String, Object> map = new HashMap<>();
		// 设置第一个网关，判断流程申请人是否新媒介；
		boolean isNewMedia = StringUtils.equals("XMT", userService.getMJType(AppUtil.getUser().getId()));
		double applyAmount = outgo.getApplyAmount();
		map.put("gateCheckA", isNewMedia);
		// 获取系统定义的新媒介申请的网关金额；
		double definedMoneyNew = Double.parseDouble(SpringUtils.get("mediaRefundMoneyNew"));
		// 获取系统定义的非新媒介申请的网关金额；
		double mediaRefundMoneyOld = Double.parseDouble(SpringUtils.get("mediaRefundMoneyOld"));
		// 设置第二个网关，判断金额是否符合要求，两种媒介的网关金额不一致，需要分开处理；
		if (isNewMedia) {
			map.put("gateCheckB", applyAmount >= definedMoneyNew);
			// FIXME: 2018/12/10 0010 此处存疑，测试中进行调整；
			map.put("gateCheckC", false);
		} else {
			// FIXME: 2018/12/10 0010 此处存疑，测试中进行调整；
			map.put("gateCheckB", false);
			map.put("gateCheckC", applyAmount >= mediaRefundMoneyOld);
		}
		return startProcess(map, IProcess.PROCESS_MEDIAREFUND, String.valueOf(outgo.getId()), outgo.getTitle(), outgo.getTaskId(), urgencyLevel);
	}

	/**
	 * 发起退款申请审批流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param refund：需要审批的退款对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	@Override
	public String addRefundProcess(Refund refund, int urgencyLevel) {
		Map<String, Object> map = new HashMap<>();
		// 获取系统定义的退款金额；
		double definedMoney = Double.parseDouble(SpringUtils.get("refundMoney"));
		// 设置网关，判断金额是否符合要求；
		map.put("gateCheck", refund.getApplyAmount() >= definedMoney);
		return startProcess(map, IProcess.PROCESS_REFUND, String.valueOf(refund.getId()), refund.getTitle(), refund.getTaskId(), urgencyLevel);
	}

	/**
	 * 发起财务提成流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param commission：需要审批的提成对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	@Override
	public String addCommissionProcess(Commission commission, int urgencyLevel) {
		return startProcess(new HashMap<>(), IProcess.PROCESS_ROYALTY, String.valueOf(commission.getId()), commission.getName(), commission.getTaskId(), urgencyLevel);
	}

	/**
	 * 批量审批流程数据：1、流程更新；2、数据状态更新；3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param taskIds：需要审批的任务ID数组；
	 * @param desc：审批备注信息；
	 * @param agree
	 *            ：是否同意，true为是，false为否；
	 * @return ：操作结果描述；
	 */
	@Override
	public String approveProcess(String[] taskIds, String desc, boolean agree) {
		Map<String, Object> map = new HashMap<>();
		map.put("agree", agree);
		boolean isSuccess = false;
		// 获取当前登录用户；
		String userId = AppUtil.getUser().getId().toString();
		String approveUser;
		// 设置审批备注信息；
		StringBuilder approveDesc = new StringBuilder();
		if (agree) {
			approveDesc.append("<b style='color:green;'>【同意】</b>");
		} else {
			approveDesc.append("<b style='color:red;'>【拒绝】</b>");
		}
		// 拼接审批备注；
		if (!StringUtils.isEmpty(desc)) {
			approveDesc.append("：").append(desc);
		}
		for (String taskId : taskIds) {
			// 获取审批人；
			approveUser = taskService.getVariable(taskId, "approveUser", String.class);
			// 验证审批权限；
			if (StringUtils.equals(userId, approveUser)) {
				managementService.executeCommand(new UpdateHistoryTaskCommand(taskId, taskService.getVariable(taskId, "approveUserName", String.class), approveDesc.toString()));
				taskService.complete(taskId, map);
				isSuccess = true;
			} else {
				// 只要有一个审批异常即表示失败，退出审批；
				isSuccess = false;
				break;
			}
			// 更新备注；
		}
		if (isSuccess) {
			return "操作成功。";
		} else {
			return "操作失败。";
		}
	}

	/**
	 * 分页查询登录人的审批任务列表；
	 *
	 * @param map：查询参数；
	 * @param pageNum：当前页码；
	 * @param pageSize：每页显示数量；
	 * @return ：分页数据集合；
	 */
	@Override
	public PageInfo<Map<String, Object>> listTasks(Map<String, String> map, int pageNum, int pageSize) {
		TaskQuery taskQuery = taskService.createTaskQuery();
		TaskQuery query = taskQuery.taskAssignee(AppUtil.getUser().getId().toString());
		// 流程状态；
		query = query.processVariableValueLessThan("processState", IProcess.PROCESS_REJECT);

		// 流程关联的信息；
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (org.springframework.util.StringUtils.isEmpty(value))
				continue;
			if ("dataName".equals(key) || "userName".equals(key) || "initiatorDeptName".equals(key)) {
				query = query.processVariableValueLike(key, "%" + value + "%");
			}
			if ("urgencyLevel".equals(key)) {
				if (!"0".equals(value)) {
					query = query.processVariableValueEquals(key, Integer.parseInt(value));
				}
			}
		}
		// 日期区间；
		String dateStart = map.get("dateStart");
		String dateEnd = map.get("dateEnd");
		if (!org.springframework.util.StringUtils.isEmpty(dateStart)) {
			query.processVariableValueGreaterThanOrEqual("processDate", DateUtils.parse(dateStart, "yyyy/MM/dd"));
		}
		if (!org.springframework.util.StringUtils.isEmpty(dateEnd)) {
			query.processVariableValueLessThanOrEqual("processDate", DateUtils.parse(dateEnd, "yyyy/MM/dd"));
		}

		// 计算页面数量；
		int totalNum = (int) query.count();
		int pages = totalNum / pageSize;
		if (totalNum % pageSize != 0) {
			pages += 1;
		}

		// 计算数据开始的位置；
		int startRow = (pageNum - 1) * (pageSize);
		if (startRow >= totalNum) {
			startRow = totalNum;
		}

		// 计算最后一条数据位置；
		int endRow = pageNum * pageSize;
		if (endRow >= totalNum) {
			endRow = totalNum;
		}

		List<Task> tasks = query.orderByTaskCreateTime().desc().listPage(startRow, endRow);
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> taskDatas;
		String taskId;
		for (Task task : tasks) {
			taskDatas = new HashMap<>();
			taskId = task.getId();
			// 获取设置的变量；
			taskDatas.put("taskId", taskId);
			taskDatas.putAll(taskService.getVariables(taskId));
			taskDatas.putAll(task.getTaskLocalVariables());
			taskDatas.putAll(task.getProcessVariables());
			list.add(taskDatas);
		}

		// 获取要显示的数据；
		Map<String, Object> data;
		for (int i = 0; i < list.size(); i++) {
			data = list.get(i);
			// 添加序号；
			data.put("index", i + startRow + 1);
		}

		// 更新到数据集合中；
		PageHelper.startPage(pageNum, pageSize);
		PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<Map<String, Object>>(list);
		mapPageInfo.setPageSize(pageSize);
		mapPageInfo.setPages(pages);
		mapPageInfo.setStartRow(startRow);
		mapPageInfo.setEndRow(endRow);
		mapPageInfo.setHasPreviousPage(pageNum > pages);
		mapPageInfo.setHasNextPage(pageNum < pages);
		mapPageInfo.setIsFirstPage(pageNum == 1);
		mapPageInfo.setIsLastPage(pageNum == pages);
		mapPageInfo.setPageNum(pageNum);
		mapPageInfo.setTotal(totalNum);

		return mapPageInfo;
	}

	/**
	 * 查询数据的审批记录；
	 *
	 * @param dataId：数据ID；
	 * @param process：流程标志，定义参考com.byefan.xhoa.utils.IProcess；
	 * @return ：审批记录集合；
	 */
	public List<Map<String, Object>> listTaskHistory(String dataId, int process) {
		// 定义集合用来保存数据；
		List<Map<String, Object>> datas = new ArrayList<>();
		// 获取查询对象；
		HistoricTaskInstanceQuery query = historyService.createHistoricTaskInstanceQuery();
		// 增加查询条件；
		query = query.processVariableValueEquals("process", process).processVariableValueEquals("dataId", dataId);
		// 获得查询结果；
		List<HistoricTaskInstance> list = query.orderByTaskCreateTime().asc().list();
		Map<String, Object> map;
		String user;
		// 遍历获取需要的数据；
		for (HistoricTaskInstance historicTaskInstance : list) {
			// 没有审批人的数据可能在审批中，或者是已驳回的数据，跳过；
			user = historicTaskInstance.getAssignee();
			if (!StringUtils.isEmpty(user)) {
				map = new HashMap<>();
				map.put("name", historicTaskInstance.getName());
				map.put("user", user);
				map.put("desc", historicTaskInstance.getDeleteReason());
				map.put("time", DateUtils.format(historicTaskInstance.getEndTime()));
				datas.add(map);
			}
		}
		// 查询一下当前正在运行的流程；
		TaskQuery taskQuery = taskService.createTaskQuery().processVariableValueEquals("process", process).processVariableValueEquals("dataId", dataId);
		// 防止异常（数据库操作等）；
		// Task task = taskQuery.singleResult();
		List<Task> tasks = taskQuery.list();
		// 如果查询有结果；
		if (tasks != null && !tasks.isEmpty()) {
			Task task = tasks.get(0);
			String taskId = task.getId();
			int state = taskService.getVariable(taskId, "state", Integer.class);
			if (state != IConst.STATE_REJECT) {
				map = new HashMap<>();
				map.put("name", task.getName());
				map.put("user", taskService.getVariable(taskId, "approveUserName", String.class));
				map.put("desc", "<b style='color:darkorange;'>正在审批</b>");
				map.put("time", DateUtils.format(task.getCreateTime()));
				datas.add(map);
			}
		}
		return datas;
	}

	/**
	 * 启动流程；
	 * 
	 * @param map：预先定义了网关数据的集合；
	 * @param process：流程类型，定义参考com.byefan.xhoa.utils.IProcess；
	 * @param dataId：需要审批的数据ID；
	 * @param dataName：需要审批的数据名称；
	 * @param taskId：上个流程结束的任务ID；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：流程启动的ID；
	 */
	private String startProcess(Map<String, Object> map, int process, String dataId, String dataName, String taskId, int urgencyLevel) {
		// 检查数据是否已提交流程；
		if (checkDataExsit(process, dataId)) {
			return null;
		} else {
			// 流程信息；
			String processId = null;
			// 流程标识；
			map.put("process", process);
			// 获取流程名称和审批页面地址；
			switch (process) {
			// 开票申请；
			case IProcess.PROCESS_BALLOT:
				map.put("processName", "开票申请");
				// 数据列表页面；
				map.put("dataUrl", "/fee/queryInvoice");
				// 单个数据审批跳转页面；
				map.put("processUrl", "/fee/queryInvoice?flag=1&id=" + dataId);
				processId = "ballot";
				break;
			// 借款申请；
			case IProcess.PROCESS_BORROW:
				map.put("processName", "借款申请");
				// 数据列表页面；
				map.put("dataUrl", "/fee/queryBorrow");
				// 单个数据审批跳转页面；
				map.put("processUrl", "/fee/queryBorrow?flag=1&id=" + dataId);
				processId = "borrow";
				break;
			// 媒介请款；
			case IProcess.PROCESS_MEDIAREFUND:
				map.put("processName", "媒介请款");
				// 数据列表页面；
				map.put("dataUrl", "/fee/queryOutgo");
				// 单个数据审批跳转页面；
				map.put("processUrl", "/fee/queryOutgo?flag=1&id=" + dataId);
				processId = "mediaRefund";
				break;
			// 退款申请；
			case IProcess.PROCESS_REFUND:
				map.put("processName", "退款申请");
				// 数据列表页面；
				map.put("dataUrl", "/fee/queryRefund");
				// 单个数据审批跳转页面；
				map.put("processUrl", "/fee/queryRefund?flag=1&id=" + dataId);
				processId = "refund";
				break;
			// 财务提成；
			case IProcess.PROCESS_ROYALTY:
				map.put("processName", "财务提成");
				// 数据列表页面；
				map.put("dataUrl", "/fee/queryCommission");
				// 单个数据审批跳转页面；
				map.put("processUrl", "/fee/queryCommission?flag=1&id=" + dataId);
				processId = "royalty";
				break;
			// 流程不存在；
			default:
				map.put("processName", "流程不存在");
				break;
			}
			// 提交的数据ID；
			map.put("dataId", dataId);
			// 提交的数据名称，用于跳转链接的显示内容；
			map.put("dataName", dataName);
			// 审批的紧急程度；
			map.put("urgencyLevel", urgencyLevel);
			// 流程提交的时间；
			map.put("processDate", new Date());
			// 数据审批状态，0为审批中，1为已完成；
			map.put("processState", IProcess.PROCESS_HANDLING);
			if (!StringUtils.isEmpty(taskId)) {
				// 确保审批任务还存在；
				TaskQuery taskQuery = taskService.createTaskQuery().taskId(taskId);
				// 上个流程结束发起的待办事项要进行更新；
				if (taskQuery.count() == 1 && taskService.hasVariable(taskId, "itemId")) {
					map.put("itemId", taskService.getVariable(taskId, "itemId", Integer.class));
					// 结束老的流程；
					managementService.executeCommand(new JumpTaskCommand(taskId, "endEvent"));
					// 删除驳回前的任务；
					managementService.executeCommand(new DeleteHistoryTaskCommand(taskId));
				} else {
					// 当前运行流程未找到则去查询历史记录；
					HistoricTaskInstance historicTaskInstance = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
					if (historicTaskInstance != null) {
						HistoricVariableInstance variableInstance = historyService.createHistoricVariableInstanceQuery().processInstanceId(historicTaskInstance.getProcessInstanceId()).variableName("itemId").singleResult();
						if (variableInstance != null) {
							// 获取原有的待办事项ID，更新到数据集合中，最终将在更新数据提交后保存到数据库，并会更新对应的待办事项状态；
							map.put("itemId", Integer.parseInt(variableInstance.getValue().toString()));
						}
					}
				}
			}

			// 流程申请人信息；
			User user = AppUtil.getUser();
			Integer userId = user.getId();
			// 设置流程启动人；
			Authentication.setAuthenticatedUserId(userId.toString());
			// 提交人的用户ID；
			map.put("userId", userId.toString());
			// 提交人用户名称；
			map.put("userName", user.getName());
			// 提交人的部门ID；
			map.put("initiatorDept", user.getDeptId());
			// 提交人的部门名称；
			map.put("initiatorDeptName", user.getDeptName());
			// 提交人的用户ID，用于发送信息填充字段；
			map.put("initiatorWorker", userId);

			ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processId, map);
			String processInstanceId = processInstance.getId();
			if (processInstanceId == null) {
				return "操作失败。";
			} else {
				return "操作成功。";
			}
		}
	}

	/**
	 * 检查数据是否已有审批中的流程；
	 * 
	 * @param process：流程类型，定义参考com.byefan.xhoa.utils.IProcess；
	 * @param dataId：需要审批的数据ID；
	 * @return ：true为已存在，false为不存在；
	 */
	private boolean checkDataExsit(int process, String dataId) {
		TaskQuery taskQuery = taskService.createTaskQuery();
		taskQuery = taskQuery.processVariableValueEquals("process", process);
		taskQuery = taskQuery.processVariableValueEquals("dataId", dataId);
		// 审批状态；
		taskQuery = taskQuery.processVariableValueEquals("processState", IProcess.PROCESS_HANDLING);
		long count = taskQuery.count();
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
}