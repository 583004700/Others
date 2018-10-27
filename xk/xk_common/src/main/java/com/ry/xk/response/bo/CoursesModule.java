package com.ry.xk.response.bo;

/**
 * 获取学科列表输出实体类 <描述类的作用>
 * 
 * @ClassName: CoursesModule
 * @author DELL
 * @date 2018年5月22日
 */
public class CoursesModule
{
    /**
     * 学科ID
     */
    private String courseId;

    /**
     * 学科名称
     */
    private String courseName;

    /**
     * 学科图标标识
     */
    private String shortCode;

    public CoursesModule(){};

    public CoursesModule(String courseId,String courseName,String shortCode){
        this.courseId = courseId;
        this.courseName = courseName;
        this.shortCode = shortCode;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName()
    {

        return courseName;
    }

    public void setCourseName(String courseName)
    {

        this.courseName = courseName;
    }

    public String getShortCode()
    {

        return shortCode;
    }

    public void setShortCode(String shortCode)
    {

        this.shortCode = shortCode;
    }

}
