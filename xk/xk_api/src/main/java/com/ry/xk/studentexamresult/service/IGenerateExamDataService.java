package com.ry.xk.studentexamresult.service;

import com.ry.xk.request.bo.GenerateExamDataRequest;

/**
 * 测试业务接口
 * 
 * @ClassName: IExamService
 * @author 幸仁强
 * @date 2018年06月01日
 */
public interface IGenerateExamDataService
{
    /**
     * 校验并生成返回学生测试ID(如有存在该试卷正在考试的的数据则直接返回该考试ID，否则生成考试相关数据返回考试ID)
     * 
     * @Title: checkAndGenerateExamData
     * @author 幸仁强
     * @param generateExamDataRequest
     * @return
     * @throws Exception
     */
    public long checkAndGenerateExamData(GenerateExamDataRequest generateExamDataRequest)
        throws Exception;

    /**
     * 传入用户ID和试卷ID校验是否购买该试卷
     * 
     * @Title: isBuy
     * @author 幸仁强
     * @param userId
     * @param examPaperId
     * @return
     */
    public boolean isBuy(int userId, int examPaperId);

    /**
     * 传入用胡ID和试卷ID获得正在考试的ID
     * 
     * @Title: getDoingStudentExamId
     * @author 幸仁强
     * @param userId
     * @param examPaperId
     * @return
     */
    public long getDoingStudentExamId(int userId, int examPaperId);

}
