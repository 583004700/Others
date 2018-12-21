package com.byefan.xhoa.service.impl;

import com.byefan.xhoa.entity.sys.District;
import com.byefan.xhoa.mapper.DistrictMapper;
import com.byefan.xhoa.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DistrictService implements IDistrictService {
    @Autowired
    DistrictMapper districtMapper;
    private static final String CACHE_KEY = "district";
    private static final String CACHE_KEYS = "districts";
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = CACHE_KEYS)
    public List<District> all() {
        return districtMapper.all(District.class);
    }

}
