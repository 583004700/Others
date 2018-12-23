package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Account;
import com.byefan.xhoa.entity.fee.Income;
import com.byefan.xhoa.entity.fee.IncomeArticle;
import com.byefan.xhoa.entity.fee.IncomeUser;
import com.byefan.xhoa.entity.sys.AutoNumber;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.biz.ArticleMapper;
import com.byefan.xhoa.mapper.fee.AccountMapper;
import com.byefan.xhoa.mapper.fee.IncomeArticleMapper;
import com.byefan.xhoa.mapper.fee.IncomeMapper;
import com.byefan.xhoa.mapper.fee.IncomeUserMapper;
import com.byefan.xhoa.mapper.sys.AutoNumberMapper;
import com.byefan.xhoa.service.fee.ICommissionService;
import com.byefan.xhoa.service.fee.IIncomeService;
import com.byefan.xhoa.utils.CodeUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class IncomeService implements IIncomeService {
    @Autowired
    private IncomeMapper incomeMapper ;
    @Autowired
    private IncomeUserMapper incomeUserMapper ;
    @Autowired
    private AccountMapper accountMapper ;
    @Autowired
    private ArticleMapper articleMapper ;
    @Autowired
    private AutoNumberMapper autoNumberMapper ;
    @Autowired
    private IncomeArticleMapper incomeArticleMapper ;
    @Autowired
    private ICommissionService commissionService ;
    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = incomeMapper.listPg(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Income getById(Integer id) {
        return incomeMapper.getById(id);
    }

    @Override
    public synchronized Income add(Income entity) {
        //有金额入账，往账户表叠加金额
        if(entity.getAccountId()!=null){
            Account account = accountMapper.getById(entity.getAccountId()) ;
            Double balance = account.getBalance()+entity.getTradeAmount() ;
            balance = balance + entity.getTradeAmount() ;
            accountMapper.updateBalance(balance,entity.getAccountId()) ;
        }
        //
        entity.setUnclaimedAmount(entity.getTradeAmount());
        //从code表取数据
        Integer max = autoNumberMapper.getMaxCode(IConst.INCOME_CODE, CodeUtil.getYear(), CodeUtil.getMonth()) ;
        if(max==null){
            max=1 ;
        }else{
            max = max+1 ;
        }
        //生成FK2018110001的编号，前六位是年月，后四位累加
        entity.setCode(IConst.INCOME_CODE+ CodeUtil.getMonthStr()+ CodeUtil.getFourCode(max,4)) ;
        //更新autoNumber表
        AutoNumber number = new AutoNumber() ;
        number.setCode(IConst.INCOME_CODE);
        number.setYear(CodeUtil.getYear());
        number.setMonth(CodeUtil.getMonth());
        number.setValue(max);
        autoNumberMapper.insert2(number) ;

        incomeMapper.insert(entity);
        return entity;
    }
    @Override
    public Income edit(Income entity) {
        Income oldEntity = getById(entity.getId()) ;
        if(oldEntity.getAccountId()!=null){
            Account oldAccount = accountMapper.getById(oldEntity.getAccountId()) ;
            if(oldEntity.getAccountId()==entity.getAccountId()){
                //修改时账户信息不变，只需更改金额
                Double oldBalance = oldAccount.getBalance() ;
                Double balance = oldBalance-oldEntity.getTradeAmount()+entity.getTradeAmount()  ;
                accountMapper.updateBalance(balance,oldEntity.getAccountId()) ;
            }else{
                //更改了账户，先退旧账户金额，
                Double oldBalance = oldAccount.getBalance() ;
                oldBalance = oldBalance-oldEntity.getTradeAmount()  ;
                accountMapper.updateBalance(oldBalance,oldEntity.getAccountId()) ;
                //再添加新账户金额
                Account account = accountMapper.getById(entity.getAccountId()) ;
                Double balance = account.getBalance()+entity.getTradeAmount() ;
                accountMapper.updateBalance(balance,entity.getAccountId()) ;
            }
        }
//        entity.setUnclaimedAmount(entity.getTradeAmount());
        incomeMapper.update(entity);
        return entity;
    }
    @Override
    public Income delById(Integer id) {
        Income entity = getById(id) ;
        //扣除账户里的钱
        if(entity.getAccountId()!=null){
            Account account = accountMapper.getById(entity.getAccountId()) ;
            Double balance = account.getBalance()-entity.getTradeAmount() ;
            accountMapper.updateBalance(balance,entity.getAccountId()) ;
        }
        entity.setState(IConst.STATE_DELETE);
        entity.setUpdateUserId(id);
        incomeMapper.update(entity);
        return entity;
    }

    @Override
    @Transactional
    public Income receiveIncome(Integer id,Double amount, User opUser) {
        Income entity = getById(id) ;
        try{
            if(entity.getUnclaimedAmount()<amount){
                throw new Exception("金额不足") ;
            }else{
                Double oldPreclaimedAmount = entity.getPreclaimedAmount() ;
                Double oldUnclaimedAmount = entity.getUnclaimedAmount() ;
                entity.setUnclaimedAmount(oldUnclaimedAmount-amount);
                entity.setPreclaimedAmount(oldPreclaimedAmount+amount);
                //查询领款信息
                IncomeUser incomeUser = incomeUserMapper.getIncomeUser(id,opUser.getId()) ;
                //已领，就update，否则新增
                if(incomeUser!=null){
                    incomeUser.setReceiveTime(new Date());
                    incomeUser.setReceiveAmount(incomeUser.getReceiveAmount()+amount);
                    incomeUser.setRemainAmount(incomeUser.getRemainAmount()+amount);
                    incomeUserMapper.update2(incomeUser) ;
                }else{
                    incomeUser = new IncomeUser() ;
                    incomeUser.setIncomeId(id);
                    incomeUser.setUserId(opUser.getId());
                    incomeUser.setName(opUser.getName());
                    //            incomeUser.setDeptId(0);
                    //            incomeUser.setDeptName("");
                    incomeUser.setReceiveAmount(amount);
                    incomeUser.setRemainAmount(amount);
                    incomeUser.setReceiveTime(new Date());
                    incomeUser.setCreateTime(new Date());
                    incomeUser.setDeptId(opUser.getDeptId()) ;
                    incomeUser.setDeptName(opUser.getDeptName());
                    incomeUserMapper.insert2(incomeUser) ;
                }
                entity.setUpdateUserId(id);
                incomeMapper.update(entity);
                return entity;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    /**
     * 退回领款
     * @param id
     */
    @Override
    public void returnIncome(Integer id,Double receiveAmount,List<IncomeUser> list) {
        Income entity = getById(id) ;
        Double amount = receiveAmount ;
        //查询领款信息
        entity.setUnclaimedAmount(entity.getUnclaimedAmount()+amount);
        entity.setPreclaimedAmount(entity.getPreclaimedAmount()-amount);
        entity.setUpdateUserId(id);
        for(IncomeUser iu:list){
            iu.setState(IConst.STATE_DELETE) ;
            incomeUserMapper.update(iu);
        }
        incomeMapper.update(entity);
    }

    @Override
    public PageInfo<Map> queryArticleForAssign(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = incomeMapper.queryArticleForAssign(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    @Transactional
    public void assignIncome(Map map,User user) {
        Integer incomeId = Integer.parseInt((String)map.get("incomeId")) ;
        String articleIds = (String)map.get("ids") ;
        IncomeUser incomeUser = incomeUserMapper.getIncomeUser(incomeId,user.getId()) ;
        Double total = 0.0 ;
        try{
            if(articleIds.indexOf(",")>-1){
                String[] ids = articleIds.split(",") ;
                //放入set排重
                Set<Integer> set = new HashSet();
                for(int i=0;i<ids.length;i++){
                    set.add(Integer.parseInt(ids[i]));
                }

                //处理进账和稿件关系
                Iterator<Integer> iterator =set.iterator() ;
                while(iterator.hasNext()){
                    Integer next = iterator.next() ;
                    Double incomeAmount = Double.parseDouble((String)map.get("income_"+next)) ;
                    total += incomeAmount ;
                    Article article = articleMapper.get(Article.class,next) ;
                    //incomeAmount为0，没分过款
                    if(article.getIncomeAmount()==0){
                        //如果应付==实付，更改为已分款，否则只记录分款金额
//                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>销售收入："+article.getSaleAmount().toString()+"\t 进账："+incomeAmount.toString()+"\t 是否相等："+article.getSaleAmount().toString().equals(incomeAmount.toString()));
                        if(article.getSaleAmount().toString().equals(incomeAmount.toString())){
                            //更新稿件进款信息
                            article.setIncomeStates(1);
                            article.setIncomeAmount(incomeAmount);
                            articleMapper.update(article);
//                            articleMapper.updateAssignStatus(next,incomeAmount);
                            //更新提成信息
                            commissionService.updateCommInfo(article,user);
                        }else{
                            articleMapper.updateIncomeAmount(next,incomeAmount);
                        }
                    }else{
                        //分过款，先判断金额是否足够，足够了改状态，否则只累加金额
                        Double temp = article.getIncomeAmount()+incomeAmount ;
                        if(article.getSaleAmount().toString().equals(temp.toString())){
                            //更新稿件进款信息
                            article.setIncomeStates(1);
                            article.setIncomeAmount(temp);
                            articleMapper.update(article);
                            //更新提成信息
                            articleMapper.updateAssignStatus(next,temp);
                        }else{
                            articleMapper.updateIncomeAmount(next,temp);
                        }
                    }

                    //处理分款关系表的关系
//                    incomeArticleMapper.deleteIncomeArticleByIncomeId(incomeId);
                    IncomeArticle incomeArticle = new IncomeArticle() ;
                    incomeArticle.setIncomeId(incomeId);
                    incomeArticle.setArticleId(next);
                    incomeArticle.setAmount(incomeAmount);
                    incomeArticle.setDate(new Date());
                    incomeArticleMapper.insert2(incomeArticle) ;
                }
            }else{
                Integer id = Integer.parseInt(articleIds) ;
                Double incomeAmount = Double.parseDouble((String)map.get("income_"+id)) ;
                total += incomeAmount ;
                Article article = articleMapper.get(Article.class,id) ;
//                System.out.println(">>>>>>>>>>>>3>>>>>>>>>>>>销售收入："+article.getSaleAmount().toString()+"\t 进账："+incomeAmount.toString()+"\t 是否相等："+article.getSaleAmount().toString().equals(incomeAmount.toString()));
                if(article.getIncomeAmount()==0){
                    //如果应付==实付，更改为已分款，否则只记录分款金额

                    if(article.getSaleAmount().toString().equals(incomeAmount.toString())){
                        //更新稿件进款信息
                        article.setIncomeStates(1);
                        article.setIncomeAmount(incomeAmount);
                        articleMapper.update(article);
//                        articleMapper.updateAssignStatus(id,incomeAmount);
                        //更新提成信息
                        commissionService.updateCommInfo(article,user);
                    }else{
                        articleMapper.updateIncomeAmount(id,incomeAmount);
                    }
                }else{
                    //分过款，先判断金额是否足够，足够了改状态，否则只累加金额
                    Double temp = article.getIncomeAmount()+incomeAmount ;
                    if(article.getSaleAmount().toString().equals(temp.toString())){
                        //更新稿件进款信息
                        article.setIncomeStates(1);
                        article.setIncomeAmount(temp);
                        articleMapper.update(article);
//                        articleMapper.updateAssignStatus(id,temp);
                        //更新提成信息
                        commissionService.updateCommInfo(article,user);
                    }else{
                        articleMapper.updateIncomeAmount(id,temp);
                    }
                }
                //处理分款关系表的关系
//                incomeArticleMapper.deleteIncomeArticleByIncomeId(incomeId);
                IncomeArticle incomeArticle = new IncomeArticle() ;
                incomeArticle.setIncomeId(incomeId);
                incomeArticle.setArticleId(id);
                incomeArticle.setAmount(incomeAmount);
                incomeArticle.setDate(new Date());
                incomeArticleMapper.insert2(incomeArticle) ;
            }
            incomeUser.setAssignAmount(incomeUser.getAssignAmount()+total);
            incomeUser.setRemainAmount(incomeUser.getRemainAmount()-total);
            incomeUserMapper.update(incomeUser);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public PageInfo<Map> listPgForSelectedArticle(int pageNum, int pageSize, Integer id) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = incomeMapper.listPgForSelectedArticle(id);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }
    @Override
    public PageInfo<Map> listPgForAssign(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = incomeUserMapper.listPgForAssign(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }
    @Override
    public IncomeUser getIncomeUser(Integer incomeId, Integer userId) {
        IncomeUser incomeUser = incomeUserMapper.getIncomeUser(incomeId,userId) ;
        return incomeUser ;
    }
    @Override
    public List<Map> listPgByArticleId(Article article){
        return incomeMapper.listPgByArticleId(article);
    }

    @Override
    public List<Income> queryIncomeByAccountId(Integer accountId){
        return incomeMapper.queryIncomeByAccountId(accountId);
    }

    @Override
    public List<IncomeUser> queryIncomeUserByIncomeId(Integer incomeId) {
        List<IncomeUser> list = incomeUserMapper.queryIncomeUserByIncomeId(incomeId) ;
        return list ;
    }

    @Override
    public List<IncomeUser> queryIncomeUserByIncomeIdAndUserId(Integer incomeId,Integer userId) {
        List<IncomeUser> list = incomeUserMapper.queryIncomeUserByIncomeIdAndUserId(incomeId,userId) ;
        return list ;
    }
    @Override
    public Map querySumAmount(Integer incomeId, Integer userId) {
        Map map = incomeUserMapper.querySumAmount(incomeId,userId) ;
        return map ;
    }
}
