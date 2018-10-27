package com.ry.xk.studentexamresult.dao;


import com.ry.xk.studentexamresult.bo.StudentExamResult;
import org.springframework.stereotype.Component;

/**
 * 从缓存中获取一个StudentExamResult对象
 */
@Component
public interface IStudentExamResultDao
{
    /**
     * 获取考试结果缓存对象
     * @Title: get
     * @author 幸仁强
     * @param studentExamId
     * @return
     */
    public StudentExamResult get(long studentExamId);
    
    /**
     * 更新考试结果缓存对象
     * @Title: update
     * @author 幸仁强
     * @param studentExamResult
     * @return
     */
    public boolean insert(StudentExamResult studentExamResult);
}
