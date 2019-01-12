package scriptManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import scriptManager.entity.User;
import scriptManager.service.IDynamicQueryService;
import scriptManager.util.EasyUIPage;

import java.util.Map;

@Controller
@RequestMapping("/dynamicQuery")
public class DynamicQueryController {
    @Autowired
    IDynamicQueryService dynamicQueryService;

    /**
     * 执行语句，返回查询结果
     * @param easyUIPage
     * @param map
     * @param dataSourceKey
     * @return
     */
    @RequestMapping("/queryList")
    @ResponseBody
    public EasyUIPage.ResponseParam<Map> queryList(EasyUIPage<Map> easyUIPage, @RequestParam Map map,String dataSourceKey){
        easyUIPage.startPage();
        return easyUIPage.getResult(dynamicQueryService.queryList(map,dataSourceKey));
    }


    @RequestMapping("/list")
    public String list(EasyUIPage<User> easyUIPage){
        return "/dynamicQuery/list";
    }
}
