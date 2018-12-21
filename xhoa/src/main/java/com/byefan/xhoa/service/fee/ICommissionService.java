package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Commission;
import com.byefan.xhoa.entity.sys.User;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface ICommissionService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    Commission getById(Integer id) ;


    Commission add(Commission entity);

    Commission edit(Commission entity);

    void delById(Integer id);

    void backCommInfo(Article article, User user);

    void updateCommInfo(Article article,User user);
}
