package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/templates")
public class TemplatesController {

    @RequestMapping("/hello")
    public String hello(Map<String,Object> map){
        map.put("name","张三");
        return "/hello";
    }

    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("name","张三");
        return "/helloFtl";
    }
}
