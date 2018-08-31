package com.fdt.net.common;

/**
 * Created by fudetian on 2018/8/22.
 */

public class NetConfig {
    // 开发版，发布版开关
    public static boolean isDebug = false;

    //服务器地址
    public final static String HOST;

    static {
        if (isDebug) {
            HOST = "http://uat2-api.imeiyebang.com";
        } else {
            HOST = "https://api-b.imeiyebang.com";
        }
    }


    /**
     * 请求服务器成功,服务器与客户端定义的状态码
     * 1000 处理成功
     * 1001 Tocken无效或者已过期
     * 1002 验证码输入错误
     * 1003 数据库存取异常
     * 1004 重复提交的请求
     */
    public static final String SERVICE_CODE_SUCCESS = "1000";
    public static final String SERVICE_CODE_TOKEN_INVALID = "1001";
    public static final String SERVICE_CODE_VERIFICATION_CODE_ERROR = "1002";
    public static final String SERVICE_CODE_DATABASE_ACCESS_EXCEPTION = "1003";
    public static final String SERVICE_CODE_DUPLICATE_SUBMISSION = "1004";
    public static final String SERVICE_CODE_INVALID_INPUT = "1005";
    public static final String SERVICE_CODE_RUNTIME_ERROR = "1006";
    public static final String SERVICE_CODE_UNKNOWN_ERROR = "1007";
    public static final String SERVICE_CODE_NULL_OBJECT = "1008";
    public static final String SERVICE_CODE_REPEAT_ADD = "C1311";
    public static final String SERVICE_STOCK_CODE_SUCCESS = "1000000";

    /**
     * 请求失败,自定义的异常状态码
     * 10 未知错误
     * 11 解析错误
     * 12 网络错误
     * 13 协议错误
     */
    public static final int API_UNKNOWN = 10;
    public static final int API_PARSE_ERROR = 11;
    public static final int API_NETWORK_ERROR = 12;
    public static final int API_HTTP_ERROR = 13;

}
