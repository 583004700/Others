package com.ry.xk.common;

/**
 * 判卷类型枚举
 * 
 * @ClassName: GradingTypeEnum
 * @author 幸仁强
 * @date 2018年6月6日
 */

public enum QuestionDoingStatusEnum {
    //0未知 1未做 2已做 3未交
    UnKnow(0), Undo(1), Done(2), UnHand(3);
    private int index;

    QuestionDoingStatusEnum(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }
}
