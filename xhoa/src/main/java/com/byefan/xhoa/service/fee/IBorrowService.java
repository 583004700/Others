package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.fee.Borrow;
import com.byefan.xhoa.entity.sys.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IBorrowService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    PageInfo<Map> listPgForOutgo(int pageNum, int pageSize, Map map);

    Borrow getById(Integer id) ;

    Borrow add(Borrow entity);

    Borrow edit(Borrow entity);

    Borrow delById(Integer id);

    List<Borrow> queryByOutgoId(Integer outgoId);

    List<Map> queryByOutgoId2(Integer outgoId);
}
