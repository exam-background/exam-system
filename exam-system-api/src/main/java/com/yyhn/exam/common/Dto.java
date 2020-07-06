package com.yyhn.exam.common;

public class Dto<T> {
    private String success; // 给出相应的true或者false
    private String errorCode;//错误状态码，0表示无错
    private String msg;//提示信息
    private T data;//具体返回数据类型

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
