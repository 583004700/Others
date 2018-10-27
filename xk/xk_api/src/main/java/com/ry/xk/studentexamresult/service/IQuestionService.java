package com.ry.xk.studentexamresult.service;

import com.ry.xk.response.bo.ExamPaperAnalysisModule;
import com.ry.xk.response.bo.QuestionCategoryModel;
import com.ry.xk.response.bo.SubQuestionInfo;
import com.ry.xk.studentexamresult.bo.OptionGroupResult;
import com.ry.xk.studentexamresult.bo.StudentGroupAnswer;
import org.springframework.stereotype.Service;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;

import java.util.List;

@Service
public interface IQuestionService {
    /**
     * 获取题目解析
     * @param studentExamId
     * @param questionId
     * @return
     */
    public ExamPaperAnalysisModule getExamPaperAnalysisModule(int userId,long studentExamId, int questionId) throws Exception;

    /**
     * 组装小题数据
     *
     * @param optionGroupResults
     * @param studentGroupAnswers
     * @return
     */
    public List<SubQuestionInfo> fitQuestionGroups(Question question, List<OptionGroupResult> optionGroupResults, List<StudentGroupAnswer> studentGroupAnswers);

    /**
     * 组装题型实体
     *
     * @Title: installQuestionCategory
     * @author
     * @param questionCategoryId
     * @return
     * @throws Exception
     */
    public QuestionCategoryModel installQuestionCategory(int questionCategoryId)
            throws Exception;
}
