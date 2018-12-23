package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.fee.Account;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.mapper.fee.AccountMapper;
import com.byefan.xhoa.mapper.media.SupplierMapper;
import com.byefan.xhoa.service.fee.IAccountService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountMapper accountMapper ;
    @Autowired
    private SupplierMapper supplierMapper ;
    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = accountMapper.listPg(map);
        for(Map temp : list){
            if(temp.get("id")!=null){
                StringBuffer sb=new StringBuffer() ;
//                String IDS =
                Integer id = (Integer)temp.get("id") ;
                List<Dept> deptList = this.queryDeptByAccountId(id) ;
                if(deptList.size()>0){
                    for(Dept dept:deptList){
                        sb.append(dept.getName()+"，") ;
                    }
                }
                if(sb.length()>0 && '，' == sb.charAt(sb.length() - 1)){
                    sb.delete(sb.length()-1,sb.length()) ;
                }
                temp.put("deptNames",sb.toString()) ;
            }
        }
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Account getById(Integer id) {
        return accountMapper.getById(id);
    }

    @Override
    public Account add(Account entity) {
        accountMapper.insert2(entity) ;
        return entity;
    }

    @Override
    public Account delById(Integer id) {
        Account entity = getById(id) ;
        entity.setState(IConst.STATE_DELETE);
        accountMapper.update(entity) ;
        return entity;
    }
    @Override
    public Account edit(Account entity) {
        accountMapper.update(entity);
        return entity;
    }
    @Override
    public PageInfo<Map> listPgForSelectAccount(int pageNum, int pageSize,Integer companyId,Integer type, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        map.put("companyId",companyId);
        map.put("type",type);
        List<Map> list = accountMapper.listPgForSelectAccount(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void insertAccountDept(Integer accountId, Integer deptId) {
        accountMapper.insertAccountDept(accountId,deptId);
        return ;
    }

    @Override
    public void deleteAccountDept(Integer accountId, Integer deptId) {
        accountMapper.deleteAccountDept(accountId,deptId);
        return ;
    }

    @Override
    public void deleteAccountDept(Integer accountId) {
        accountMapper.deleteAccountDeptByAccountId(accountId);
        return ;
    }
    @Override
    public List<Dept> queryDeptByAccountId(Integer id) {
        return accountMapper.queryDeptByAccountId(id);
    }

}
