package com.byefan.xhoa.controller.media;

import com.byefan.xhoa.entity.media.MediaTerm;
import com.byefan.xhoa.service.media.IMediaTermService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mediaTerm")
@Api(description = "媒体管理接口")
public class MediaTermController {
    @Autowired
    IMediaTermService mediaTermService;

    @GetMapping("/{typeId}")
    @ResponseBody
    public List<MediaTerm> list(@PathVariable("typeId") Integer typeId) {
        return mediaTermService.list(typeId);
    }

    @GetMapping("/get")
    @ResponseBody
    public MediaTerm get(MediaTerm mediaTerm) {
        return mediaTermService.getByTerm(mediaTerm);
    }
}
