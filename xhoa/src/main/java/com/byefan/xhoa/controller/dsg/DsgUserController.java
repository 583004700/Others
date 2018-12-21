package com.byefan.xhoa.controller.dsg;

import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.dsg.DsgUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/rt")
public class DsgUserController {
    @Autowired
    DsgUserService dsgUserService;
    @RequestMapping("/jdk")
    @ResponseBody
    public List<User> ts(){
        return dsgUserService.tt();
    }
    @RequestMapping("/jy")
    @ResponseBody
    public String kk(){
        try{
            dsgUserService.dd();
            return "添加成功";
        }catch (Exception e){
            return "添加失败";
        }
    }
}
