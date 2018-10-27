package com.ry.xk.main.service;

import com.alibaba.fastjson.JSONException;
import org.springframework.stereotype.Service;

@Service
public interface IShareService {
    /**
     * 获取用户分享图片的地址
     * @param type
     * @return
     */
    public String getShareImage(int partnerId,int type) throws JSONException;
}
