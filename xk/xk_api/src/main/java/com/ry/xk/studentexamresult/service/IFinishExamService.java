package com.ry.xk.studentexamresult.service;

import com.ry.xk.request.bo.ExamApiRequest;

/**
 * 交卷业务接口
 * 
 * @ClassName: IFinishExamService
 * @author 幸仁强
 * @date 2018年06月01日
 */
public interface IFinishExamService
{
    /**
     * 提交试卷
     * 
     * @Title: finishExam
     * @author 幸仁强
     * @param request
     * @return
     * @throws Exception
     */
    public boolean finishExam(ExamApiRequest examApiRequest)
        throws Exception;

}
