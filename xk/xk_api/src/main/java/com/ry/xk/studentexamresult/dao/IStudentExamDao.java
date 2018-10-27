package com.ry.xk.studentexamresult.dao;

import org.springframework.stereotype.Component;

import com.ry.xk.studentexamresult.bo.StudentExam;
import com.ry.xk.studentexamresult.bo.StudentExamList;

@Component
public interface IStudentExamDao
{
    /**
     * 通过userId获取学生测试纪录缓存列表，用于填充状态
     * 
     * @param userId
     * @return
     */
    public StudentExamList getStudentExamList(int userId);

    /**
     * 更新学生测试纪录缓存信息，用于填充状态
     * 
     * @param studentExamList
     * @return
     */
    public boolean updateStudentExamList(StudentExamList studentExamList)
        throws Exception;

    /**
     * 插入StudentExam表数据
     * 
     * @Title: insertStudentExam
     * @author 幸仁强
     * @return
     */
    public long insertStudentExam(StudentExam studentExam)
        throws Exception;

    /**
     * 获取StudentExam表数据
     * 
     * @Title: getStudentExam
     * @author 幸仁强
     * @return
     */
    public StudentExam getStudentExam(long studentExamId)
        throws Exception;

    /**
     * 更新学生测试状态为已提交
     * 
     * @Title: updateStudentExam
     * @author 幸仁强
     * @param studentExam
     * @return
     * @throws Exception
     */
    public int updateExamStatusId(long studentExamId)
        throws Exception;
}
