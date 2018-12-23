package com.byefan.xhoa.controller.media;

import com.byefan.xhoa.entity.media.MediaName;
import com.byefan.xhoa.service.media.IMediaNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mediaName")
public class MediaNameController {

    @Autowired
    IMediaNameService mediaNameService;

    @GetMapping("all")
    @ResponseBody
    public List<MediaName> all() {
        return mediaNameService.all();
    }

    @GetMapping("list")
    @ResponseBody
    public List<MediaName> list(MediaName mediaName) {
        return mediaNameService.list(mediaName);
    }
}
