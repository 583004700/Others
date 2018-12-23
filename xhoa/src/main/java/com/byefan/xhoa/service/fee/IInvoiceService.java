package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.fee.Invoice;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface IInvoiceService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    Invoice getById(Integer id) ;


    Invoice add(Invoice entity);

    Invoice edit(Invoice entity);

    Invoice delById(Integer id);

    PageInfo<Map> listPgForSelectArticle(int pageNum, int pageSize, Map map);

    void delInvoiceArticle(Integer invoiceId);

    void changeInvoiceStates(Integer invoiceId,Integer state);

    PageInfo<Map> listPgForSelectedArticle(int pageNum, int pageSize, Integer id);

    Invoice saveStepOne(Map map);

    Double getSumAmountById(Integer id);
}
