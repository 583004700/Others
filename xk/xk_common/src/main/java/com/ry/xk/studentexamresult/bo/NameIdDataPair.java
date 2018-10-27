package com.ry.xk.studentexamresult.bo;

import java.util.List;

/**
 * <描述类的作用>
 * 
 * @ClassName: NameIdDataPair
 * @author 幸仁强
 * @date 2018年6月6日
 */

public class NameIdDataPair
{
    // id
    private int id;

    // 加密ID
    private String ecodeId;

    // 对象名字
    private String name;

    // 对象值
    private double value;

    // 学生数量
    private int studentCount;

    // 相关的id集合
    private List<Integer> referenceIds;

    // 父节点Id（用于知识点使用）
    private int parentId;

    // 说明
    private String content;

    public int getId()
    {

        return id;
    }

    public void setId(int id)
    {

        this.id = id;
    }

    public String getEcodeId()
    {

        return ecodeId;
    }

    public void setEcodeId(String ecodeId)
    {

        this.ecodeId = ecodeId;
    }

    public String getName()
    {

        return name;
    }

    public void setName(String name)
    {

        this.name = name;
    }

    public double getValue()
    {

        return value;
    }

    public void setValue(double value)
    {

        this.value = value;
    }

    public int getStudentCount()
    {

        return studentCount;
    }

    public void setStudentCount(int studentCount)
    {

        this.studentCount = studentCount;
    }

    public List<Integer> getReferenceIds()
    {

        return referenceIds;
    }

    public void setReferenceIds(List<Integer> referenceIds)
    {

        this.referenceIds = referenceIds;
    }

    public int getParentId()
    {

        return parentId;
    }

    public void setParentId(int parentId)
    {

        this.parentId = parentId;
    }

    public String getContent()
    {

        return content;
    }

    public void setContent(String content)
    {

        this.content = content;
    }

    public NameIdDataPair()
    {

    }

    public NameIdDataPair(int id, String name, double value)
    {
        this.id = id;
        this.name = name;
        this.value = value;

    }

    public NameIdDataPair(int id, String name, double value, int studentCount, List<Integer> referenceIds)
    {
        this.id = id;
        this.name = name;
        this.value = value;
        this.studentCount = studentCount;
        this.referenceIds = referenceIds;
    }
}
