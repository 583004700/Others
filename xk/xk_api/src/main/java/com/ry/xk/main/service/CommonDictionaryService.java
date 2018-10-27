package com.ry.xk.main.service;


import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.main.dao.ICommonDictionaryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommonDictionaryService implements ICommonDictionaryService
{
    private static final Logger log = LoggerFactory.getLogger(CommonDictionaryService.class);

    @Autowired
    ICommonDictionaryDao commonDictionaryDao;

    @Override
    public List<CommonDictionary> getAll()
    {
        return commonDictionaryDao.getAll();
    }

    /**
     * 获取某组公共字典
     * @param itemGroup
     * @return
     */
    @Override
    public List<CommonDictionary> get(String itemGroup)
    {
        List<CommonDictionary> commonDictionaries = getAll();
        if(commonDictionaries == null){
            new ArrayList<CommonDictionary>();
        }
        List<CommonDictionary> newcommonDictionaries = commonDictionaries.stream().filter(t -> {
            return itemGroup.equals(t.getItemGroup());
        }).collect(Collectors.toList());
        return newcommonDictionaries;
    }
}
