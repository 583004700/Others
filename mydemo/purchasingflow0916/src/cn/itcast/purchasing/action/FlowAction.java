package cn.itcast.purchasing.action;

import cn.itcast.purchasing.util.ResourcesUtil;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * 流程管理
 */
@Controller
@RequestMapping("/flow")
public class FlowAction {
    @Autowired
    private RepositoryService repositoryService;

    //流程定义部署页面
    @RequestMapping("/deployProcess")
    public String deployProcess(Model model) throws Exception{
        return "/flow/deployProcess";
    }

    //流程部署提交
    @RequestMapping("/deployProcessSubmit")
    public String deployProcessSubmit(MultipartFile resource_bpmn,MultipartFile resource_png) throws Exception{
        // 部署bpmn文件和png文件
        // bpmn文件名
        String resourceName_bpmn = resource_bpmn.getOriginalFilename();
        InputStream inputStream_bpmn = resource_bpmn.getInputStream();

        String resourceName_png = resource_png.getOriginalFilename();
        InputStream inputStream_png = resource_png.getInputStream();

        // 部署对象
        Deployment deployment = repositoryService.createDeployment()
                .addInputStream(resourceName_bpmn, inputStream_bpmn)// 部署bpmn文件
                .addInputStream(resourceName_png, inputStream_png)// 部署png文件
                .deploy();

        // 部署对象id
        System.out.println("部署id：" + deployment.getId());

        System.out.println("部署时间：" + deployment.getDeploymentTime());
        return "redirect:/flow/queryProcessDefinition.action";
    }

    //流程定义查询
    @RequestMapping("/queryProcessDefinition")
    public String queryProcessDefinition(Model model) throws Exception{
        // 流程定义的key
        String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow","purchasingProcessDefinitionKey");
        // 创建查询对象
        ProcessDefinitionQuery processDefinitionQuery = repositoryService
                .createProcessDefinitionQuery();

        // 设置查询条件
        // 只查询采购流程的定义
        processDefinitionQuery.processDefinitionKey(processDefinitionKey);

        // 查询列表
        List<ProcessDefinition> list = processDefinitionQuery.list();
        // 分页查询
        // processDefinitionQuery.listPage(firstResult, maxResults)
        // 根据流程定义的id查询一条记录
        // processDefinitionQuery.processDefinitionId(definitionId).singleResult();

        model.addAttribute("list",list);
        return "/flow/queryProcessDefinition";
    }

    //删除流程定义
    @RequestMapping("/deleteProcessDefinition")
    public String deleteProcessDefinition(String processDefinitionId) throws Exception{
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId).singleResult();
        // 流程定义所属部署id
        String deploymentId = processDefinition.getDeploymentId();

        // 级联删除
        repositoryService.deleteDeployment(deploymentId, true);

        return "redirect:/flow/queryProcessDefinition.action";
    }

    @RequestMapping("/queryProcessDefinitionResource")
    public void queryProcessDefinitionResource(HttpServletResponse response, String processDefinitionId, String resourceType) throws Exception{
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId).singleResult();
        //部署id
        String deploymentId = processDefinition.getDeploymentId();

        String resourceName = null;
        InputStream inputStream = null;

        if(resourceType.equals("bpmn")){
            // pbmn文件
            //bpmn资源文件名称
            resourceName = processDefinition.getResourceName();
        }else if(resourceType.equals("png")){
            // png文件
            //png文件名称
            resourceName = processDefinition.getDiagramResourceName();
        }
        inputStream = repositoryService.getResourceAsStream(
                deploymentId, resourceName);

        //流复制

        byte[] b = new byte[1024];

        int len=-1;
        while((len=inputStream.read(b, 0, 1024))!=-1){
            response.getOutputStream().write(b, 0, len);
        }
        inputStream.close();
    }
}
