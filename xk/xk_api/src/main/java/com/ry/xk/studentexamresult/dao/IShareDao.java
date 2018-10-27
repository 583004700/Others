package com.ry.xk.studentexamresult.dao;

import com.alibaba.fastjson.JSONException;
import com.ry.xk.main.bo.PartnerImage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IShareDao {
    /**
     * 获取用户图片的数组
     * @param partnerId
     * @return
     */
    public List<PartnerImage> getImage (int partnerId) throws JSONException;
}
