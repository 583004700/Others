package com.byefan.xhoa.service.impl.media;

import com.byefan.xhoa.entity.media.Supplier;
import com.byefan.xhoa.mapper.media.SupplierMapper;
import com.byefan.xhoa.service.media.ISupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class SupplierService implements ISupplierService {

    @Autowired
    SupplierMapper supplierMapper;

    @Cacheable(value = CACHE_KEY)
    public List<Supplier> list(Supplier supplier) {
        Integer state = supplier.getState();
        supplier.setState(state == null ? 0 : state);
        return supplierMapper.list(supplier);
    }

    /**
     * 查询媒体列表
     *
     * @param supplier 媒体供应商查询条件
     * @param pageable 分页对象
     * @return
     */
    @Transactional(readOnly = true)
//    @Cacheable(value = CACHE_KEY, key = "#media.id")
    public PageInfo<Supplier> listall(Supplier supplier, Pageable pageable) {
        supplier.setState(0);
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<Supplier> list = supplierMapper.listByOrder(supplier,"update_time desc");
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void save(Supplier supplier) {
        supplierMapper.insert(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        supplierMapper.update(supplier);
        return (supplier);
    }


    @Override
    @Cacheable(value = CACHE_KEY, key = "#id")
    public Supplier getById(Integer id) {
        return supplierMapper.getById(id);
    }

    /**
     * 判断供应商+联系人是否重复
     *
     * @return
     */
    public boolean isRepeat(String supplierName, String contactor) {
        return supplierMapper.getIdBySupplierName(supplierName, contactor) > 0;
    }

    @Override
    public PageInfo<Map> querySupplierList(int pageNum, int pageSize, Map map) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = supplierMapper.querySupplierList(map);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
