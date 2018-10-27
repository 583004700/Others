package com.ry.xk.studentexamresult.bo;

/**
 * 题目类型
 * 
 * @ClassName: QuestionCategory
 * @author 幸仁强
 * @date 2018年6月4日
 */
public class QuestionCategory
{
    private boolean isAllowAdd;

    private int courseId;

    private boolean isEnabled;

    private int orderIndex;

    private String parentCategoryId;

    private int questionCategoryId;

    private int questionCategoryModelId;

    private String questionCategoryName;

    private int questionDisplayTypeId;

    private int rootCategoryId;

    public boolean getIsAllowAdd()
    {

        return isAllowAdd;
    }

    public void setIsAllowAdd(boolean isAllowAdd)
    {

        this.isAllowAdd = isAllowAdd;
    }

    public int getCourseId()
    {

        return courseId;
    }

    public void setCourseId(int courseId)
    {

        this.courseId = courseId;
    }

    public boolean getIsEnabled()
    {

        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled)
    {

        this.isEnabled = isEnabled;
    }

    public int getOrderIndex()
    {

        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {

        this.orderIndex = orderIndex;
    }

    public String getParentCategoryId()
    {

        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId)
    {

        this.parentCategoryId = parentCategoryId;
    }

    public int getQuestionCategoryId()
    {

        return questionCategoryId;
    }

    public void setQuestionCategoryId(int questionCategoryId)
    {

        this.questionCategoryId = questionCategoryId;
    }

    public int getQuestionCategoryModelId()
    {

        return questionCategoryModelId;
    }

    public void setQuestionCategoryModelId(int questionCategoryModelId)
    {

        this.questionCategoryModelId = questionCategoryModelId;
    }

    public String getQuestionCategoryName()
    {

        return questionCategoryName;
    }

    public void setQuestionCategoryName(String questionCategoryName)
    {

        this.questionCategoryName = questionCategoryName;
    }

    public int getQuestionDisplayTypeId()
    {

        return questionDisplayTypeId;
    }

    public void setQuestionDisplayTypeId(int questionDisplayTypeId)
    {

        this.questionDisplayTypeId = questionDisplayTypeId;
    }

    public int getRootCategoryId()
    {

        return rootCategoryId;
    }

    public void setRootCategoryId(int rootCategoryId)
    {

        this.rootCategoryId = rootCategoryId;
    }

}
