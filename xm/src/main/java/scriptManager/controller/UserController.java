package scriptManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import scriptManager.common.Const;
import scriptManager.entity.User;
import scriptManager.service.IUserService;
import scriptManager.util.ContextUtil;

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
