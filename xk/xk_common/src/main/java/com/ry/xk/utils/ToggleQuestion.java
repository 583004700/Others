package com.ry.xk.utils;

import java.util.List;

/**
 * 切题统一采用在数组中的下标切题
 */
public class ToggleQuestion<T extends ToggleQuestionInterface> {
    //题集
    private List<T> questions;
    public ToggleQuestion(List<T> questions){
        this.questions = questions;
    }
    /**
     * 得到下一个题目
     * @param question
     * @return
     */
    public T getNextQuestion(T question){
        int currentIndex = -1;
        for(int i=0;i<questions.size();i++){
            if(question.questionId() == questions.get(i).questionId()){
                currentIndex = i;
            }
        }
        int nextIndex = currentIndex + 1;
        if(nextIndex < questions.size() && currentIndex != -1){
            return questions.get(nextIndex);
        }
        return null;
    }

    /**
     * 得到上一个题目
     * @param question
     * @return
     */
    public T getPreviousQuestion(T question){
        int currentIndex = -1;
        for(int i=0;i<questions.size();i++){
            if(question.questionId() == questions.get(i).questionId()){
                currentIndex = i;
            }
        }
        int previousIndex = currentIndex - 1;
        if(previousIndex >= 0 && currentIndex != -1){
            return questions.get(previousIndex);
        }
        return null;
    }
}
