package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Account;
import com.byefan.xhoa.entity.fee.Borrow;
import com.byefan.xhoa.entity.sys.AutoNumber;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.mapper.fee.AccountMapper;
import com.byefan.xhoa.mapper.fee.BorrowMapper;
import com.byefan.xhoa.mapper.sys.AutoNumberMapper;
import com.byefan.xhoa.service.fee.IBorrowService;
import com.byefan.xhoa.utils.CodeUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private BorrowMapper borrowMapper ;
    @Autowired
    private AutoNumberMapper autoNumberMapper ;

    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = borrowMapper.listPg(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public PageInfo<Map> listPgForOutgo(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = borrowMapper.listPgForOutgo(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Borrow getById(Integer id) {
        return borrowMapper.getById(id);
    }

    @Override
    public synchronized Borrow add(Borrow entity) {
        //从code表取数据
        Integer max = autoNumberMapper.getMaxCode(IConst.BORROW_CODE, CodeUtil.getYear(), CodeUtil.getMonth()) ;
        if(max==null){
            max=1 ;
        }else{
            max = max+1 ;
        }
        //生成KP2018110001的编号，前六位是年月，后四位累加
        entity.setCode(IConst.BORROW_CODE+ CodeUtil.getMonthStr()+ CodeUtil.getFourCode(max,4)) ;
        //更新autoNumber表
        AutoNumber number = new AutoNumber() ;
        number.setCode(IConst.BORROW_CODE);
        number.setYear(CodeUtil.getYear());
        number.setMonth(CodeUtil.getMonth());
        number.setValue(max);
        autoNumberMapper.insert2(number) ;

        borrowMapper.insert2(entity);
        return entity;
    }
    @Override
    public Borrow edit(Borrow entity) {
        borrowMapper.update(entity);
        return entity;
    }
    @Override
    public Borrow delById(Integer id) {
        Borrow entity = getById(id) ;

        entity.setState(IConst.STATE_DELETE);
        entity.setUpdateUserId(id);
        borrowMapper.update(entity);
        return entity;
    }
    @Override
    public List<Borrow> queryByOutgoId(Integer outgoId) {
        return borrowMapper.queryByOutgoId(outgoId);
    }
    @Override
    public List<Map> queryByOutgoId2(Integer outgoId) {
        return borrowMapper.queryByOutgoId2(outgoId);
    }
}
