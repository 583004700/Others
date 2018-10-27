package com.ry.xk.studentexamresult.mapper;

import com.ry.xk.studentexamresult.bo.ExamPaperQuestion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ExamPaperQuestionMapper {
    /**
     * 通过试卷Id获取题目信息
     * @param examPaperId
     * @return
     */
    public List<ExamPaperQuestion> getByExamPaperId(int examPaperId);
}
