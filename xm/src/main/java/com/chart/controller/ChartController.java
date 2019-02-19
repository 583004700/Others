package com.chart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {

    @RequestMapping("/index")
    public String index(){
        return "/chart/index";
    }
}
