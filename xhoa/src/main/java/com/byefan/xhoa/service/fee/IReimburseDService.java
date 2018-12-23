package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.fee.ReimburseD;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface IReimburseDService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    ReimburseD getById(Integer id) ;


    ReimburseD add(ReimburseD entity, Integer id);

    ReimburseD edit(ReimburseD entity, Integer id);

    ReimburseD delById(Integer id);
}
