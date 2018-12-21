//package com.byefan.xhoa.utils;
//
//import com.byefan.xhoa.entity.sys.Dept;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class DeptTreeUtil {
//    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
//    public List<Dept> deptList;
//    public List<Object> list = new ArrayList<Object>();
//
//    public List<Object> treeList(List<Dept> paramList){
//        this.deptList = paramList;
//        for (Dept x : paramList) {
//            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();
//            if(x.getParentId()==0){
//                mapArr.put("id", x.getId());
//                mapArr.put("name", x.getName());
//                mapArr.put("level", x.getLevel());
//                mapArr.put("pid", x.getParentId());
//                mapArr.put("child", treeChild(x.getId()));
//                list.add(mapArr);
//            }
//        }
//        return list;
//    }
//
//
//    public List<?> treeChild(int id){
//        List<Object> lists = new ArrayList<Object>();
//        for(Dept a:deptList){
//            Map<String,Object> childArray = new LinkedHashMap<String, Object>();
//            if(a.getParentId() == id){
//                childArray.put("id", a.getId());
//                childArray.put("name", a.getName());
//                childArray.put("level", a.getLevel());
//                childArray.put("pid", a.getParentId());
//                childArray.put("child", treeChild(a.getId()));
//                lists.add(childArray);
//            }
//        }
//        return lists;
//
//    }
//
//}
