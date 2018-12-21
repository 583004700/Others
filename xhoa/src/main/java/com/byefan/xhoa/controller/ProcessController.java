package com.byefan.xhoa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.Execution;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.byefan.core.ResponseData;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.fee.Invoice;
import com.byefan.xhoa.service.flow.IProcessService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;

/**
 * 流程测试；
 * 
 * @Author ：Yuan；
 * @Date ：2018/12/7 0007 16:24；
 */
@Controller
@RequestMapping(value = "process")
public class ProcessController {
	// 获取流程接口；
	@Autowired
	private IProcessService processService;
	// 运行服务接口；
	@Autowired
	private RuntimeService runtimeService;
	// 任务接口；
	@Autowired
	private TaskService taskService;
	// 存储库接口；
	@Autowired
	private RepositoryService repositoryService;
	// 流程引擎；
	@Autowired
	private ProcessEngine processEngine;

	/**
	 * 开票申请的流程启动；
	 * 
	 * @param invoiceId：开票申请的ID；
	 * @param urgencyLevel：申请的紧急程度；
	 * @return ：操作完成的提示信息；
	 */
	@RequestMapping(value = "add")
	@ApiOperation(value = "新增开票流程", notes = "启动开票流程")
	@Log(opType = OperateType.ADD, module = "流程管理", note = "启动开票流程")
	@ResponseBody
	public ResponseData addBallotProcess(int invoiceId, String taskId, int urgencyLevel) {
		ResponseData data = ResponseData.ok();
		Invoice invoice = new Invoice();
		invoice.setId(invoiceId);
		invoice.setTaskId(taskId);
		invoice.setTitle("测试");
		data.putDataValue("message", processService.addBallotProcess(invoice, urgencyLevel));
		return data;
	}

	/**
	 * 开票流程的审批；
	 * 
	 * @param taskIds：需要审批的任务ID；
	 * @param desc：审批备注信息；
	 * @return ：操作完成的提示信息；
	 */
	@RequestMapping(value = "apply")
	@ApiOperation(value = "流程审批", notes = "流程审批操作")
	@Log(opType = OperateType.UPDATE, module = "流程管理", note = "流程审批")
	@ResponseBody
	public ResponseData applyBallotProcesses(@RequestParam String[] taskIds, String desc, boolean agree) {
		ResponseData data = ResponseData.ok();
		data.putDataValue("message", processService.approveProcess(taskIds, desc, agree));
		return data;
	}

	/**
	 * 获取待办的审批任务列表；
	 *
	 * @return ：当前登录人待审批任务集合；
	 */
	@RequestMapping(value = "list")
	@ApiOperation(value = "获取待审批任务", notes = "获取待审批任务列表")
	@Log(opType = OperateType.QUERY, module = "流程管理", note = "审批任务")
	@ResponseBody
	public PageInfo<Map<String, Object>> listTasks(Integer page, Integer size, @RequestParam Map map) {
		return processService.listTasks(map, page, size);
	}

	/**
	 * 获取流程的审批记录；
	 *
	 * @param dataId：审批的数据ID；
	 * @param process：流程标志，定义参考com.byefan.xhoa.utils.IProcess；
	 * @return ：操作完成的提示信息；
	 */
	@RequestMapping(value = "history")
	@ApiOperation(value = "获取流程审批记录", notes = "获取流程审批记录")
	@Log(opType = OperateType.QUERY, module = "流程管理", note = "审批记录")
	@ResponseBody
	public ResponseData listTaskHistory(String dataId, Integer process) {
		ResponseData data = ResponseData.ok();
		if (StringUtils.isEmpty(dataId) || process == null) {
			data.putDataValue("message", "数据ID和流程标识不能为空。");
		} else {
			data.putDataValue("data", processService.listTaskHistory(dataId, process));
		}
		return data;
	}

	/**
	 * 获取流程图；
	 * 
	 * @param response：响应对象；
	 * @param taskId：任务ID；
	 */
	@RequestMapping(value = "image")
	@ApiOperation(value = "获取流程线路图", notes = "获取流程线路图")
	@Log(opType = OperateType.QUERY, module = "流程管理", note = "流程线路")
	public void getProcessImage(HttpServletResponse response, String taskId) throws IOException {
		// 获取任务对象；
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// 获取执行对象集合；
		List<Execution> executions = runtimeService.createExecutionQuery().processInstanceId(task.getProcessInstanceId()).list();
		// 获取执行中的任务ID集合；
		List<String> activityIds = new ArrayList<>();
		for (Execution execution : executions) {
			activityIds.addAll(runtimeService.getActiveActivityIds(execution.getId()));
		}

		ProcessDiagramGenerator diagramGenerator = processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator();
		BpmnModel bpmnModel = repositoryService.getBpmnModel(task.getProcessDefinitionId());
		InputStream in = diagramGenerator.generateDiagram(bpmnModel, "PNG", activityIds, new ArrayList<>(), "宋体", "宋体", "宋体", null, 1.0, true);
		OutputStream out = null;
		try {
			int length = 0;
			byte[] buf = new byte[1024];
			out = response.getOutputStream();
			while ((length = in.read(buf)) != -1) {
				out.write(buf, 0, length);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}