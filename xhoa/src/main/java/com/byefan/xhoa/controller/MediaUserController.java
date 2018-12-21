package com.byefan.xhoa.controller;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.mediauser.IMediaUserService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/mediauser")
public class MediaUserController {
    @Autowired
    IMediaUserService mediaUserService;

    @Verify(code = "/mediauser/list", module = "媒介管理/稿件查询")
    @RequestMapping("/list")
    @ResponseBody
    public PageInfo<Map<String,Object>> list(@RequestParam Map param, @PageableDefault(size = 10) Pageable pageable) {
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(mediaUserService.listPg(param,pageable.getPageNumber(),pageable.getPageSize()));
        return pageInfo;
    }

    @Verify(code = "/mediauser/turnDown", module = "媒介管理/稿件驳回")
    @RequestMapping("/turnDown")
    @ResponseBody
    public ResponseData turnDown(Article article){
        try{
            mediaUserService.turnDown(article);
            return ResponseData.ok();
        }catch (Exception e){
            log.error("稿件驳回异常",e);
            return ResponseData.customerError(1001,e.getMessage());
        }
    }

    @Verify(code = "/mediauser/arrange", module = "媒介管理/稿件安排")
    @RequestMapping("/arrange")
    @ResponseBody
    public ResponseData arrange(Article article){
        try{
            mediaUserService.arrange(article);
            return ResponseData.ok();
        }catch (Exception e){
            log.error("稿件安排异常",e);
            return ResponseData.customerError(1001,e.getMessage());
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
    }

    @Verify(code = "/mediauser/publish", module = "媒介管理/发布稿件")
    @RequestMapping("/publish")
    @ResponseBody
    public ResponseData publish(@RequestParam Map map, @RequestParam(value = "updatePrice",required = false) Integer updatePrice, HttpSession session){
        try{
            User user = (User)session.getAttribute(IConst.USER_KEY) ;
            mediaUserService.publish(map,updatePrice);
            return ResponseData.ok();
        }catch (Exception e){
            log.error("稿件发布异常",e);
            return ResponseData.customerError(1001,e.getMessage());
        }
    }

    @Verify(code = "/mediauser/yj", module = "媒介管理/移交稿件")
    @RequestMapping("/yj")
    @ResponseBody
    public ResponseData yj(@RequestParam("artId") String artId,@RequestParam("mediaUserId") String mediaUserId){
        try{
            mediaUserService.yj(artId,mediaUserId);
            return ResponseData.ok();
        }catch (Exception e){
            log.error("稿件移交异常",e);
            return ResponseData.customerError(1001,e.getMessage());
        }
    }

    @RequestMapping("/priceFloat")
    @ResponseBody
    public ResponseData priceFloat(Article article){
        try{
            boolean b = mediaUserService.priceFloat(article);
            ResponseData responseData = ResponseData.ok();
            responseData.putDataValue("b",b);
            return responseData;
        }catch (Exception e){
            log.error("获取价格浮动异常",e);
            return ResponseData.customerError(1001,e.getMessage());
        }
    }
}
