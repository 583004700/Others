package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.fee.Reimburse;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface IReimburseService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    Reimburse getById(Integer id) ;


    Reimburse add(Reimburse entity, Integer id);

    Reimburse edit(Reimburse entity, Integer id);

    Reimburse delById(Integer id);
}
