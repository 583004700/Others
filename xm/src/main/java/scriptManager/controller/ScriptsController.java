package scriptManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import scriptManager.common.ResponseData;
import scriptManager.entity.Scripts;
import scriptManager.entity.User;
import scriptManager.service.IScriptsService;
import scriptManager.util.EasyUIPage;

import java.util.Map;

@Controller
@RequestMapping("/scripts")
public class ScriptsController {
    @Autowired
    IScriptsService scriptsService;

    /**
     * 查询脚本列表
     * @param easyUIPage
     * @param map
     * @return
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public EasyUIPage.ResponseParam<Map> queryList(EasyUIPage<Map> easyUIPage, @RequestParam Map map){
        //动态设置数据源
        //ThreadDataSourceManager.set(DataSourceMap.dataSource1);
        easyUIPage.startPage();
        return easyUIPage.getResult(scriptsService.queryList(map));
    }

    @RequestMapping("/addScripts")
    @ResponseBody
    public ResponseData addScripts(Scripts scripts){
        ResponseData responseData = null;
        try{
            scriptsService.addScripts(scripts);
            responseData = ResponseData.getOk();
        }catch (Exception e){
            responseData = ResponseData.getError();
        }
        return responseData;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseData update(Scripts scripts){
        ResponseData responseData = null;
        try{
            scriptsService.update(scripts);
            responseData = ResponseData.getOk();
        }catch (Exception e){
            responseData = ResponseData.getError();
        }
        return responseData;
    }

    @RequestMapping("/list")
    public String list(EasyUIPage<User> easyUIPage){
        return "/scripts/list";
    }
}
