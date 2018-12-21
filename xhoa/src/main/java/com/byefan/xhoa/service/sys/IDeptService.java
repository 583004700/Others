package com.byefan.xhoa.service.sys;

import com.alibaba.fastjson.JSONArray;
import com.byefan.xhoa.entity.sys.Dept;

import java.util.List;
import java.util.Map;

public interface IDeptService {

    List<Dept> listAll();

    List<Dept> listParam(Integer userId);

    //    @Cacheable(value = "dept", key = "")
    JSONArray listForTreeView();

    JSONArray list();

    Integer getMaxLevel();

    List<Dept> queryAllDept();

    List<Dept> queryDeptByUserId(Integer id);

    void editDept(Dept dept);

    void delDept(Integer id);

    Dept addChildDept(Map map);

    Dept getById(Integer id);

    List<Dept> queryDeptByName(String name);

    List<Dept> listByType(String type);
}
