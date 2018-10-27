package com.ry.xk.common.bo;

import java.io.Serializable;

/**
 * 更新文档接口输出实体
 *
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class ResponseBase<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    // 结果：1-成功 2-失败
    private int resultType;
    // 返回消息
    private String message;

    // 执行结果
    private T returnEntity;

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T isReturnEntity() {
        return returnEntity;
    }

    public void setReturnEntity(T returnEntity) {
        this.returnEntity = returnEntity;
    }

    public ResponseBase() {
    }

    public ResponseBase(int resultType, String message, T returnEntity) {
        this.resultType = resultType;
        this.message = message;
        this.returnEntity = returnEntity;
    }

}
