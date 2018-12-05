package com.web.api.common.data;

/**
 * Created by xingding on 2016/10/29.
 */
public class Constants {
	
	/* 平台代码规范常量 */
	public final static String RTN_CODE_SUCCESS = "000000"; //通用成功代码
	public final static String RTN_CODE_FAIL = "999999"; //通用错误代码
	
	public final static String RTN_CODE_INVALID_API = "123456"; //定制的错误代码
    
    public final static String RTN_STATUS_SUCCESS = "OK";
    public final static String RTN_STATUS_ERROR = "ERROR";

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
