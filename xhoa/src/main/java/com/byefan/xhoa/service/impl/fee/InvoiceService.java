package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Invoice;
import com.byefan.xhoa.entity.sys.AutoNumber;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.biz.ArticleMapper;
import com.byefan.xhoa.mapper.fee.InvoiceMapper;
import com.byefan.xhoa.mapper.sys.AutoNumberMapper;
import com.byefan.xhoa.service.fee.IInvoiceService;
import com.byefan.xhoa.service.impl.flow.ProcessService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.CodeUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper ;
    @Autowired
    private ArticleMapper articleMapper ;
    @Autowired
    private AutoNumberMapper autoNumberMapper ;


    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = invoiceMapper.listPg(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Invoice getById(Integer id) {
        return invoiceMapper.getById(id);
    }

    @Override
    public Invoice add(Invoice entity) {
        invoiceMapper.insert(entity);
        return entity;
    }

    @Override
    public Invoice edit(Invoice entity) {
        invoiceMapper.update(entity);

        return entity;
    }
    @Override
    public Invoice delById(Integer id) {
        Invoice entity = getById(id) ;
        entity.setState(IConst.STATE_DELETE);
//        entity.setUpdateUserId(id);
        invoiceMapper.update(entity);
        return entity;
    }

    @Override
    public PageInfo<Map> listPgForSelectArticle(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = invoiceMapper.listPgForSelectArticle(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    /**
     * 选择需要开票的供应商，存入关系表，并更改稿件开票状态为2，开票状态默认0，提交开票申请为2，已开票为1
     * @param map
     * @return
     */
    @Override
    @Transactional
    public synchronized Invoice saveStepOne(Map map) {
        Integer custCompanyId = Integer.parseInt((String)map.get("custCompanyIdSec")) ;
        String custCompanyName = (String)map.get("custCompanyNameSec");
        Integer custId = Integer.parseInt((String)map.get("custIdSec")) ;
        String custName = (String)map.get("custNameSec");
        String articleIds = (String)map.get("articleIdsSec");
        User user = AppUtil.getUser() ;
        Invoice entity = new Invoice() ;
        entity.setCustCompanyId(custCompanyId);
        entity.setCustCompanyName(custCompanyName);
        entity.setCustId(custId);
        entity.setCustName(custName);
        entity.setApplyId(user.getId());
        entity.setApplyName(user.getName());
        entity.setDeptId(user.getDeptId());
        entity.setDeptName(user.getDeptName());
        entity.setApplyTime(new Date());
        //从code表取数据
        Integer max = autoNumberMapper.getMaxCode(IConst.INVOICE_CODE, CodeUtil.getYear(), CodeUtil.getMonth()) ;
        if(max==null){
            max=1 ;
        }else{
            max = max+1 ;
        }
        //生成KP2018110001的编号，前六位是年月，后四位累加
        entity.setCode(IConst.INVOICE_CODE+ CodeUtil.getMonthStr()+ CodeUtil.getFourCode(max,4)) ;
        invoiceMapper.insert2(entity) ;
        //更新autoNumber表
        AutoNumber number = new AutoNumber() ;
        number.setCode(IConst.INVOICE_CODE);
        number.setYear(CodeUtil.getYear());
        number.setMonth(CodeUtil.getMonth());
        number.setValue(max);
        autoNumberMapper.insert2(number) ;
        //更新关系表
        insertInvoiceArticle(entity.getId(),articleIds) ;
        return entity ;
    }
    public void insertInvoiceArticle(Integer supplierId, String articleIds) {
        if(articleIds.indexOf(",")>-1){
            String[] ids = articleIds.split(",") ;
            //放入set排重
            Set<Integer> set = new HashSet();
            for(int i=0;i<ids.length;i++){
                set.add(Integer.parseInt(ids[i]));
            }
            Iterator<Integer> iterator =set.iterator() ;
            while(iterator.hasNext()){
                Integer articleId = iterator.next() ;
                Article article = articleMapper.get(Article.class,articleId) ;
                article.setInvoiceStates(2);//2已提交
                articleMapper.update(article);
                invoiceMapper.insertInvoiceArticle(supplierId,articleId);
            }
        }else{
            Integer id = Integer.parseInt(articleIds) ;
            invoiceMapper.insertInvoiceArticle(supplierId,id);
        }
    }
    @Override
    public void delInvoiceArticle(Integer invoiceId) {
        invoiceMapper.delInvoiceArticle(invoiceId);
        return ;
    }
    @Override
    public void changeInvoiceStates(Integer invoiceId,Integer state) {
        List<Article> list = invoiceMapper.queryArticleById(invoiceId) ;
        for(Article article:list){
            article.setInvoiceStates(state);
            articleMapper.update(article);
        }
        return ;
    }
    @Override
    public PageInfo<Map> listPgForSelectedArticle(int pageNum, int pageSize, Integer id) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = invoiceMapper.listPgForSelectedArticle(id);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Double getSumAmountById(Integer id) {
        return invoiceMapper.getSumAmountById(id);
    }

}
