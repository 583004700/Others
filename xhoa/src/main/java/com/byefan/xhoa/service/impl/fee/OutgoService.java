package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Account;
import com.byefan.xhoa.entity.fee.Outgo;
import com.byefan.xhoa.entity.fee.OutgoBorrow;
import com.byefan.xhoa.entity.sys.AutoNumber;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.biz.ArticleMapper;
import com.byefan.xhoa.mapper.fee.AccountMapper;
import com.byefan.xhoa.mapper.fee.OutgoBorrowMapper;
import com.byefan.xhoa.mapper.fee.OutgoMapper;
import com.byefan.xhoa.mapper.sys.AutoNumberMapper;
import com.byefan.xhoa.service.fee.ICommissionService;
import com.byefan.xhoa.service.fee.IOutgoService;
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
public class OutgoService implements IOutgoService {
    @Autowired
    private OutgoMapper outgoMapper ;
    @Autowired
    private AccountMapper accountMapper ;
    @Autowired
    private AutoNumberMapper autoNumberMapper ;
    @Autowired
    private ArticleMapper articleMapper ;
    @Autowired
    private OutgoBorrowMapper outgoBorrowMapper ;
    @Autowired
    private ICommissionService commissionService ;

    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = outgoMapper.listPg(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Outgo getById(Integer id) {
        return outgoMapper.getById(id);
    }

    @Override
    public void updateEntity(Outgo entity) {
        outgoMapper.update(entity);
        return ;
    }

    @Override
    public Outgo add(Outgo entity) {
        //扣款逻辑，需要状态控制才能执行
        //，付款时往账户表扣除金额，新增时用不到
//        if(entity.getOutAccountId()!=null){
//            Account account = accountMapper.getById(entity.getOutAccountId()) ;
//            Double balance = account.getBalance()-entity.getOutAccountId() ;
//            balance = balance + entity.getPayAmount() ;
//            accountMapper.updateBalance(balance,entity.getOutAccountId()) ;
//        }

//        updateAccountInfo(entity,id) ;
        //维护请款和稿件关系表
        //fee_outgo_article
        //维护稿件请款状态，防止再次提交
        outgoMapper.insert(entity);
        return entity;
    }
    @Override
    public Outgo edit(Outgo entity) {
//        Outgo oldEntity = getById(entity.getId()) ;
        //扣款逻辑，需要状态控制才能执行
//        if(oldEntity.getOutAccountId()!=null){
//            Account oldAccount = accountMapper.getById(oldEntity.getOutAccountId()) ;
//            if(oldEntity.getOutAccountId()==entity.getOutAccountId()){
//                //修改时账户信息不变，只需更改金额
//                Double oldBalance = oldAccount.getBalance() ;
//                Double balance = oldBalance+oldEntity.getPayAmount()-entity.getPayAmount()  ;
//                accountMapper.updateBalance(balance,oldEntity.getOutAccountId()) ;
//            }else{
//                //更改了账户，旧账户钱先还原回去
//                Double oldBalance = oldAccount.getBalance() ;
//                oldBalance = oldBalance+oldEntity.getPayAmount()  ;
//                accountMapper.updateBalance(oldBalance,oldEntity.getOutAccountId()) ;
//                //从新账户扣款
//                Account account = accountMapper.getById(entity.getOutAccountId()) ;
//                Double balance = account.getBalance()-entity.getPayAmount() ;
//                accountMapper.updateBalance(balance,entity.getOutAccountId()) ;
//            }
//        }

//        updateAccountInfo(entity,id) ;
        outgoMapper.update(entity);
        return entity;
    }
//    public void updateAccountInfo(Outgo entity,Integer id){
//        //账户表id为空，往账户表存供应商账户，type=2,不为空则更新供应商账户
//        if(entity.getAccountId()!=null){
//            Account account = accountMapper.getById(entity.getAccountId()) ;
//            account.setName(entity.getAccountName());
//            account.setBankNo(entity.getAccountBankNo());
//            account.setBankName(entity.getAccountBankName());
//            accountMapper.update2(account) ;
//        }else{
//            Account account = new Account() ;
//            account.setType(2);
//            account.setCompanyId(entity.getSupplierId());
//            account.setCompanyName(entity.getSupplierName());
//            account.setName(entity.getAccountName());
//            account.setBankNo(entity.getAccountBankNo());
//            account.setBankName(entity.getAccountBankName());
//            account.setCreator(id);
//            accountMapper.insert2(account) ;
//        }
//    }

    @Override
    @Transactional
    public Outgo delById(Integer id) {
        Outgo entity = getById(id) ;
        //账户里的钱还回去
//        if(entity.getOutAccountId()!=null){
//            Account account = accountMapper.getById(entity.getOutAccountId()) ;
//            Double balance = account.getBalance()+entity.getPayAmount() ;
//            accountMapper.updateBalance(balance,entity.getOutAccountId()) ;
//        }
        List<Article> list = outgoMapper.queryArticleById(id) ;
        for(Article article : list){
            //查询业务员信息
            User user = articleMapper.getUserByArticleId(id) ;
            commissionService.updateCommInfo(article,user);
        }
        outgoMapper.delOutgoArticle(id);
        entity.setState(IConst.STATE_DELETE);
        entity.setUpdateUserId(id);
        outgoMapper.update(entity);
        return entity;
    }

    /**
     * 请款选定供应商和稿件后先存数据
     * @param map
     * @return
     */
    @Override
    @Transactional
    public synchronized Outgo saveStepOne(Map map,User user) {
        Integer supplierId = Integer.parseInt((String)map.get("supplierIdSec")) ;
        String supplierName = (String)map.get("supplierNameSec");
        String articleIds = (String)map.get("articleIdsSec");
        Outgo entity = new Outgo() ;
        entity.setSupplierId(supplierId);
        entity.setSupplierName(supplierName);
        entity.setApplyId(user.getId());
        entity.setApplyName(user.getName());
        entity.setApplyTime(new Date());
        entity.setDeptId(user.getDeptId());
        entity.setDeptName(user.getDeptName()) ;
        entity.setCreator(user.getId());
        entity.setCreateTime(new Date());
        //从code表取数据
        Integer max = autoNumberMapper.getMaxCode(IConst.OUTGO_CODE, CodeUtil.getYear(), CodeUtil.getMonth()) ;
        if(max==null){
            max=1 ;
        }else{
            max = max+1 ;
        }
        //生成KP2018110001的编号，前六位是年月，后四位累加
        entity.setCode(IConst.OUTGO_CODE+ CodeUtil.getMonthStr()+ CodeUtil.getFourCode(max,4)) ;
        //更新autoNumber表
        AutoNumber number = new AutoNumber() ;
        number.setCode(IConst.OUTGO_CODE);
        number.setYear(CodeUtil.getYear());
        number.setMonth(CodeUtil.getMonth());
        number.setValue(max);
        autoNumberMapper.insert2(number) ;
        outgoMapper.insert2(entity) ;
        insertOutgoArticle(entity.getId(),articleIds) ;
        return entity ;
    }
    public void insertOutgoArticle(Integer outgoId, String articleIds) {
        if(articleIds.indexOf(",")>-1){
            String[] ids = articleIds.split(",") ;
            //放入set排重
            Set<Integer> set = new HashSet();
            for(int i=0;i<ids.length;i++){
                set.add(Integer.parseInt(ids[i]));
            }
            Iterator<Integer> iterator =set.iterator() ;
            while(iterator.hasNext()){
                Integer articleId =  iterator.next() ;
                Article article = articleMapper.get(Article.class,articleId);
                outgoMapper.insertOutgoArticle(outgoId,articleId);
                //查询业务员信息
                User user = articleMapper.getUserByArticleId(articleId) ;
                commissionService.backCommInfo(article,user);
            }
        }else{
            Integer id = Integer.parseInt(articleIds) ;
            outgoMapper.insertOutgoArticle(outgoId,id);
            Article article = articleMapper.get(Article.class,id);
            //查询业务员信息
            User user = articleMapper.getUserByArticleId(id) ;
            commissionService.backCommInfo(article,user);
        }
    }
    @Override
    public PageInfo<Map> listPgForSelectedArticle(int pageNum, int pageSize, Integer id) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = outgoMapper.listPgForSelectedArticle(id);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public PageInfo<Map> listPgForSelectArticle(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = outgoMapper.listPgForSelectArticle(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public void changeOutgoStates(Integer outgoId, Integer state) {
        List<Article> list = outgoMapper.queryArticleById(outgoId) ;
        for(Article article:list){
            article.setOutgoStates(state);
            articleMapper.update(article);
        }
        return ;
    }

    @Override
    public void deleteByOutgoId(Integer outgoId) {
        outgoBorrowMapper.deleteByOutgoId(outgoId) ;
        return ;
    }
    @Override
    public void insertOutgoBorrrow(OutgoBorrow outgoBorrow) {
        outgoBorrowMapper.insert(outgoBorrow) ;
        return ;
    }
    @Override
    public List<OutgoBorrow> queryByOutgoId (Integer outgoId) {
        return outgoBorrowMapper.queryBorrowById(outgoId) ;
    }
    @Override
    public List<OutgoBorrow> queryByBorrowId (Integer borrowId) {
        return outgoBorrowMapper.queryBorrowByBorrowId(borrowId) ;
    }

    @Override
    public List<Map> queryBorrowById(Integer outgoId) {
        return outgoMapper.queryBorrowById(outgoId) ;
    }

    @Override
    public OutgoBorrow getByOutgoIdAndBorrowId (Integer outgoId,Integer borrowId) {
        return outgoBorrowMapper.getByOutgoIdAndBorrowId(outgoId,borrowId) ;
    }

    /**
     * 算出当前借款订单的申请金额
     * @param outgoId
     * @return
     */
    @Override
    public Double getSumAmountById(Integer outgoId){
        return outgoMapper.getSumAmountById(outgoId) ;
    }
}
