package com.ry.xk.studentexamresult.bo;

import java.util.List;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 错题本
 */
public class StudentExamList implements ICouchBaseStoredObject
{
    // 用户ID
    @Tag(1)
    private int userId;

    // 学生测试缓存记录
    @Tag(2)
    private List<StudentExamItem> studentExamItems;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public List<StudentExamItem> getStudentExamItems()
    {

        return studentExamItems;
    }

    public void setStudentExamItems(List<StudentExamItem> studentExamItems)
    {

        this.studentExamItems = studentExamItems;
    }

    private static String _key = "StudentExamList_%s";

    @Override
    public String key()
    {
        return String.format(keyFormat(), userId);
    }

    @Override
    public String keyFormat()
    {
        return _key;
    }

    @Override
    public CouchBaseSectionType couchbaseSection()
    {
        return CouchBaseSectionType.EXAMRESULT;
    }

    public StudentExamList()
    {}

    public StudentExamList(int userId, List<StudentExamItem> studentExamItems)
    {
        this.userId = userId;
        this.studentExamItems = studentExamItems;
    }
}
