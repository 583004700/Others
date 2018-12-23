package com.byefan.xhoa.utils;

import org.springframework.util.StringUtils;

import java.util.Map;

//数据权限工具类
public class DataSecurityUtil {
    //添加数据权限相关的内容
    public static void addSecurity(Map map){
        if(!StringUtils.isEmpty(map.get("currentDeptId"))){
            map.remove("currentUserId");
            map.put("currentDeptQx","true");
            return;
        }
        if(AppUtil.getUser().getCurrentDeptQx()){
            //如果有当前部门权限，则统计当前部门的数据
            map.remove("currentUserId");
            map.put("currentDeptQx","true");
            map.put("currentDeptId",AppUtil.getUser().getDeptId());
        }else{
            //只统计当前用户自己的数据
            map.put("currentUserId",AppUtil.getUser().getId());
        }
    }
}
