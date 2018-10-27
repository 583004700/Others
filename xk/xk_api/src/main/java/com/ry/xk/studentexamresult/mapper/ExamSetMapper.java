package com.ry.xk.studentexamresult.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.xk.studentexamresult.bo.ExamSet;
import com.ry.xk.studentexamresult.bo.ExamSetQuestion;

/**
 * 题集mapper
 * 
 * @author 幸仁强
 */
@Mapper
public interface ExamSetMapper
{
    /**
     * 获取ExamSet数据
     * @Title: getExamSet
     * @author 幸仁强
     * @param examSetId
     * @return
     */
    public ExamSet getExamSet(@Param("examSetId") int examSetId);

    /**
     * 根据测验ID获取题目信息
     * @Title: getExamSetQuestions
     * @author 幸仁强
     * @param examSetId
     * @return
     */
    public List<ExamSetQuestion> getExamSetQuestions(@Param("examSetId") int examSetId);

    /**
     * 插入ExamSet
     * 
     * @Title: insertExamSet
     * @author 幸仁强
     * @return
     */
    public int insertExamSet(ExamSet examSet);

    /**
     * 插入ExamSetQuestion
     * 
     * @Title: insertExamSetQuestions
     * @author 幸仁强
     * @return
     */
    public int insertExamSetQuestions(List<ExamSetQuestion> examSetQuestions);

}