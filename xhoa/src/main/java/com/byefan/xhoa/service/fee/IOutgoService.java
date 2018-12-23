package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.fee.Outgo;
import com.byefan.xhoa.entity.fee.OutgoBorrow;
import com.byefan.xhoa.entity.sys.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IOutgoService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    Outgo getById(Integer id) ;


    void updateEntity(Outgo entity);

    Outgo add(Outgo entity);

    Outgo edit(Outgo entity);

    Outgo delById(Integer id);

    Outgo saveStepOne(Map map, User user);

    PageInfo<Map> listPgForSelectedArticle(int pageNum, int pageSize, Integer id);

    PageInfo<Map> listPgForSelectArticle(int pageNum, int pageSize, Map map);

    void changeOutgoStates(Integer outgoId, Integer state);

    void deleteByOutgoId(Integer outgoId);

    void insertOutgoBorrrow (OutgoBorrow outgoBorrow);

    List<OutgoBorrow> queryByOutgoId(Integer outgoId);

    List<OutgoBorrow> queryByBorrowId(Integer borrowId);

    List<Map> queryBorrowById(Integer outgoId);

    OutgoBorrow getByOutgoIdAndBorrowId(Integer outgoId, Integer borrowId);

    Double getSumAmountById(Integer outgoId);
}
