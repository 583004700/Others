package com.ry.xk.studentexamresult.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.common.DatabaseType;
import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.springbootframe.datasource.MyDataSource;
import com.ry.xk.studentexamresult.bo.StudentExamResult;
import com.ry.xk.studentexamresult.mapper.StudentExamResultMapper;

@Component
public class StudentExamResultDao implements IStudentExamResultDao
{
    @Autowired
    StudentExamResultMapper studentExamResultMapper;

    @Override
    public StudentExamResult get(long studentExamId)
    {
        StudentExamResult studentExamResult = new StudentExamResult();
        studentExamResult.setStudentExamId(studentExamId);
        StudentExamResult newStudentExamResult = CouchBaseFactory.get(studentExamResult.getClass(), studentExamResult.key());
        return newStudentExamResult;
    }

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public boolean insert(StudentExamResult studentExamResult)
    {
        studentExamResultMapper.insert(studentExamResult);
        return CouchBaseFactory.update(studentExamResult);
    }
}
