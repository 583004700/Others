package com.ry.xk.main.service;


import com.alibaba.fastjson.JSONException;
import com.ry.xk.common.bo.SystemConfig;
import com.ry.xk.common.service.ISystemConfigService;
import com.ry.xk.main.bo.PartnerImage;
import com.ry.xk.studentexamresult.dao.IShareDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ShareService implements IShareService
{

    @Autowired
    IShareDao shareDao;

    @Autowired
    ISystemConfigService systemConfigService;

    /**
     * 获取用户分享图片的地址
     * 
     * @param type
     * @return
     */
    @Override
    public String getShareImage(int partnerId, int type)
        throws JSONException
    {
        String imageAddress = "";
        List<PartnerImage> partnerImages = shareDao.getImage(partnerId);
        SystemConfig systemConfig = systemConfigService.systemConfigs();
        // 过滤
        partnerImages = partnerImages.stream().filter((o) -> o.getType() - type == 0).collect(Collectors.toList());
        if (partnerImages.size() > 0)
        {
            imageAddress = systemConfig.getYjpFileHost()+partnerImages.get(0).getUrl();
        }
        return imageAddress;
    }
}
