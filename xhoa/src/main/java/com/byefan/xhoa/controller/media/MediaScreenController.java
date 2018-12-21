package com.byefan.xhoa.controller.media;

import com.byefan.xhoa.entity.media.MediaScreen;
import com.byefan.xhoa.service.media.IMediaScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mediaScreen")
public class MediaScreenController {

    @Autowired
    IMediaScreenService mediaScreenService;

    @GetMapping("all")
    @ResponseBody
    public List<MediaScreen> all() {
        return mediaScreenService.all();
    }

    @GetMapping("list")
    @ResponseBody
    public List<MediaScreen> list(MediaScreen mediaScreen) {
        return mediaScreenService.list(mediaScreen);

    }
    @GetMapping("listByMediaTypeId/{mediaTypeId}")
    @ResponseBody
    public List<MediaScreen> listByMediaTypeId(@PathVariable("mediaTypeId") Integer mediaTypeId) {
        return mediaScreenService.listByMediaTypeId(mediaTypeId);
    }
}
