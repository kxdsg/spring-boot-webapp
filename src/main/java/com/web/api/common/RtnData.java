package com.web.api.common;


public class RtnData {

    private String errCode = "000000";
    private String msg = "success";
    private Object data;

    public RtnData(String errCode, String msg, Object data) {
        this.errCode = errCode;
        this.msg = msg;
        this.data = data;
    }

    public RtnData(Object data) {
        this.data = data;
    }

    public RtnData(String errCode, String msg) {
        this.errCode = errCode;
        this.msg = msg;
    }

    public RtnData() {}

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
