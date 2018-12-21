package com.byefan.xhoa.flow.listener;

import org.flowable.task.service.delegate.DelegateTask;

import com.byefan.xhoa.utils.IConst;

/**
 * 部门直属领导的审批监听服务；
 * 
 * @Author ：Yuan；
 * @Date ：2018/12/7 0007 9:50；
 */
public class LeaderTaskHandler extends CommonTaskHandler {
	/**
	 * 根据流程类型获取对应流程需要更新的审批状态；
	 *
	 * @param delegateTask：任务对象，用于更新流程审批人；
	 */
	@Override
	public void handleApproveData(DelegateTask delegateTask) {
		// 开始节点，默认是通过；
		boolean agree = true;
		if (delegateTask.hasVariable("agree")) {
			agree = delegateTask.getVariable("agree", Boolean.class);
		}
		int state;
		if (agree) {
			state = IConst.STATE_BZ;
		} else {
			state = IConst.STATE_REJECT;
		}

		// 更新到数据库中；
		delegateTask.setVariable("state", state);
		// 设置审批人；
		setApproveUser(delegateTask);
	}
}