package com.ry.xk.response.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * <描述类的作用>
 * 
 * @ClassName: QuestionAnswerModel
 * @author 幸仁强
 * @date 2018年5月24日
 */

public class QuestionAnswerModel
{
    // 正确答案
    private List<QuestionAnswerItemModel> correctAnswerList = new ArrayList<QuestionAnswerItemModel>();

    // 是否正确
    private boolean isCorrectAnswer;

    //作业批改状态
    private int correctStatus;

    // 学生答案
    private List<StudentAnswerModel> studentAnswerList = new ArrayList<StudentAnswerModel>();

    public List<QuestionAnswerItemModel> getCorrectAnswerList()
    {

        return correctAnswerList;
    }

    public void setCorrectAnswerList(List<QuestionAnswerItemModel> correctAnswerList)
    {

        this.correctAnswerList = correctAnswerList;
    }

    @JsonProperty(value = "isCorrectAnswer")
    public boolean getIsCorrectAnswer()
    {

        return isCorrectAnswer;
    }

    public void setIsCorrectAnswer(boolean isCorrectAnswer)
    {

        this.isCorrectAnswer = isCorrectAnswer;
    }

    public int getCorrectStatus() {
        return correctStatus;
    }

    public void setCorrectStatus(int correctStatus) {
        this.correctStatus = correctStatus;
    }

    public List<StudentAnswerModel> getStudentAnswerList()
    {

        return studentAnswerList;
    }

    public void setStudentAnswerList(List<StudentAnswerModel> studentAnswerList)
    {

        this.studentAnswerList = studentAnswerList;
    }

    public void setCorrectAnswer(boolean isCorrectAnswer)
    {

        this.isCorrectAnswer = isCorrectAnswer;
    }

}
