package com.ry.xk.studentexamresult.service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.bo.SystemConfig;
import com.ry.xk.common.service.ISystemConfigService;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.response.bo.ExamPaperDetailModule;
import com.ry.xk.response.bo.ExamPaperListModule;
import com.ry.xk.studentexamresult.bo.*;
import com.ry.xk.studentexamresult.dao.*;
import com.ry.xk.utils.DateUtil;
import com.ry.xk.utils.UrlUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExamPaperService implements IExamPaperService
{
    private static final Logger log = LoggerFactory.getLogger(ExamPaperService.class);

    @Autowired
    IExamPaperDao examPaperDao;

    @Autowired
    IStudentExamDao studentExamDao;

    @Autowired
    IUserResourceDao userResourceDao;

    @Autowired
    IStudentExamInProgressInfoDao studentExamInProgressInfoDao;

    @Autowired
    IStudentExamResultDao studentExamResultDao;

    @Autowired
    ISystemConfigService systemConfigService;

    @Autowired
    IPartnerDao partnerDao;

    /**
     * 通过测试Id获取做题情况 已做/总数
     * 
     * @param studentExamId
     * @return
     */
    public String getAnswerSituation(Long studentExamId)
    {
        String answerSituation = "";
        if (studentExamId == null || studentExamId == 0)
        {
            return answerSituation;
        }
        StudentExamInProgressInfo studentExamInProgressInfo = studentExamInProgressInfoDao.get(studentExamId);
        if (studentExamInProgressInfo != null)
        {
            if (studentExamInProgressInfo.getExamDoingQuestions() != null)
            {
                int doneCount = (int)studentExamInProgressInfo.getExamDoingQuestions().stream().filter(o -> StringUtils.isNotEmpty(o.getStudentAnswer())).count();
                int count = studentExamInProgressInfo.getExamDoingQuestions().size();
                answerSituation = String.format("%s/%s", doneCount, count);
            }
        }
        return answerSituation;
    }

    /**
     * 获取试卷列表
     * 
     * @param status
     * @param courseId
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<ExamPaper> getExamPaper(int partnerId, int status, int courseId, int userId, int pageIndex, int pageSize)
    {
        // 如果页码小于1，则取第一页
        if (pageIndex < 1)
        {
            pageIndex = 1;
        }
        if (pageSize < 1)
        {
            pageSize = 25;
        }
        int startIndex = (pageIndex - 1) * pageSize;
        List<ExamPaper> examPapers = null;
        if (status == CommonConst.ALL)
        {
            // 全部
            examPapers = examPaperDao.getExamPaper(partnerId, courseId, startIndex, pageSize);
        }
        else if (status == CommonConst.BUYED)
        {
            // 已购买
            examPapers = examPaperDao.getBuyExamPaper(partnerId, courseId, userId, startIndex, pageSize);
        }
        if (examPapers == null)
        {
            examPapers = new ArrayList<ExamPaper>();
        }
        return examPapers;
    }

    /**
     * 获取最后一次有效的测试信息
     * 
     * @param userResourceList
     *            用户资源数据
     * @param studentExamList
     *            用户测试数据
     * @param examPaperId
     *            试卷Id
     * @return 返回最后一次测试的信息，studentExamId为空代码未测试过
     */
    public StudentLastExamItem getExamPaperLastExam(UserResourceList userResourceList, StudentExamList studentExamList, int examPaperId)
    {
        // 最后一次有效测试
        StudentLastExamItem lastExam = new StudentLastExamItem();
        // 获取用户当前试卷数量
        long userResourcesCount = 0;
        if (userResourceList != null && userResourceList.getUserResource() != null)
        {
            userResourcesCount = userResourceList.getUserResource().stream().filter((o) -> o.getResourceId() == examPaperId).count();
        }
        if (userResourcesCount == 0)
        {
            // 未购买
            lastExam.setStatus(CommonConst.WGM);
            return lastExam;
        }
        int status = CommonConst.YGMWC;
        if (studentExamList == null)
        {
            lastExam.setStatus(CommonConst.YGMWC);
            return lastExam;
        }
        // 获取当前试卷的测试,并按时间倒序以便取到最后一次测试
        List<StudentExamItem> currentExamPaperStudenExam = studentExamList.getStudentExamItems().stream().filter((o) -> o.getExamPaperId() == examPaperId).sorted(
            (o1, o2) -> o2.getEndDateTime().compareTo(o1.getEndDateTime())).collect(Collectors.toList());
        // 因为找到无效的记录要继续找上一条记录，所以要循环
        StudentExamItem studentExamItem = null;
        for (int i = 0; i < currentExamPaperStudenExam.size(); i++ )
        {
            // 说明测试过
            if (currentExamPaperStudenExam.get(i).getIsGenerateEvaluation())
            {
                // 生成了测评,状态为已购买已测试
                status = CommonConst.YGMYC;
                studentExamItem = currentExamPaperStudenExam.get(i);
                break;
            }
            else if (new Date().getTime() < currentExamPaperStudenExam.get(i).getEndDateTime().getTime())
            {
                // 当前时间在结束时间之内且没有生成测评
                status = CommonConst.YGMZZCSZ;
                studentExamItem = currentExamPaperStudenExam.get(i);
                break;
            }
        }
        lastExam.setStatus(status);
        if (studentExamItem != null)
        {
            lastExam.setAllAttribute(studentExamItem.getUserId(), studentExamItem.getExamPaperId(), studentExamItem.getStudentExamId(), studentExamItem.getCreateDateTime(),
                studentExamItem.getEndDateTime(), studentExamItem.getIsGenerateEvaluation(), status);
        }
        return lastExam;
    }

    /**
     * 获取最后一次有效的测试信息
     * 
     * @param userId
     *            用户Id
     * @param examPaperId
     *            试卷Id
     * @return
     */
    public StudentLastExamItem getExamPaperLastExam(int userId, int examPaperId)
    {
        // 获取用户所有模拟测试卷
        UserResourceList userResourceList = userResourceDao.getUserResource(userId, CommonConst.EXAM_PAPER);
        // 获取用户测试数据缓存
        StudentExamList studentExamList = studentExamDao.getStudentExamList(userId);
        return getExamPaperLastExam(userResourceList, studentExamList, examPaperId);
    }

    /**
     * 获取试卷列表，并组织成controller需要的对象
     * 
     * @param status
     * @param courseId
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public ExamPaperListModule getExamPaperList(int partnerId, int status, int courseId, int userId, int pageIndex, int pageSize)
    {
        boolean isBuyAll = false;
        // 获取用户所有模拟测试卷
        UserResourceList userResourceList = userResourceDao.getUserResource(userId, CommonConst.EXAM_PAPER);
        // 获取所有试卷
        List<ExamPaper> examPapersAll = examPaperDao.getExamPaper(partnerId, courseId, 0, Integer.MAX_VALUE);
        if (examPapersAll != null)
        {
            //求已购买的试卷数量
            List<ExamPaper> noFreeExamPapers = examPapersAll.stream().filter(e->e.getIsFree() != 1).collect(Collectors.toList());
            long noFreeExamPaperCount = noFreeExamPapers.size();
            long ygmCount = noFreeExamPapers.stream().filter((o) ->
                    userResourceList.getUserResource().stream().anyMatch((t) -> o.getExamPaperId() == t.getResourceId())).count();
            isBuyAll = ygmCount == noFreeExamPaperCount;
        }
        // 获取用户测试数据缓存
        StudentExamList studentExamList = studentExamDao.getStudentExamList(userId);
        ExamPaperListModule examPaperListModule = new ExamPaperListModule();
        List<com.ry.xk.response.bo.ExamPaper> examPaperModules = new ArrayList<com.ry.xk.response.bo.ExamPaper>();
        examPaperListModule.setIsBuyAll(isBuyAll);
        examPaperListModule.setPaperList(examPaperModules);
        try
        {
            PartnerCourseMapping currentCourseMapping = partnerDao.getPartnerCourseMapping(partnerId).stream().filter(o -> o.getCourseId() - courseId == 0).collect(Collectors.toList()).get(0);
            examPaperListModule.setTotalPrice(new DecimalFormat("0.00").format(currentCourseMapping.getPackagePrice()));
        }
        catch (Exception e)
        {
            log.error("当前用户学科映射不存在partnerId" + partnerId + "courseId" + courseId, e);
        }
        // 获取所有试卷
        List<ExamPaper> examPapers = getExamPaper(partnerId, status, courseId, userId, pageIndex, pageSize);
        examPapers.forEach((o) -> {
            com.ry.xk.response.bo.ExamPaper examPaper = new com.ry.xk.response.bo.ExamPaper();
            try
            {
                String examPaperIdStr = UrlUtil.idEncrypt(o.getExamPaperId());
                examPaper.setExamPaperId(examPaperIdStr);
            }
            catch (Exception e)
            {
                log.error("加密ExamPaperId异常" + o.getExamPaperId(), e);
            }
            examPaper.setExamPaperName(o.getExamPaperName());
            examPaper.setIsFree(o.getIsFree() == 1);
            // 试卷状态
            StudentLastExamItem studentLastExamItem = getExamPaperLastExam(userResourceList, studentExamList, o.getExamPaperId());
            examPaper.setStatus(studentLastExamItem.getStatus());
            examPaper.setPrice(new DecimalFormat("0.00").format(o.getPrice()));
            long steId = studentLastExamItem.getStudentExamId();
            if (steId != 0)
            {
                try
                {
                    String steIdStr = UrlUtil.idEncrypt(steId);
                    examPaper.setSteId(steId == 0 ? "" : steIdStr);
                }
                catch (Exception e)
                {
                    log.error("加密测试ID异常userId" + userId + "examPaperId" + steId, e);
                }
                StudentExamResult studentExamResult = studentExamResultDao.get(steId);
                if (studentExamResult != null)
                {
                    examPaper.setScore(studentExamResult.getScore());
                }
            }
            else
            {
                examPaper.setSteId("");
            }
            examPaper.setAnswerSituation(getAnswerSituation(steId));
            SystemConfig systemConfig = systemConfigService.systemConfigs();
            examPaper.setExamPaperCoverPath(StringUtils.isNotEmpty(o.getExamPaperCoverPath()) ? systemConfig.getYjpFileHost() + o.getExamPaperCoverPath() : "");
            examPaperListModule.getPaperList().add(examPaper);
        });
        return examPaperListModule;
    }

    /**
     * 通过examPaperId获取试卷,并组织成controller需要的对象
     * 
     * @return
     */
    public ExamPaperDetailModule get(int userId, int examPaperId)
    {
        ExamPaperDetailModule examPaperDetailModule = null;
        ExamPaper examPaper = examPaperDao.get(examPaperId);
        if (examPaper != null)
        {
            examPaperDetailModule = new ExamPaperDetailModule();
            StudentLastExamItem lastExam = getExamPaperLastExam(userId, examPaperId);
            examPaperDetailModule.setStatus(lastExam.getStatus());
            long steId = lastExam.getStudentExamId();
            if (steId != 0)
            {
                String steIdStr = UrlUtil.idEncrypt(steId);
                examPaperDetailModule.setSteId(steIdStr);
                if (lastExam.getStatus() == CommonConst.YGMZZCSZ)
                {
                    examPaperDetailModule.setAnswerSituation(getAnswerSituation(steId));
                }
                if (lastExam.getStatus() == CommonConst.YGMYC)
                {
                    StudentExamResult studentExamResult = studentExamResultDao.get(steId);
                    if (studentExamResult != null)
                    {
                        examPaperDetailModule.setScore(studentExamResult.getScore());
                    }
                }
            }
            else
            {
                examPaperDetailModule.setSteId("");
            }
            examPaperDetailModule.setBuild(examPaper.getExamConstitute());
            String examType = examPaper.getExamType() == CommonConst.CLOSE_PAPER ? "闭卷" : "开卷";
            examPaperDetailModule.setExamMethod(examType);
            examPaperDetailModule.setExamPaperName(examPaper.getExamPaperName());
            examPaperDetailModule.setExamTime(examPaper.getExamTime());
            examPaperDetailModule.setExpDate(DateUtil.format(examPaper.getExpireTime(), "yyyy/MM/dd"));
            examPaperDetailModule.setProvider(examPaper.getProvider());
            examPaperDetailModule.setUseYear(String.valueOf(examPaper.getUseYear()));
            String steIdStr = UrlUtil.idEncrypt(steId);
            examPaperDetailModule.setSteId(steIdStr);
            examPaperDetailModule.setIsFree(examPaper.getIsFree() == 1);
            examPaperDetailModule.setPrice(new DecimalFormat("0.00").format(examPaper.getPrice()));
            SystemConfig systemConfig = systemConfigService.systemConfigs();
            examPaperDetailModule.setExamPaperCoverPath(StringUtils.isNotEmpty(examPaper.getExamPaperCoverPath()) ? systemConfig.getYjpFileHost() + examPaper.getExamPaperCoverPath() : "");
        }
        return examPaperDetailModule;
    }
}
