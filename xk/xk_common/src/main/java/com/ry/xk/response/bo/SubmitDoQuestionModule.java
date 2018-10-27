package com.ry.xk.response.bo;

public class SubmitDoQuestionModule
{
    /**
     * 结果返回枚举
     */
    private int result;

    /**
     * 模拟测试状态
     */
    private int examStatus;

    public int getResult()
    {

        return result;
    }

    public void setResult(int result)
    {

        this.result = result;
    }

    public int getExamStatus()
    {

        return examStatus;
    }

    public void setExamStatus(int examStatus)
    {

        this.examStatus = examStatus;
    }

    public SubmitDoQuestionModule()
    {}

    public SubmitDoQuestionModule(int result)
    {
        this.result = result;
    }

}
