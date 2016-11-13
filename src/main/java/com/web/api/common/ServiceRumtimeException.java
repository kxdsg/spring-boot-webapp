package com.web.api.common;

/**
 *
 * Created by xingding on 2016/10/29.
 */
public class ServiceRumtimeException extends RuntimeException {
    private String code;

    public ServiceRumtimeException(String code) {
        this.code = code;
    }

    public ServiceRumtimeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String toString() {
        return "ServiceRumtimeException(code=" + this.getCode() + ")";
    }

    public String getCode() {
        return this.code;
    }
}
