package com.ry.xk.studentexamresult.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;

@Component
public class StudentExamInProgressInfoDao implements IStudentExamInProgressInfoDao
{
    @Override
    public StudentExamInProgressInfo get(long studentExamId)
    {
        StudentExamInProgressInfo studentExamInProgressInfo = new StudentExamInProgressInfo();
        studentExamInProgressInfo.setStudentExamId(studentExamId);
        StudentExamInProgressInfo newstudentExamInProgressInfo = CouchBaseFactory.get(studentExamInProgressInfo.getClass(), studentExamInProgressInfo.key());
        return newstudentExamInProgressInfo;
    }

    @Override
    public boolean update(StudentExamInProgressInfo studentExamInProgressInfo)
        throws Exception
    {
        return CouchBaseFactory.update(studentExamInProgressInfo);
    }

    @Override
    public boolean remove(StudentExamInProgressInfo studentExamInProgressInfo)
        throws Exception
    {
        return CouchBaseFactory.remove(studentExamInProgressInfo.couchbaseSection(), studentExamInProgressInfo.key());
    }

}
