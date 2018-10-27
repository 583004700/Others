package com.ry.xk.response.bo;

/**
 * 获取所有学科的错题本数量 <描述类的作用>
 * 
 * @ClassName: CourseWrongCountModule
 * @author DELL
 * @date 2018年5月23日
 */
public class CourseWrongCountModule
{
    /**
     * 学科ID
     */
    private String courseId = "";

    /**
     * 学科图标标识
     */
    private String shortCode = "";

    /**
     * 学科名称
     */
    private String courseName = "";

    /**
     * 错题数量
     */
    private int wrongCount;

    public String getCourseId()
    {

        return courseId;
    }

    public void setCourseId(String courseId)
    {

        this.courseId = courseId;
    }

    public String getShortCode()
    {

        return shortCode;
    }

    public void setShortCode(String shortCode)
    {

        this.shortCode = shortCode;
    }

    public String getCourseName()
    {

        return courseName;
    }

    public void setCourseName(String courseName)
    {

        this.courseName = courseName;
    }

    public int getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(int wrongCount) {
        this.wrongCount = wrongCount;
    }
}
