package com.ry.xk.studentexamresult.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;

@Component
public interface IStudentExamInProgressInfoDao
{
    /**
     * 从缓存中获取学生答题情况
     * 
     * @param studentExamId
     * @return
     */
    public StudentExamInProgressInfo get(long studentExamId);

    /**
     * 更新学生作答临时缓存信息
     * 
     * @Title: update
     * @author 幸仁强
     * @param studentExamInProgressInfo
     * @return
     * @throws Exception
     */
    public boolean update(StudentExamInProgressInfo studentExamInProgressInfo)
        throws Exception;

    /**
     * 删除作答临时缓存信息
     * 
     * @Title: remove
     * @author 幸仁强
     * @param studentExamInProgressInfo
     * @return
     * @throws Exception
     */
    public boolean remove(StudentExamInProgressInfo studentExamInProgressInfo)
        throws Exception;
}