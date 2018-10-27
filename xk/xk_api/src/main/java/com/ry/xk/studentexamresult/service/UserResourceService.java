package com.ry.xk.studentexamresult.service;


import com.ry.xk.common.CommonConst;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.bo.UserResource;
import com.ry.xk.studentexamresult.bo.UserResourceList;
import com.ry.xk.studentexamresult.dao.IExamPaperDao;
import com.ry.xk.studentexamresult.dao.IUserResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserResourceService implements IUserResourceService
{

    @Autowired
    IUserResourceDao userResourceDao;

    @Autowired
    IExamPaperDao examPaperDao;

    /**
     * 获取免费试卷
     * 
     * @param userId
     * @param examPaperId
     * @return
     */
    public ResponseBase<Integer> getFreeExamPaper(int userId, int examPaperId)
    {
        ResponseBase<Integer> responseBase = new ResponseBase<Integer>();
        int returnEntity = CommonConst.FAIL;
        String message = "";
        ExamPaper examPaper = examPaperDao.get(examPaperId);
        UserResourceList userResourceList = userResourceDao.getUserResource(userId, CommonConst.EXAM_PAPER);
        long count = userResourceList.getUserResource().stream().filter(o -> o.getResourceId() == examPaperId).count();
        if (examPaper == null)
        {
            message = "该套试卷不存在";
        }
        else if (examPaper.getIsFree() != 1)
        {
            message = "该套试卷不是免费试卷";
        }
        else if (count > 0)
        {
            message = "你已购买过该套试卷";
        }else {
            UserResource userResource = new UserResource();
            userResource.setUserId(userId);
            userResource.setResourceTypeId(CommonConst.EXAM_PAPER);
            userResource.setResourceId(examPaperId);
            int rowCount = userResourceDao.addUserResource(userResource);
            if (rowCount > 0) {
                returnEntity = CommonConst.SUCCESS;
                message = "获取免费试卷成功";
            }
        }
        responseBase.setMessage(message);
        responseBase.setReturnEntity(returnEntity);
        return responseBase;
    }
}
