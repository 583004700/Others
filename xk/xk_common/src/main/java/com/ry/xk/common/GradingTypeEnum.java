package com.ry.xk.common;

/**
 * 判卷类型枚举
 * 
 * @ClassName: GradingTypeEnum
 * @author 幸仁强
 * @date 2018年6月6日
 */

public enum GradingTypeEnum {
    //0未知 1系统判卷 2人工判卷
    UnKnow(0), Auto(1), Artificial(2);
    private int index;

    GradingTypeEnum(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }
}
