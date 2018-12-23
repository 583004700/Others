package com.byefan.xhoa.service.fee;

import com.byefan.xhoa.entity.fee.Account;
import com.byefan.xhoa.entity.sys.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IAccountService {


    PageInfo<Map> listPg(int pageNum, int pageSize, Map map);

    Account getById(Integer id) ;

    Account add(Account entity);

    Account delById(Integer id);

    Account edit(Account entity);

    PageInfo<Map> listPgForSelectAccount(int pageNum, int pageSize, Integer companyId, Integer type, Map map);

    void insertAccountDept(Integer accountId, Integer deptId);

    void deleteAccountDept(Integer accountId, Integer deptId);

    void deleteAccountDept(Integer accountId);

    List<Dept> queryDeptByAccountId(Integer id);
}
