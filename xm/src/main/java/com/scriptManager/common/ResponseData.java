package com.scriptManager.common;

public class ResponseData {
    private boolean status;
    private String message;

    /**
     * 获取正确执行完的返回值
     * @return
     */
    public static ResponseData getOk(){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(true);
        return responseData;
    }

    /**
     * 获取catch执行异常时返回给前端的值
     * @return
     */
    public static ResponseData getError(){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(false);
        return responseData;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
