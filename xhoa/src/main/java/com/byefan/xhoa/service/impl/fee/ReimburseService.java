package com.byefan.xhoa.service.impl.fee;

import com.byefan.xhoa.entity.fee.Reimburse;
import com.byefan.xhoa.mapper.fee.ReimburseMapper;
import com.byefan.xhoa.service.fee.IReimburseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReimburseService implements IReimburseService {
    @Autowired
    private ReimburseMapper borrowMapper ;


    @Override
    public PageInfo<Map> listPg(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = borrowMapper.listPg(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo ;
    }

    @Override
    public Reimburse getById(Integer id) {
        return borrowMapper.getById(id);
    }

    @Override
    public Reimburse add(Reimburse entity, Integer id) {

        //
        entity.setUpdateUserId(id);
        borrowMapper.insert(entity);
        return entity;
    }
    @Override
    public Reimburse edit(Reimburse entity, Integer id) {
        Reimburse oldEntity = getById(entity.getId()) ;

        entity.setUpdateUserId(id);
        borrowMapper.update(entity);
        return entity;
    }
    @Override
    public Reimburse delById(Integer id) {
        Reimburse entity = getById(id) ;

        entity.setState(1);
        entity.setUpdateUserId(id);
        borrowMapper.update(entity);
        return entity;
    }
}
