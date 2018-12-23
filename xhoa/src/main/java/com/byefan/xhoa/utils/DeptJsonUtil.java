package com.byefan.xhoa.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.byefan.xhoa.entity.sys.Dept;

import java.util.ArrayList;
import java.util.List;

public class DeptJsonUtil {

    public List<Dept> deptList;
    JSONArray array = new JSONArray() ;
    public List<Object> list = new ArrayList<Object>();

    public JSONArray jsonList(List<Dept> paramList){
        this.deptList = paramList;
        for (Dept x : paramList) {
            JSONObject obj = new JSONObject() ;
            if(x.getParentId()==0){
                obj.put("value", x.getId());
                obj.put("name", x.getName());
                obj.put("level", x.getLevel());
                obj.put("code", x.getCode());
                obj.put("type", x.getType());
                obj.put("pid", x.getParentId());
                obj.put("children", treeChild(x.getId()));
                obj.put("mgrName",x.getMgrName());
                obj.put("mgrId",x.getMgrId());
                obj.put("mgrLeaderId",x.getMgrLeaderId());
                obj.put("mgrLeaderName",x.getMgrLeaderName());
                array.add(obj) ;
            }
        }
        return array;
    }


    public JSONArray treeChild(int id){
        JSONArray arrays = new JSONArray() ;
        for(Dept a:deptList){
            JSONObject childObj = new JSONObject() ;
            if(a.getParentId() == id){
                childObj.put("value", a.getId());
                childObj.put("name", a.getName());
                childObj.put("code", a.getCode());
                childObj.put("type", a.getType());
                childObj.put("level", a.getLevel());
                childObj.put("pid", a.getParentId());
                childObj.put("children", treeChild(a.getId()));
                childObj.put("mgrName",a.getMgrName());
                childObj.put("mgrId",a.getMgrId());
                childObj.put("mgrLeaderId",a.getMgrLeaderId());
                childObj.put("mgrLeaderName",a.getMgrLeaderName());
                arrays.add(childObj);

            }
        }
//        System.out.println("******************arrays="+arrays);
        return arrays;


    }

}
