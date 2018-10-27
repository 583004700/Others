package com.ry.xk.studentexamresult.service;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;
import com.ry.xk.studentexamresult.dao.IStudentExamInProgressInfoDao;
import com.ry.xk.utils.UrlUtil;

/**
 * 测试业务类
 * 
 * @ClassName: ExamService
 * @author 幸仁强
 * @date 2018年06月01日
 */
@Service
public class StudentExamInProgressInfoService implements IStudentExamInProgressInfoService
{
    private static final Logger log = LoggerFactory.getLogger(StudentExamInProgressInfoService.class);

    @Autowired
    IStudentExamInProgressInfoDao studentExamInProgressInfoDao;

    @Override
    public StudentExamInProgressInfo getByEncoderID(String encoderId)
    {
        long studentExamId = UrlUtil.idDecrypt(encoderId, Long.class);
        if (studentExamId == 0)
        {
            log.error(MessageFormat.format("studentExamID为{0}的测试ID解析错误", encoderId));
            return null;
        }

        StudentExamInProgressInfo studentExamInProgressInfo = studentExamInProgressInfoDao.get(studentExamId);
        if (null == studentExamInProgressInfo)
        {
            log.error(MessageFormat.format("学生测试ID为{0}的做题临时缓存获取失败", studentExamId));
            return null;
        }
        return studentExamInProgressInfo;
    }

    @Override
    public boolean update(StudentExamInProgressInfo studentExamInProgressInfo)
    {
        try
        {
            return studentExamInProgressInfoDao.update(studentExamInProgressInfo);
        }
        catch (Exception e)
        {
            log.error(MessageFormat.format("学生测试ID为{0}的做题临时缓存更新失败", studentExamInProgressInfo.getStudentExamId()), e);
            return false;
        }
    }

    @Override
    public boolean remove(StudentExamInProgressInfo studentExamInProgressInfo)
    {
        try
        {
            return studentExamInProgressInfoDao.remove(studentExamInProgressInfo);
        }
        catch (Exception e)
        {
            log.error(MessageFormat.format("学生测试ID为{0}的做题临时缓存删除失败", studentExamInProgressInfo.getStudentExamId()), e);
            return false;
        }
    }

}
