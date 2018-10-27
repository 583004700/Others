package com.ry.xk.response.bo;

import java.util.List;

/**
 * 获取试卷列表的输出参数实体类 <描述类的作用>
 * 
 * @ClassName: ExamPaperListModule
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamPaperListModule
{
    /**
     * 试卷总价格
     */
    private String totalPrice;

    /**
     * 是否已全套购买
     */
    private boolean isBuyAll;

    /**
     * 试卷列表
     */
    private List<ExamPaper> paperList;

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setIsBuyAll(boolean isBuyAll){
        this.isBuyAll = isBuyAll;
    }

    public boolean getIsBuyAll(){
        return isBuyAll;
    }

    public List<ExamPaper> getPaperList()
    {

        return paperList;
    }

    public void setPaperList(List<ExamPaper> paperList)
    {

        this.paperList = paperList;
    }

}
