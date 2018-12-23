package com.byefan.xhoa.flow.listener;

import org.flowable.task.service.delegate.DelegateTask;

import com.byefan.xhoa.utils.IConst;

/**
 * 会计审核的监听服务；
 * 
 * @Author ：Yuan；
 * @Date ：2018/12/8 0008 15:56；
 */
public class BursarTaskHandler extends CommonTaskHandler {
	/**
	 * 根据流程类型获取对应流程需要更新的审批状态；
	 *
	 * @param delegateTask：任务对象，用于更新流程审批人；
	 */
	@Override
	public void handleApproveData(DelegateTask delegateTask) {
		boolean agree = delegateTask.getVariable("agree", Boolean.class);
		int state;
		if (agree) {
			state = IConst.STATE_KJ;
		} else {
			state = IConst.STATE_REJECT;
		}

		// 更新到数据库中；
		delegateTask.setVariable("state", state);
		// 设置审批人；
		setApproveUser(delegateTask);
	}
}