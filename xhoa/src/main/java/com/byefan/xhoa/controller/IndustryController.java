package com.byefan.xhoa.controller;

import com.byefan.xhoa.entity.media.Industry;
import com.byefan.xhoa.service.IIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("industry")
public class IndustryController {

    @Autowired
    IIndustryService industryService;

    @GetMapping("list")
    @ResponseBody
    public List<Industry> list(Industry industry) {
        return industryService.list(industry);
    }
}
