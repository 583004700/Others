package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Income;
import com.byefan.xhoa.entity.fee.IncomeUser;
import com.byefan.xhoa.entity.sys.User;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IIncomeService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    Income getById(Integer id) ;


    Income add(Income entity);

    Income edit(Income entity);

    Income delById(Integer id);

    Income receiveIncome(Integer id,Double amount, User opUser);

    void returnIncome(Integer id,Double receiveAmount,List<IncomeUser> list);

    PageInfo<Map> queryArticleForAssign(int pageNum, int pageSize, Map map);

    void assignIncome(Map map,User user);

    PageInfo<Map> listPgForSelectedArticle(int pageNum, int pageSize, Integer id);

    PageInfo<Map> listPgForAssign(int pageNum, int pageSize, Map map);

    IncomeUser getIncomeUser(Integer incomeId, Integer userId);

    List<Map> listPgByArticleId(Article article);

    List<Income> queryIncomeByAccountId(Integer accountId);

    List<IncomeUser> queryIncomeUserByIncomeId(Integer incomeId);

    List<IncomeUser> queryIncomeUserByIncomeIdAndUserId(Integer incomeId, Integer userId);

    Map querySumAmount(Integer incomeId, Integer userId);
}
