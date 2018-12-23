package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Commission;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.biz.ArticleMapper;
import com.byefan.xhoa.mapper.fee.CommissionMapper;
import com.byefan.xhoa.service.fee.ICommissionService;
import com.byefan.xhoa.utils.CodeUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class CommissionService implements ICommissionService {
    @Autowired
    private CommissionMapper commissionMapper ;
    @Autowired
    private ArticleMapper articleMapper ;

    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = commissionMapper.listPg(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Commission getById(Integer id) {
        return commissionMapper.getById(id);
    }

    @Override
    public Commission add(Commission entity) {
        commissionMapper.insert(entity);
        return entity;
    }
    @Override
    public Commission edit(Commission entity) {
        commissionMapper.update(entity);
        return entity;
    }
    @Override
    public void delById(Integer id) {
        Commission entity = getById(id) ;
        entity.setState(IConst.STATE_DELETE);
        commissionMapper.update(entity);
        return ;
    }


    /**\
     * 提交1、请款申请，2、借款和其他支出申请
     * 这2个条件下把稿件提成状态还原（提成中2-->已保存0），金额置0，该稿件提成汇总表的金额退回去
     * @param user 业务员对象
     */
    @Override
    @Transactional
    public void backCommInfo(Article article, User user) {
        if(article.getCommissionStates()==2){
            //提成汇总表减去该稿件提成
            List<Commission> list = commissionMapper.queryCommissionByUser(user.getId(),article.getYear(),article.getMonth()) ;
            if(list!=null && list.size()>0){
                Commission oldComm = list.get(0) ;
                oldComm.setProfit(oldComm.getProfit()-article.getProfit());
                oldComm.setComm(oldComm.getComm()-article.getCommission());
                commissionMapper.update(oldComm);
            }
            article.setProfit(0.0);
            article.setCommission(0.0);
            article.setCommissionStates(0);
            article.setYear(null) ;
            article.setMonth(null) ;
            articleMapper.update(article) ;
        }
        return ;
    }
    /**
     * 1、发布（因为后来分款改成发布后才能分款，实际上这里没有意义，已删除）；2、分款且稿件的实收大于等于应收income>=sale，3、用户取消退款申请,4、财务批准退款和其他支出；5、用户取消请款,6、财务批准请款，
     * 这6个条件下执行该方法，计算稿件提成和提成汇总
     * 修改稿件提成状态commission_states为2提成中，财务发放提成后更改为1
     * @param user 业务员对象
     */
    @Override
    @Transactional
    public void updateCommInfo(Article article,User user) {
        //该稿件未计算过提成，则计算出提成信息，并把金额添加到提成汇总表中
        if(article.getCommissionStates()==0){
            //已发布和已进账的就计算提成
            //提成 = （进账 - 成本价 - 退款 - 其他支出）* 0.2
            if(article.getIssueStates()==4 && article.getIncomeStates()==1){
                Double incomeAmount = article.getIncomeAmount() ;
                Double outgoAmount = article.getOutgoAmount() ;
                Double otherPay = article.getOtherPay() ;
                Double refundAmount = article.getRefundAmount() ;
                Double tax = article.getTaxes() ;
                Double profit = incomeAmount ;
                if(article.getOutgoAmount()==1)
                    profit = profit-outgoAmount ;
                if(article.getRefundStates()==1)
                    profit = profit-refundAmount-otherPay ;
                Double commAmount = Math.floor(profit * 20)*0.01 ;

                article.setYear(CodeUtil.getYear());
                article.setMonth(CodeUtil.getMonth());
                article.setProfit(profit);
                article.setCommission(commAmount);
                article.setCommissionStates(2);
                articleMapper.update(article) ;

                //查询本月是否有提成汇总信息，如果有就加入，没有则新增
                List<Commission> list = commissionMapper.queryCommissionByUser(user.getId(),CodeUtil.getYear(),CodeUtil.getMonth()) ;
                if(list!=null && list.size()>0){
                    Commission oldComm = list.get(0) ;
                    oldComm.setComm(oldComm.getComm()+commAmount);
                    commissionMapper.update(oldComm);
                }else{
                    Commission comm = new Commission() ;
                    comm.setUserId(user.getId());
                    comm.setName(user.getName());
                    comm.setDeptId(user.getDeptId());
                    comm.setDeptName(user.getDeptName());
                    comm.setYear(CodeUtil.getYear()) ;
                    comm.setMonth(CodeUtil.getMonth()) ;
                    comm.setIncome(incomeAmount);
                    comm.setOutgo(outgoAmount);
                    comm.setTaxExpense(tax);
                    comm.setRefund(refundAmount);
                    comm.setOtherExpense(otherPay);
                    comm.setCommPercent(0.2);
                    comm.setProfit(profit);
                    comm.setComm(commAmount) ;
                    commissionMapper.insert(comm) ;
                }
            }
        }
        return ;
    }

    /**
     * 每日2点把上个月的所有不满足提成条件的稿件月份更新为这个月
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void updateCommByMonth(){
        log.info("*******************定时器执行中******************") ;
        Integer year = CodeUtil.getYear() ;
        Integer month = CodeUtil.getMonth() ;
        commissionMapper.updateCommissionByMonth(year,month) ;
    }
}
