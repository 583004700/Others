package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.fee.ReimburseD;
import com.byefan.xhoa.mapper.fee.ReimburseDMapper;
import com.byefan.xhoa.service.fee.IReimburseDService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReimburseDService implements IReimburseDService {
    @Autowired
    private ReimburseDMapper borrowMapper ;


    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = borrowMapper.listPg(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public ReimburseD getById(Integer id) {
        return borrowMapper.getById(id);
    }

    @Override
    public ReimburseD add(ReimburseD entity, Integer id) {

        //
//        entity.setUpdateUserId(id);
        borrowMapper.insert(entity);
        return entity;
    }
    @Override
    public ReimburseD edit(ReimburseD entity, Integer id) {
        ReimburseD oldEntity = getById(entity.getId()) ;

//        entity.setUpdateUserId(id);
        borrowMapper.update(entity);
        return entity;
    }
    @Override
    public ReimburseD delById(Integer id) {
        ReimburseD entity = getById(id) ;

        entity.setState(1);
//        entity.setUpdateUserId(id);
        borrowMapper.update(entity);
        return entity;
    }
}
