package com.ry.xk.response.bo;

/**
 * <描述类的作用>
 * 
 * @ClassName: QuestionAnswerItemModel
 * @author 幸仁强
 * @date 2018年5月24日
 */

public class QuestionAnswerItemModel
{
    //答案
    private String answer;
    //序号
    private int order;
    public String getAnswer()
    {
    
        return answer;
    }
    public void setAnswer(String answer)
    {
    
        this.answer = answer;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
