package com.ry.xk.studentexamresult.mapper;

import org.mapstruct.Mapper;

import com.ry.xk.studentexamresult.bo.StudentExamResult;

/**
 * 学生测试结果mapper
 * 
 * @author 幸仁强
 */
@Mapper
public interface StudentExamResultMapper
{
    /**
     * 插入测试结果
     * 
     * @Title: insertStudentExam
     * @author 幸仁强
     * @return
     */
    public int insert(StudentExamResult studentExamResult);

}