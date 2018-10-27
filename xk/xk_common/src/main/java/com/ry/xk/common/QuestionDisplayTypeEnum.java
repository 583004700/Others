package com.ry.xk.common;

/**
 * 题目展示形式
 * 
 * @ClassName: QuestionDisplayTypeEnum
 * @author 幸仁强
 * @date 2018年6月6日
 */

public enum QuestionDisplayTypeEnum {
    // 1简单的选择题（单选，判断）
    // 2不定项选择题（多选题）
    // 3多题干多小题，包括题干（复2）阅读理解
    // 4单题干多小题没有题干（复4）完形填空
    // 5填空题
    // 6简答题
    // 7多题干简答题（复1）
    // 8多题干填空题（复3）
    // 9判断题
    // 10阅读填空
    // 11改错
    // 12多选(复)
    // 13判断(复)
    // 14选择填充
    // 15混合复杂
    // 16辨析改错
    // 17辨析改错(复)
    SingleSection(1), MultiSection(2), MultiGroupIncluedText(3), MultiGroupOnlyOption(4), Completion(5), ShortAnswer(6), MultiShortAnswer(7), SingleAnswer(8), Judgement(9), ReadAndFillBlank(
        10), Correction(11), ComplexMultiSection(12), ComplexJudge(13), SingleSectionWithText(14), ComplexGroup(15), DiscriminateCorrection(16), ComplexDiscriminateCorrection(17);

    private int index;

    QuestionDisplayTypeEnum(int index)
    {
        this.index = index;
    }

    public int getIndex()
    {
        return this.index;
    }

    public static QuestionDisplayTypeEnum convertThis(int iv)
    {
        for (QuestionDisplayTypeEnum e : QuestionDisplayTypeEnum.values())
        {
            if (e.getIndex() == iv)
            {
                return e;
            }
        }
        return null;
    }
}
