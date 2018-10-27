package com.ry.xk.response.bo;

/**
 * 知识点 <描述类的作用>
 * 
 * @ClassName: KnowledgePoint
 * @author DELL
 * @date 2018年5月23日
 */
public class KnowledgePoint
{
    /**
     * 知识点名称
     */
    private String KnowledgePointName = "";

    /**
     * 掌握度
     */
    private double KnowledgePointAccuracy;

    public String getKnowledgePointName()
    {

        return KnowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName)
    {

        KnowledgePointName = knowledgePointName;
    }

    public double getKnowledgePointAccuracy()
    {
        return KnowledgePointAccuracy;
    }

    public void setKnowledgePointAccuracy(double knowledgePointAccuracy)
    {
        KnowledgePointAccuracy = knowledgePointAccuracy;
    }
}
