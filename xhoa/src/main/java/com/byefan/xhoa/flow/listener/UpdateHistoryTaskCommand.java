package com.byefan.xhoa.flow.listener;

import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.util.CommandContextUtil;
import org.flowable.task.service.impl.persistence.entity.HistoricTaskInstanceEntity;

/**
 * Flowable历史记录的描述更新；
 * 
 * @Author ：Yuan；
 * @Date ：2018/12/13 0013 17:09；
 */
public class UpdateHistoryTaskCommand implements Command {
	// 任务ID；
	protected String taskId;
	protected String assignee;
	// 审批人；
	// 描述内容；
	protected String deleteReason;

	public UpdateHistoryTaskCommand(String taskId, String assignee, String deleteReason) {
		this.taskId = taskId;
		this.assignee = assignee;
		this.deleteReason = deleteReason;
	}

	@Override
	public Void execute(CommandContext commandContext) {
		// 获取任务执行对象；
		HistoricTaskInstanceEntity historicTaskInstance = CommandContextUtil.getDbSqlSession().selectById(HistoricTaskInstanceEntity.class, taskId);
		if (historicTaskInstance != null) {
			// 更新内容；
			historicTaskInstance.setAssignee(assignee);
			historicTaskInstance.markEnded(deleteReason);
		}
		return null;
	}
}