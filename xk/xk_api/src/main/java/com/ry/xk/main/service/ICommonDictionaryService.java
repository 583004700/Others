package com.ry.xk.main.service;

import com.ry.xk.common.bo.CommonDictionary;
import com.ry.xk.response.bo.CourseType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommonDictionaryService
{
    /**
     * 获取所有公共字典
     * @return
     */
    public List<CommonDictionary> getAll();
    /**
     * 获取某组公共字典
     */
    public List<CommonDictionary> get(String itemGroup);
}
