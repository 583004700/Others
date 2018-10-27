package com.ry.xk.studentexamresult.service;


import com.ry.xk.response.bo.CourseWrongCountModule;
import com.ry.xk.response.bo.ExamPaperAnalysisModule;
import com.ry.xk.response.bo.WrongBookItemModule;
import com.ry.xk.studentexamresult.bo.WrongBook;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IWrongBookService
{
    /**
     * 获取用户所有学科的错题本
     * @return
     */
    public List<WrongBook> getUserWrongBook(int partnerId, int userId, int courseTypeId);

    /**
     * 获取学科和对应错题数量
     * @param partnerId
     * @param courseTypeId
     * @return
     */
    public List<CourseWrongCountModule> getCourseWrongCounts(int partnerId, int userId, int courseTypeId);

    /**
     * 获取错题列表给controller层
     * @param userId
     * @param courseId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<WrongBookItemModule> getWrongBookItemModules(int userId, int courseId, int pageIndex, int pageSize) throws Exception;

    /**
     * 获取错题本详情，返回给Controller层
     *
     * @param userId
     * @param courseId
     * @param questionId
     * @return
     */
    public ExamPaperAnalysisModule getWrongBookDetail(int userId, int courseId, int questionId)
            throws Exception;

    /**
     * 删除错题本错题
     * @param userId
     * @param courseId
     * @param questionId
     * @return
     */
    public boolean deleteWrongQuestion(int userId,int courseId,int questionId);
}
