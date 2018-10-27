package com.ry.xk.studentexamresult.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ry.xk.common.DatabaseType;
import com.ry.xk.springbootframe.datasource.MyDataSource;
import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.bo.ExamPaperQuestion;
import com.ry.xk.studentexamresult.mapper.ExamPaperMapper;
import com.ry.xk.studentexamresult.mapper.ExamPaperQuestionMapper;
import com.ry.xk.utils.CacheUtil;

@Component
public class ExamPaperDao implements IExamPaperDao
{

    private static final Logger log = LoggerFactory.getLogger(ExamPaperDao.class);

    @Autowired
    ExamPaperMapper examPaperMapper;

    @Autowired
    ExamPaperQuestionMapper examPaperQuestionMapper;

    /**
     * 通过学科ID获取ExamPaper列表数据，包含已购买和未购买
     * 
     * @return
     */
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public List<ExamPaper> getExamPaper(int partnerId, int courseId, int startIndex, int pageSize)
    {
        return examPaperMapper.getExamPaper(partnerId, courseId, startIndex, pageSize);
    }

    /**
     * 通过学科ID和用户ID获取用户已购买的ExamPaper列表数据
     * 
     * @return
     */
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public List<ExamPaper> getBuyExamPaper(int partnerId, int courseId, int userId, int startIndex, int pageSize)
    {
        return examPaperMapper.getBuyExamPaper(partnerId, courseId, userId, startIndex, pageSize);
    }

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public ExamPaper get(int examPaperId)
    {
        ExamPaper examPaper = new ExamPaper();
        examPaper.setExamPaperId(examPaperId);
        ExamPaper newExamPaper = CacheUtil.get(examPaper, () -> {
            ExamPaper fullExamPaper = examPaperMapper.get(examPaperId);
            if (fullExamPaper != null)
            {
                List<ExamPaperQuestion> examPaperQuestions = examPaperQuestionMapper.getByExamPaperId(examPaperId);
                fullExamPaper.setExampaperquestion(examPaperQuestions);
            }
            return fullExamPaper;
        });
        if (newExamPaper != null && newExamPaper.getExampaperquestion() == null)
        {
            newExamPaper.setExampaperquestion(new ArrayList<ExamPaperQuestion>());
        }
        return newExamPaper;
    }

    @Override
    @MyDataSource(type = DatabaseType.EXAMRESULT)
    public int getPackExamPaperIdByCourseIdAndPartnerId(int courseId, int partnerId)
    {
        return examPaperMapper.getPackExamPaperIdByCourseIdAndPartnerId(courseId, partnerId);
    }
}
