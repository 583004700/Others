package com.byefan.xhoa.controller;

import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.sys.Resource;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.sys.IResourceService;
import com.byefan.xhoa.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 默认页
 */
@Controller
public class IndexController {

    @Autowired
    IResourceService resourceService;

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv) {
//        mv.addObject("AppName", APP_NAME);
        User user = AppUtil.getUser();
        Integer id = user.getId();
        if ("超级管理员".equals(user.getName()) && "admin".equals(user.getUserName()))
            id = -1;
        List<Resource> menus = resourceService.queryResourceByUserId(id);
        mv.addObject("menus", menus);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/csrf")
    public ModelAndView csrf(ModelAndView mv) {
//        mv.addObject("AppName", APP_NAME);
        mv.setViewName("index");
        return mv;
    }

    /**
     * 注销
     *
     * @param session
     * @return
     */
    @GetMapping("/logout")
    @Log(opType = OperateType.DELETE, module = "系统管理/用户注销，退出登录", note = "用户注销，退出登录")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
//        return "login";
    }

}
