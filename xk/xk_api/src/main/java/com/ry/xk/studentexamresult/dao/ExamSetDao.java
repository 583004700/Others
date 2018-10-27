package com.ry.xk.studentexamresult.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.common.DatabaseType;
import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.springbootframe.datasource.MyDataSource;
import com.ry.xk.studentexamresult.bo.ExamSet;
import com.ry.xk.studentexamresult.bo.ExamSetQuestion;
import com.ry.xk.studentexamresult.mapper.ExamSetMapper;

/**
 * 测验mapper
 * 
 * @author 幸仁强
 */
@Component
public class ExamSetDao implements IExamSetDao
{
    @Autowired
    ExamSetMapper examSetMapper;

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public ExamSet getExamSet(int examSetId)
        throws Exception
    {
        ExamSet examSet = new ExamSet();
        examSet.setExamSetId(examSetId);
        ExamSet rtnExamSet = CouchBaseFactory.get(ExamSet.class, examSet.key());
        if (null == rtnExamSet)
        {
            rtnExamSet = examSetMapper.getExamSet(examSetId);
            if (null != rtnExamSet)
            {
                List<ExamSetQuestion> examSetQuestions = examSetMapper.getExamSetQuestions(examSetId);
                if (null != examSetQuestions && examSetQuestions.size() > 0)
                {
                    rtnExamSet.setExamSetQuestions(examSetQuestions);
                    CouchBaseFactory.update(rtnExamSet);
                }
                else
                {
                    return null;
                }
            }
        }
        return rtnExamSet;
    }

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public int insertExamSet(ExamSet examSet)
        throws Exception
    {
        int result = examSetMapper.insertExamSet(examSet);
        if (result > 0)
        {
            int examSetId = examSet.getExamSetId();
            return examSetId;
        }
        return 0;
    }

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public boolean updateExamSet(ExamSet examSet)
        throws Exception
    {
        int result = examSetMapper.insertExamSetQuestions(examSet.getExamSetQuestions());
        if (result > 0 && result == examSet.getExamSetQuestions().size())
        {
            CouchBaseFactory.update(examSet);
            return true;
        }
        return false;

    }
}