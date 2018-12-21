package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Refund;
import com.byefan.xhoa.entity.sys.AutoNumber;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.biz.ArticleMapper;
import com.byefan.xhoa.mapper.fee.RefundMapper;
import com.byefan.xhoa.mapper.sys.AutoNumberMapper;
import com.byefan.xhoa.service.fee.ICommissionService;
import com.byefan.xhoa.service.fee.IRefundService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.CodeUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RefundService implements IRefundService {
    @Autowired
    private RefundMapper refundMapper ;
    @Autowired
    private ArticleMapper articleMapper ;
    @Autowired
    private AutoNumberMapper autoNumberMapper ;
    @Autowired
    private ICommissionService commissionService ;

    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = refundMapper.listPg(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Refund getById(Integer id) {
        return refundMapper.getById(id);
    }

    /**
     * saveStepOne退款，该方法暂不用
     * @param entity
     * @param opUser
     * @return
     */
    @Override
    public Refund add(Refund entity, User opUser) {
        //
        entity.setCreateTime(new Date());
        entity.setApplyId(opUser.getId());
        entity.setApplyName(opUser.getName());
        entity.setDeptId(opUser.getDeptId());
        entity.setDeptName(opUser.getDeptName()) ;
        entity.setApplyTime(new Date());
        entity.setCreator(opUser.getId());
        refundMapper.insert(entity);
        return entity;
    }
    @Override
    public Refund edit(Refund entity, Integer userId) {
        entity.setUpdateUserId(userId);
        refundMapper.update(entity);
        return entity;
    }
    @Override
    public Refund delById(Integer id, User opUser) {
        Refund entity = getById(id) ;

        entity.setState(IConst.STATE_DELETE);
        entity.setUpdateUserId(id);
        refundMapper.update(entity);
        return entity;
    }

    @Override
    public PageInfo<Map> listPgForSelectArticle(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = refundMapper.listPgForSelectArticle(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    @Transactional
    public Refund saveStepOne(Map map) {
        User user = AppUtil.getUser() ;
        Integer custCompanyId = Integer.parseInt((String)map.get("custCompanyIdSec")) ;
        String custCompanyName = (String)map.get("custCompanyNameSec");
        Integer custId = Integer.parseInt((String)map.get("custIdSec")) ;
        String custName = (String)map.get("custNameSec");
        String articleIds = (String)map.get("articleIdsSec");
        Refund entity = new Refund() ;
        entity.setApplyId(user.getId());
        entity.setDeptId(user.getDeptId());
        entity.setDeptName(user.getDeptName());
        entity.setApplyName(user.getName());
        entity.setCustCompanyId(custCompanyId);
        entity.setCustCompanyName(custCompanyName);
        entity.setCustId(custId);
        entity.setCustName(custName);
        entity.setCreator(user.getId());
        entity.setCreateTime(new Date());
        //从code表取数据
        Integer max = autoNumberMapper.getMaxCode(IConst.REFUND_CODE, CodeUtil.getYear(), CodeUtil.getMonth()) ;
        if(max==null){
            max=1 ;
        }else{
            max = max+1 ;
        }
        //生成KP2018110001的编号，前六位是年月，后四位累加
        entity.setCode(IConst.REFUND_CODE+ CodeUtil.getMonthStr()+ CodeUtil.getFourCode(max,4)) ;
        refundMapper.insert2(entity) ;
        //更新autoNumber表
        AutoNumber number = new AutoNumber() ;
        number.setCode(IConst.REFUND_CODE);
        number.setYear(CodeUtil.getYear());
        number.setMonth(CodeUtil.getMonth());
        number.setValue(max);
        autoNumberMapper.insert2(number) ;
        //更新关系表
        insertRefundArticle(entity.getId(),articleIds,map,user) ;
        return entity ;
    }
    public void insertRefundArticle(Integer refundId, String articleIds,Map map,User user) {
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
                Double refundAmount = Double.parseDouble((String)map.get("refund_"+articleId)) ;
                Double otherPay = Double.parseDouble((String)map.get("other_"+articleId)) ;
                Article article = articleMapper.get(Article.class,articleId) ;
                if(article.getRefundAmount()==null){
                    article.setRefundAmount(refundAmount);
                }else{
                    article.setRefundAmount(article.getRefundAmount()+refundAmount);
                }
                if(article.getOtherPay()==null){
                    article.setOtherPay(otherPay);
                }else{
                    article.setOtherPay(article.getOtherPay()+otherPay);
                }
                article.setRefundStates(2);
                articleMapper.update(article);
                refundMapper.insertRefundArticle(refundId,articleId);
                //退款时重置这些稿件的提成信息
                commissionService.backCommInfo(article,user);
            }
        }else{
            Integer id = Integer.parseInt(articleIds) ;
            Double refundAmount = Double.parseDouble((String)map.get("refund_"+id)) ;
            Double otherPay = Double.parseDouble((String)map.get("other_"+id)) ;
            Article article = articleMapper.get(Article.class,id) ;
            if(article.getRefundAmount()==null){
                article.setRefundAmount(refundAmount);
            }else{
                article.setRefundAmount(article.getRefundAmount()+refundAmount);
            }
            if(article.getOtherPay()==null){
                article.setOtherPay(otherPay);
            }else{
                article.setOtherPay(article.getOtherPay()+otherPay);
            }
            article.setRefundStates(2);
            articleMapper.update(article);
            refundMapper.insertRefundArticle(refundId,id);
            //退款时重置这些稿件的提成信息
            commissionService.backCommInfo(article,user);
        }
    }
    @Override
    public void delRefundArticle(Integer refundId) {
        refundMapper.delRefundArticle(refundId);
        return ;
    }
    @Override
    public PageInfo<Map> listPgForSelectedArticle(int pageNum, int pageSize, Integer id) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = refundMapper.listPgForSelectedArticle(id);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Map querySumAmountById(Integer refundId) {
        return refundMapper.querySumAmountById(refundId);
    }

    @Override
    public void changeRefundStates(Integer refundId,Integer state) {
        List<Article> list = refundMapper.queryArticleById(refundId) ;
        for(Article article:list){
            article.setRefundStates(state);
            articleMapper.update(article);
        }
        return ;
    }

    /**
     * 删除退款申请和申请通过时 重新计算提成
     * @param refundId
     */
    @Override
    public void reutrnCommInfo(Integer refundId) {
        List<Article> list = refundMapper.queryArticleById(refundId) ;
        for(Article article:list){
            //查询业务员信息
            User user = articleMapper.getUserByArticleId(article.getId()) ;
            commissionService.updateCommInfo(article,user);
        }
        return ;
    }

}
