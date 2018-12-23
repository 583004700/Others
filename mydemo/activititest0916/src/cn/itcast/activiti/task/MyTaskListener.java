package cn.itcast.activiti.task;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 监听器
 */
public class MyTaskListener implements TaskListener{
    /**
     *
     * @param delegateTask 任务代理对象
     */
    @Override
    public void notify(DelegateTask delegateTask) {
        //任务办理人，一般要从session中取出当前用户id
        String assignee = "zhangsanfeng";
        //通过任务代理对象操作任务
        //设置任务的办理人
        delegateTask.setAssignee(assignee);
    }
}
