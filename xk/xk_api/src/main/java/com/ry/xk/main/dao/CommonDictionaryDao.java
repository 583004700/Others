package com.ry.xk.main.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.mapper.CommonDictionaryMapper;


/**
 * 公共字典dao
 */
@Component
public class CommonDictionaryDao implements ICommonDictionaryDao
{
    @Autowired
    CommonDictionaryMapper commonDictionaryMapper;

    @Override
    @Cacheable("commondictionarys")
    public List<CommonDictionary> getAll() {
        return commonDictionaryMapper.getAll();
    }
}