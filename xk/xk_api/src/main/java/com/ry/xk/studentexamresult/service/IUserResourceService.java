package com.ry.xk.studentexamresult.service;

import com.ry.xk.common.bo.ResponseBase;
import org.springframework.stereotype.Service;

@Service
public interface IUserResourceService {
    /**
     * 获取免费试卷
     * @param userId
     * @param examPaperId
     * @return
     */
    public ResponseBase<Integer> getFreeExamPaper(int userId, int examPaperId);
}
