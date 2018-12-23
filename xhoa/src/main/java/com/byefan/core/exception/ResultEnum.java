package com.byefan.core.exception;

public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误!"),
    SUCCESS(0, "成功!"),
    FORBIDDEN(403, "没有权限!"),
    NOAUDIT(1002, "您没有审核权限！"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}