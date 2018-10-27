package com.ry.xk.studentexamresult.service;

import com.ry.xk.response.bo.ExamModule;

/**
 * 测试业务接口
 * 
 * @ClassName: IExamService
 * @author 幸仁强
 * @date 2018年06月01日
 */
public interface IExamService
{
    /**
     * 验证测试是否属于某个用户
     * @param userId
     * @param studentExamId
     * @return
     */
    public boolean validateExamAndUser(int userId,long studentExamId);

    /**
     * 获取测试基本信息
     * @param studentExamId
     * @return
     */
    public ExamModule get(int userId, long studentExamId) throws Exception;
}
