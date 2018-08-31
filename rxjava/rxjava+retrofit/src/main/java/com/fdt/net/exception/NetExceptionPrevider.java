package com.fdt.net.exception;

import android.net.ParseException;

import com.fdt.net.common.NetConfig;
import com.fdt.util.UiUtil;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by fudetian on 2018/8/29.
 */

public class NetExceptionPrevider {
    public static NetException handleException(Throwable e) {
        if (NetConfig.isDebug) UiUtil.logE(e.getMessage());
        NetException ex;
        if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            //解析错误
            ex = new NetException(NetConfig.API_PARSE_ERROR, "解析错误!");
            return ex;
        } else if (e instanceof ConnectException) {
            //网络错误
            ex = new NetException(NetConfig.API_NETWORK_ERROR, "网络开小差了,请检查网络连接!");
            return ex;
        } else if (e instanceof UnknownHostException || e instanceof SocketTimeoutException) {
            //连接错误
            ex = new NetException(NetConfig.API_NETWORK_ERROR, "网络连接失败,请重试!");
            return ex;
        } else {
            //未知错误
            ex = new NetException(NetConfig.API_UNKNOWN, "未知错误!");
            return ex;
        }
    }

    public static NetException handleException(String code, String errMsg) {
        if (NetConfig.isDebug) UiUtil.logE(errMsg);

        String errorMsg;
        switch (code) {
            case NetConfig.SERVICE_CODE_INVALID_INPUT:
                errorMsg = "参数请求出错";
                break;
            case NetConfig.SERVICE_CODE_TOKEN_INVALID:
                errorMsg = "会话失效,重新登录!";
                //TODO token失效后重新登录
                break;
            case NetConfig.SERVICE_CODE_DATABASE_ACCESS_EXCEPTION:
                errorMsg = "数据库存储失败";
                break;
            case NetConfig.SERVICE_CODE_DUPLICATE_SUBMISSION:
                errorMsg = "重复提交";
                break;
            case NetConfig.SERVICE_CODE_VERIFICATION_CODE_ERROR:
                errorMsg = "验证码输入错误";
                break;
            case NetConfig.SERVICE_CODE_RUNTIME_ERROR:
                errorMsg = "运行时异常";
                break;
            case NetConfig.SERVICE_CODE_UNKNOWN_ERROR:
                errorMsg = "未知运行时异常";
                break;
            case NetConfig.SERVICE_CODE_NULL_OBJECT:
                errorMsg = "查询到的数据为空";
                break;
            case NetConfig.SERVICE_CODE_REPEAT_ADD:
                errorMsg = "该家人已在其他美容院，不能添加。";
                break;
            default:
                errorMsg = "未知错误";
                break;
        }
        return new NetException(Integer.parseInt(code), errorMsg);
    }
}
