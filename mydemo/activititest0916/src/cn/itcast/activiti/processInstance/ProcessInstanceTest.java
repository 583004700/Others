package cn.itcast.activiti.processInstance;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * 流程实例
 */
public class ProcessInstanceTest {
    //流程引擎对象
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    // 部署流程定义
    @Test
    public void deployProcess() {

        // 使用RespositoryService
        RepositoryService repositoryService = processEngine
                .getRepositoryService();

        // 部署bpmn文件和png文件
        // bpmn文件名
        String resourceName_bpmn = "purchasingflow01.bpmn";
        InputStream inputStream_bpmn = this.getClass().getClassLoader()
                .getResourceAsStream("diagram/purchasingflow01.bpmn");

        String resourceName_png = "purchasingflow01.png";
        InputStream inputStream_png = this.getClass().getClassLoader()
                .getResourceAsStream("diagram/purchasingflow01.png");

        // 部署对象
        Deployment deployment = repositoryService.createDeployment()
                .addInputStream(resourceName_bpmn, inputStream_bpmn)// 部署bpmn文件
                .addInputStream(resourceName_png, inputStream_png)// 部署png文件
                .name("采购流程部署")// 名字一般不设置
                .deploy();

        // 部署对象id
        System.out.println("部署id：" + deployment.getId());

        System.out.println("部署时间：" + deployment.getDeploymentTime());
    }


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

    //启动流程实例时设置businessKey
    @Test
    public void startProcessInstanceSetBusiness(){
        //得到runtimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //根据流程定义的key(标识)来启动一个实例，activiti找到该key下版本最高的流程定义
        //一般情况下为了方便开发使用该方法来启动一个流程实例
        String processDefinitionKey = "purchasingflow";

        //业务标识，如果是采购单流程则是采购单ID
        String businessKey = "001";
        //启动时指定业务标识
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey,businessKey);

        //根据流程定义的id来启动一个实例，这种方法一般不用
        //runtimeService.startProcessInstanceByKey(processDefinitionId);
        System.out.println("流程实例所属的流程定义id:"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例的id:"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例的执行id:"+processInstance.getId());
        System.out.println("流程当前的活动（结点）id:"+processInstance.getActivityId());
        System.out.println("业务标识:"+processInstance.getBusinessKey());
//        System.out.println("流程变量:"+processInstance.getProcessVariables());
    }

    //查询当前运行的流程实例
    @Test
    public void queryProcessInstance(){
        RuntimeService runtimeService = processEngine.getRuntimeService();

        //创建查询对象
        ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();

        //设置查询条件
        String processDefinitionKey = "purchasingflow";
        //指定流程定义的key只查询该类流程的实例，比如key为采购流程，只查询采购流程实例
        processInstanceQuery.processDefinitionKey(processDefinitionKey);
        List<ProcessInstance> list = processInstanceQuery.list();

        for(ProcessInstance processInstance:list){
            System.out.println("流程实例所属的流程定义id:"+processInstance.getProcessDefinitionId());
            System.out.println("流程实例的id:"+processInstance.getProcessDefinitionId());
            System.out.println("流程实例的执行id:"+processInstance.getId());
            System.out.println("流程当前的活动（结点）id:"+processInstance.getActivityId());
            System.out.println("业务标识:"+processInstance.getBusinessKey());

            //比如KEY为采购流程，这个key就是采购单id
            String businessKey = processInstance.getBusinessKey();

            //调用service接口查询业务相关的信息
        }

    }
}
