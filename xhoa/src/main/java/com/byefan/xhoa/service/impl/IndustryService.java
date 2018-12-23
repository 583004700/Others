package com.byefan.xhoa.service.impl;

import com.byefan.xhoa.entity.media.Industry;
import com.byefan.xhoa.mapper.IndustryMapper;
import com.byefan.xhoa.service.IIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IndustryService implements IIndustryService {
    @Autowired
    IndustryMapper industryMapper;
    private static final String CACHE_KEYS = "industrys";

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = CACHE_KEYS)
    public List<Industry> list(Industry industry) {
        return industryMapper.list(industry);
    }
}
