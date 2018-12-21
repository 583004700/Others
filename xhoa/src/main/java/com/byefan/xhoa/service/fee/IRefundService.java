package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.fee.Refund;
import com.byefan.xhoa.entity.sys.User;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface IRefundService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    Refund getById(Integer id) ;


    Refund add(Refund entity, User opUser);

    Refund edit(Refund entity,Integer userId);

    Refund delById(Integer id,User opUser);

    PageInfo<Map> listPgForSelectArticle(int pageNum, int pageSize, Map map);

    Refund saveStepOne(Map map);

    void delRefundArticle(Integer refundId);

    void changeRefundStates(Integer refundId, Integer state);

    PageInfo<Map> listPgForSelectedArticle(int pageNum, int pageSize, Integer id);

    Map querySumAmountById(Integer refundId);

    void reutrnCommInfo(Integer refundId);
}
