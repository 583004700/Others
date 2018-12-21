package com.byefan.xhoa.service.mediauser;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.sys.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface IMediaUserService {
    List<Map<String,Object>> list(Map map);

    List<Map<String,Object>> listPg(Map map,int pageNum,int pageSize);
    //驳回
    void turnDown(@RequestParam Article article);
    //安排
    int arrange(Article article);
    //发布
    int publish(Map map, Integer updatePrice);
    //稿件移交
    int yj(String artId,String mediaUserId);

    boolean priceFloat(Article article);
}
