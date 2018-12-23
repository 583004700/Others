package cn.itcast.activiti.task;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

import java.util.List;

/**
 * 个人任务测试类
 */
public class TaskTest {
    //流程引擎对象
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    //启动流程实例
    @Test
    public void startProcessInstance(){
        //得到runtimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //根据流程定义的key(标识)来启动一个实例，activiti找到该key下版本最高的流程定义
        //一般情况下为了方便开发使用该方法来启动一个流程实例
        String processDefinitionKey = "purchasingflow";
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);

        //根据流程定义的id来启动一个实例，这种方法一般不用
        //runtimeService.startProcessInstanceByKey(processDefinitionId);
        System.out.println("流程实例所属的流程定义id:"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例的id:"+processInstance.getProcessInstanceId());
        System.out.println("流程实例的执行id:"+processInstance.getId());
        System.out.println("流程当前的活动（结点）id:"+processInstance.getActivityId());
        System.out.println("业务标识:"+processInstance.getBusinessKey());
//        System.out.println("流程变量:"+processInstance.getProcessVariables());
    }

    // 待办任务
    // 查询当前 用户的待办任务
    @Test
    public void findPersonalTaskList() {

        RuntimeService runtimeService = processEngine.getRuntimeService();


        // 查询任务使用TaskService
        TaskService takService = processEngine.getTaskService();
        // 流程定义key（流程定义的标识 ）
        String processDefinitionKey = "purchasingflow";// 采购流程 标识
        // 任务 负责人
        String assignee = "zhangsanfeng";
        // 创建查询对象
        TaskQuery taskQuery = takService.createTaskQuery();

        // 设置查询条件
        taskQuery.taskAssignee(assignee);

        // 指定 流程定义key，只查询某个流程的任务
        taskQuery.processDefinitionKey(processDefinitionKey);

        // 获取查询列表
        List<Task> list = taskQuery.list();

        for (Task task : list) {
            System.out.println("流程实例的id:"+task.getProcessInstanceId());
            System.out.println("任务 id：" + task.getId());
            System.out.println("任务标识:"+task.getTaskDefinitionKey());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
            System.out.println("任务的创建时间:" + task.getCreateTime());

            //流程实例id
            String processInstanceId = task.getProcessInstanceId();
            //根据实例id找到流程实例对象
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

            //从流程实例对象中获取businessKey
            String businessKey = processInstance.getBusinessKey();
        }

    }

    // 办理任务
    @Test
    public void completeTask() {

        // 查询任务使用TaskService
        TaskService taskService = processEngine.getTaskService();
        //任务id
        String taskId = "4302";
        taskService.complete(taskId);

        String taskAssignee = "";
        Task task = taskService.createTaskQuery().taskId(taskId).taskAssignee(taskAssignee).singleResult();

        //if(task != null){
            //说明assignee是该任务办理人，有权限完成任务
            System.out.println("完成任务：" + taskId);
        //}

    }
}
