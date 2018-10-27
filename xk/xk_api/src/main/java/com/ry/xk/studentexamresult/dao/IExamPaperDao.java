package com.ry.xk.studentexamresult.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ry.xk.studentexamresult.bo.ExamPaper;

@Component
public interface IExamPaperDao
{
    /**
     * 通过学科ID获取ExamPaper列表数据，包含已购买和未购买
     * 
     * @return
     */
    public List<ExamPaper> getExamPaper(int partnerId, int courseId, int startIndex, int pageSize);

    /**
     * 通过学科ID和用户ID获取用户已购买的ExamPaper列表数据
     * 
     * @return
     */
    public List<ExamPaper> getBuyExamPaper(int partnerId, int courseId, int userId, int startIndex, int pageSize);

    /**
     * 通过examPaperId获取试卷
     * 
     * @return
     */
    public ExamPaper get(int examPaperId);

    /**
     * 通过courseId和partnerId获取试卷
     * 
     * @return
     */
    public int getPackExamPaperIdByCourseIdAndPartnerId(int courseId, int partnerId);
}
