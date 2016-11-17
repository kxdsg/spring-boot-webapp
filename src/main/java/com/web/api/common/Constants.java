package com.web.api.common;

/**
 *
 * Created by xingding on 2016/10/29.
 */
public class Constants {
    /**
     * 通用成功返回码
     */
    public final static String RTN_CODE_SUCCESS = "000000";

    /**
     * 通用成功信息
     */
    public final static String RTN_MESSAGE_SUCCESS = "success";

    /**
     * 通用错误返回码
     */
    public final static String RTN_CODE_ERROR = "999999";

    /**
     * 通用错误信息
     */
    public final static String RTN_MESSAGE_ERROR = "请求发生异常";

    /**
     * 业务错误返回码
     */
    public final static String SERVICE_CODE_ERROR = "900000";

    /*
     * 其他错误说明
     */
    public final static String MANDATORY_CODE_ERROR = "900001";

    public final static String MANDATORY_MESSAGE_ERROR = "缺少必填参数";

    public final static String INVALID_CODE_ERROR = "900002";

    public final static String INVALID_MESSAGE_ERROR = "参数无效";
}
