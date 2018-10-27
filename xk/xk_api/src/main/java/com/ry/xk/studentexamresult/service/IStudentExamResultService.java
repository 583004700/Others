package com.ry.xk.studentexamresult.service;

import com.ry.xk.response.bo.AnalysisAnswerSheets;
import com.ry.xk.response.bo.ExamResultModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentExamResultService {
    /**
     * 通过测试ID获取本次测试的测评信息
     * @param studentExamId
     * @return
     */
    public ExamResultModule getExamResult(int userId,long studentExamId) throws Exception;

    /**
     * 获取测试解析信息
     *
     * @param studentExamId
     * @return
     */
    public List<AnalysisAnswerSheets> getAnalysisAnswerSheets(int userId,long studentExamId) throws Exception;
}
