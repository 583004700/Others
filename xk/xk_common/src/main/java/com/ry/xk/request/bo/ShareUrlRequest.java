package com.ry.xk.request.bo;

import com.ry.xk.common.bo.RequestBase;

/**
 * 分享图片输入实体
 */
public class ShareUrlRequest extends RequestBase{
    //图片类型 1代表发出去的 2代表接收到的
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
