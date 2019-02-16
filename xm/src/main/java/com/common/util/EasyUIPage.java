package com.common.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scriptManager.data.ThreadDataSourceManager;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * easyui分页格式
 */
public class EasyUIPage<T> {
    //当前页码
    private int page;
    //每页展示的条数
    private int rows;
    //按哪个字段进行排序
    private String sort;
    //排序的方向，asc或desc
    private String order;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    //开始分页，并得到分页结果
    public Page<T> startPage(){
        Page<T> page = null;
        if(StringUtils.isEmpty(order)){
            page = PageHelper.startPage(this.page,this.rows);
        }else{
            page = PageHelper.startPage(this.page,this.rows," "+this.sort+" "+this.order);
        }
        return page;
    }

    public ResponseParam<T> getResult(List<T> list){
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return new ResponseParam<T>(pageInfo.getTotal(),list);
    }


    public static class ResponseParam<T>{
        private long total;
        private List<T> rows;

        public ResponseParam(long total,List<T> rows){
            this.total = total;
            this.rows = rows;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public List<T> getRows() {
            return rows;
        }

        public void setRows(List<T> rows) {
            this.rows = rows;
        }
    }
}
