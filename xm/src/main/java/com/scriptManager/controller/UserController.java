package com.scriptManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.scriptManager.common.Const;
import com.scriptManager.entity.User;
import com.scriptManager.service.IUserService;
import com.common.util.ContextUtil;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/loginAction")
    public String loginAction(@RequestParam Map map){
        User user = userService.queryOne(map);
        if(user != null){
            ContextUtil.getSession().setAttribute(Const.USER_KEY,user);
            return "redirect:"+Const.INDEX;
        }
        return "redirect:"+Const.LOGIN_PAGE;
    }


    @RequestMapping("/login")
    public String login() {
        return Const.LOGIN_PAGE;
    }
}
