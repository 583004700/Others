package com.ry.xk.studentexamresult.service;

import com.ry.xk.request.bo.QuestionInfoApiRequest;
import com.ry.xk.request.bo.SubmitDoQuestionInfo;
import com.ry.xk.response.bo.QuestionInfoModule;

/**
 * 考试题目业务接口
 * 
 * @ClassName: IExamQuestionService
 * @author 幸仁强
 * @date 2018年06月01日
 */
public interface IExamQuestionService
{
    /**
     * 获取题目信息
     * 
     * @Title: getExamItem
     * @author 幸仁强
     * @param questionInfoApiRequest
     * @return
     * @throws Exception
     */
    public QuestionInfoModule getExamItem(QuestionInfoApiRequest questionInfoApiRequest)
        throws Exception;

    /**
     * 提交题目
     * 
     * @Title: finishExamItem
     * @author 幸仁强
     * @param request
     * @return
     * @throws Exception
     */
    public boolean saveExamItem(SubmitDoQuestionInfo request)
        throws Exception;

}
