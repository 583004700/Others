package com.byefan.xhoa.service.media;

import com.byefan.xhoa.entity.media.Supplier;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface ISupplierService {

    String CACHE_KEY = "supplier";

    PageInfo<Supplier> listall(Supplier supplier, Pageable pageable);

    List<Supplier> list(Supplier supplier);

    void save(Supplier supplier);

    @Transactional
    Supplier update(Supplier supplier);

    @Cacheable(value = CACHE_KEY, key = "#id")
    Supplier getById(Integer id);

    boolean isRepeat(String supplierName, String contactor);

    PageInfo<Map> querySupplierList(int pageNum, int pageSize, Map map);
}