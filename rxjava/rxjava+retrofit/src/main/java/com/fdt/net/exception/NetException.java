package com.fdt.net.exception;

/**
 * Created by fudetian on 2018/8/29.
 */

public class NetException extends Exception {
    private int code;               //状态码
    private String errMsg;          //异常信息

    public NetException(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
