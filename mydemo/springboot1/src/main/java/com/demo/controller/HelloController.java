package com.demo.controller;

import com.demo.pojo.WxMessage;
import com.demo.service.HelloService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;
    @RequestMapping("hello/hello")
    @ResponseBody
    public String hello(){
        try {
            helloService.add();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "hello world";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    //@Cacheable(value = "WxMessage", key = "'WxMessage'.concat(#pageNum).concat(#pageSize.toString())")
    public List<WxMessage> getAll(@RequestParam int pageNum, @RequestParam int pageSize,HttpServletRequest request){
        System.out.println(request.getParameter("pageNum"));
        PageHelper.startPage(pageNum, pageSize);
        return helloService.getAll();
    }

    @RequestMapping("/get")
    @ResponseBody
    public WxMessage get(@RequestParam int id){
        System.out.println(0);
        return helloService.get(id);
    }

    @RequestMapping("/postTest")
    @ResponseBody
    public String postTest(/*@RequestParam String hello*/@RequestBody String hello){
        System.out.println(hello);
        return "postTest";
    }
}
