package com.ry.xk.studentexamresult.bo;

import java.util.List;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * <描述类的作用>
 * 
 * @ClassName: ExamSet
 * @author 幸仁强
 * @date 2018年6月1日
 */

public class ExamSet implements ICouchBaseStoredObject
{

    @Tag(1)
    private int examSetId;

    @Tag(2)
    private int examSetValue;

    @Tag(3)
    private List<ExamSetQuestion> examSetQuestions;

    public int getExamSetId()
    {

        return examSetId;
    }

    public void setExamSetId(int examSetId)
    {

        this.examSetId = examSetId;
    }

    public int getExamSetValue()
    {

        return examSetValue;
    }

    public void setExamSetValue(int examSetValue)
    {

        this.examSetValue = examSetValue;
    }

    public List<ExamSetQuestion> getExamSetQuestions()
    {

        return examSetQuestions;
    }

    public void setExamSetQuestions(List<ExamSetQuestion> examSetQuestions)
    {

        this.examSetQuestions = examSetQuestions;
    }

    private static String _key = "ExamSet_%s";

    @Override
    public String key()
    {
        return String.format(keyFormat(), examSetId);
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

    public ExamSet()
    {}

    public ExamSet(int examSetValue)
    {
        this.examSetValue = examSetValue;
    }

}
