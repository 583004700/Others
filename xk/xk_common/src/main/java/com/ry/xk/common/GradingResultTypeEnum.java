package com.ry.xk.common;

/**
 * 判卷结果枚举
 * 
 * @ClassName: GradingResultTypeEnum
 * @author 幸仁强
 * @date 2018年6月6日
 */

public enum GradingResultTypeEnum {
    //0未判卷，1正确，2半对，3错误
    UnGrading(0), Correct(1), PartiallyCorrect(2), Wrong(3);
    private int index;

    GradingResultTypeEnum(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }
}
