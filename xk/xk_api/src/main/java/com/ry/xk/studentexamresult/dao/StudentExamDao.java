package com.ry.xk.studentexamresult.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.DatabaseType;
import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.springbootframe.datasource.MyDataSource;
import com.ry.xk.studentexamresult.bo.StudentExam;
import com.ry.xk.studentexamresult.bo.StudentExamItem;
import com.ry.xk.studentexamresult.bo.StudentExamList;
import com.ry.xk.studentexamresult.mapper.StudentExamMapper;

@Component
public class StudentExamDao implements IStudentExamDao
{
    @Autowired
    StudentExamMapper studentExamMapper;

    @Override
    public StudentExamList getStudentExamList(int userId)
    {
        StudentExamList studentExamList = new StudentExamList();
        studentExamList.setUserId(userId);
        StudentExamList userStudentList = CouchBaseFactory.get(studentExamList.getClass(), studentExamList.key());
        if (userStudentList == null)
        {
            userStudentList = new StudentExamList();
            userStudentList.setUserId(userId);
            userStudentList.setStudentExamItems(new ArrayList<StudentExamItem>());
        }
        return userStudentList;
    }

    @Override
    public boolean updateStudentExamList(StudentExamList studentExamList)
        throws Exception
    {
        return CouchBaseFactory.update(studentExamList);
    }

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public long insertStudentExam(StudentExam studentExam)
        throws Exception
    {
        int result = studentExamMapper.insertStudentExam(studentExam);
        long studentExamId = 0;
        if (result > 0)
        {
            studentExamId = studentExam.getStudentExamId();
            CouchBaseFactory.update(studentExam);
        }
        return studentExamId;
    }

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public StudentExam getStudentExam(long studentExamId)
        throws Exception
    {
        StudentExam studentExam = new StudentExam();
        studentExam.setStudentExamId(studentExamId);
        StudentExam rtnStudentExam = CouchBaseFactory.get(StudentExam.class, studentExam.key());
        if (null == rtnStudentExam)
        {
            rtnStudentExam = studentExamMapper.getStudentExam(studentExamId);
            if (null != rtnStudentExam)
            {
                CouchBaseFactory.update(rtnStudentExam);
            }
        }
        return rtnStudentExam;
    }

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public int updateExamStatusId(long studentExamId)
        throws Exception
    {
        StudentExam studentExam = getStudentExam(studentExamId);
        studentExam.setExamStatusId(CommonConst.EXAMPAPER_SUBMISSION);
        int result = studentExamMapper.updateExamStatusId(CommonConst.EXAMPAPER_SUBMISSION, studentExamId);
        CouchBaseFactory.update(studentExam);
        return result;
    }
}
