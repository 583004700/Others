package com.byefan.xhoa.controller;

import com.byefan.xhoa.entity.sys.District;
import com.byefan.xhoa.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("district")
public class DistrictController {

    @Autowired
    IDistrictService districtService;

    @GetMapping("all")
    @ResponseBody
    public List<District> all() {
        return districtService.all();
    }
}
