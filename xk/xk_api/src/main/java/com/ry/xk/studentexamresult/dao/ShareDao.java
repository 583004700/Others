package com.ry.xk.studentexamresult.dao;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerExtension;
import com.ry.xk.main.bo.PartnerImage;
import com.ry.xk.main.dao.PartnerDao;
import com.ry.xk.studentexamresult.controller.OrderController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShareDao implements IShareDao{

    private static final Logger log = LoggerFactory.getLogger(IShareDao.class);

    @Autowired
    PartnerDao partnerDao;

    /**
     * 获取用户保存图片的数组
     * @param partnerId
     * @return
     */
    @Override
    public List<PartnerImage> getImage(int partnerId) throws JSONException{
        Partner partner = partnerDao.get(partnerId);
        if(partner == null){
            return new ArrayList<PartnerImage>();
        }
        List<PartnerImage> partnerImages = null;
        //用户拓展信息
        PartnerExtension partnerExtension = null;
        if(partner.getPartnerExtension() != null){
            partnerExtension = JSONObject.parseObject(partner.getPartnerExtension(), PartnerExtension.class);
            partnerImages = partnerExtension.getShareImages();
        }
        return partnerImages;
    }
}
