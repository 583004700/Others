package com.ry.xk.studentexamresult.service;

import com.ry.xk.response.bo.ExamPaperDetailModule;
import com.ry.xk.response.bo.ExamPaperListModule;
import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.bo.StudentExamList;
import com.ry.xk.studentexamresult.bo.StudentLastExamItem;
import com.ry.xk.studentexamresult.bo.UserResourceList;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public interface IExamPaperService {

    /**
     * 通过测试Id获取做题情况 已做/总数
     * @param studentExamId
     * @return
     */
    public String getAnswerSituation(Long studentExamId);

    /**
     * 获取试卷列表
     * @param status
     * @param courseId
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<ExamPaper> getExamPaper(int partnerId,int status,int courseId,int userId,int pageIndex,int pageSize);

    /**
     * 获取最后一次有效的测试信息
     * @param userResourceList 用户资源数据
     * @param studentExamList 用户测试数据
     * @param examPaperId 试卷Id
     * @return 返回最后一次测试的信息，studentExamId为空代码未测试过
     */
    public StudentLastExamItem getExamPaperLastExam(UserResourceList userResourceList, StudentExamList studentExamList, int examPaperId);

    /**
     * 获取最后一次有效的测试信息
     * @param userId 用户Id
     * @param examPaperId 试卷Id
     * @return
     */
    public StudentLastExamItem getExamPaperLastExam(int userId,int examPaperId);

    /**
     * 获取试卷列表，并组织成controller需要的对象
     * @param status
     * @param courseId
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ExamPaperListModule getExamPaperList(int partnerId,int status, int courseId, int userId, int pageIndex, int pageSize);

    /**
     * 通过examPaperId获取试卷,并组织成controller需要的对象
     * @return
     */
    public ExamPaperDetailModule get(int userId,int examPaperId);
}
