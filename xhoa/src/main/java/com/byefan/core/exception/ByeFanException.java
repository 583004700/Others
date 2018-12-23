package com.byefan.core.exception;

public class ByeFanException extends RuntimeException{

    private Integer code;

    public ByeFanException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}