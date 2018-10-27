package com.ry.xk.studentexamresult.service;

import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;

/**
 * 学生测试数据临时缓存业务接口
 * 
 * @ClassName: IExamService
 * @author 幸仁强
 * @date 2018年06月01日
 */
public interface IStudentExamInProgressInfoService
{
    /**
     * 根据加密的ID获取临时缓存数据
     * 
     * @Title: getByEncoderID
     * @author 幸仁强
     * @param encoderId
     * @return
     */
    public StudentExamInProgressInfo getByEncoderID(String encoderId);

    /**
     * 更新临时缓存数据
     * 
     * @Title: update
     * @author 幸仁强
     * @param studentExamInProgressInfo
     * @return
     */
    public boolean update(StudentExamInProgressInfo studentExamInProgressInfo);

    /**
     * 删除临时缓存数据
     * 
     * @Title: remove
     * @author 幸仁强
     * @param studentExamInProgressInfo
     * @return
     */
    public boolean remove(StudentExamInProgressInfo studentExamInProgressInfo);
}
