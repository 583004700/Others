package cn.itcast.purchasing.vo;

import cn.itcast.purchasing.po.PurBusOrder;

/**
 * 采购单信息扩展对象,采购单信息和activiti信息
 */
public class OrderCustom extends PurBusOrder{
    //任务ID
    private String taskId;

    //任务名称
    private String taskName;

    //任务标识
    private String taskDefinitionKey;

    // 负责人
    private String assignee;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
}
