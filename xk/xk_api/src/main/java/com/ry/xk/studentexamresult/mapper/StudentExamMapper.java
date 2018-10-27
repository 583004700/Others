package com.ry.xk.studentexamresult.mapper;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.xk.studentexamresult.bo.StudentExam;

/**
 * 学生测试mapper
 * 
 * @author 幸仁强
 */
@Mapper
public interface StudentExamMapper
{
    /**
     * StudentExam
     * 
     * @Title: insertStudentExam
     * @author 幸仁强
     * @return
     */
    public int insertStudentExam(StudentExam studentExam);

    /**
     * getStudentExam
     * 
     * @Title: getStudentExam
     * @author 幸仁强
     * @return
     */
    public StudentExam getStudentExam(@Param("studentExamId") long studentExamId);

    /**
     * 更新学生测试表信息状态为已交
     * 
     * @Title: updateStudentExam
     * @author 幸仁强
     * @param studentExam
     * @return
     */
    public int updateExamStatusId(@Param("examStatusId") int examStatusId, @Param("studentExamId") long studentExamId);

}