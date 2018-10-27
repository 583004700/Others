package com.ry.xk.studentexamresult.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.studentexamresult.bo.ExamSet;

/**
 * 测验数据层接口
 * 
 * @author 幸仁强
 */
@Component
public interface IExamSetDao
{

    /**
     * 获取ExamSet数据
     * 
     * @Title: getExamSet
     * @author 幸仁强
     * @param examSetId
     * @return
     */
    public ExamSet getExamSet(int examSetId)
        throws Exception;

    /**
     * 插入ExamSet
     * 
     * @Title: insertExamSet
     * @author 幸仁强
     * @return
     */
    public int insertExamSet(ExamSet examSet)
        throws Exception;

    /**
     * 更新ExamSet
     * 
     * @Title: updateExamSet
     * @author 幸仁强
     * @return
     */
    public boolean updateExamSet(ExamSet examSet)
        throws Exception;

}