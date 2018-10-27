package com.ry.xk.studentexamresult.mapper;

import com.ry.xk.studentexamresult.bo.ExamPaper;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 试卷mapper
 */
@Mapper
public interface ExamPaperMapper
{
    /**
     * 通过学科ID获取ExamPaper列表数据，包含已购买和未购买
     * 
     * @return
     */
    public List<ExamPaper> getExamPaper(@Param("partnerId") int partnerId,@Param("courseId") int courseId, @Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    /**
     * 通过学科ID和用户ID获取用户已购买的ExamPaper列表数据
     * 
     * @return
     */

    public List<ExamPaper> getBuyExamPaper(@Param("partnerId") int partnerId,@Param("courseId") int courseId,@Param("userId")int userId,@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);

    /**
     * 通过试卷ID获取试卷详情记录
     * 
     * @return
     */
    public ExamPaper get(int examPaperId);

    /**
     * 通过学科ID和机构ID获取试卷ID
     * 
     * @return
     */
    public int getPackExamPaperIdByCourseIdAndPartnerId(@Param("courseId") int courseId, @Param("partnerId") int partnerId);

}