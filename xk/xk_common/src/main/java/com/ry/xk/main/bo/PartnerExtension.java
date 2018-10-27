package com.ry.xk.main.bo;

import java.util.List;

/**
 * 合作伙伴拓展信息json字符串对应的实体类
 */
public class PartnerExtension {

    private String templateId;

    private List<PartnerImage> shareImages;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public List<PartnerImage> getShareImages() {
        return shareImages;
    }

    public void setShareImages(List<PartnerImage> shareImages) {
        this.shareImages = shareImages;
    }
}
