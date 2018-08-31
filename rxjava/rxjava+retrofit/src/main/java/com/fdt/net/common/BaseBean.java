package com.fdt.net.common;

import java.io.Serializable;

/**
 * Created by fudetian on 2018/8/28.
 */

public abstract class BaseBean implements Serializable {
    private Integer errCode;
    private String errMsg;
    private String erroBody;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErroBody() {
        return erroBody;
    }

    public void setErroBody(String erroBody) {
        this.erroBody = erroBody;
    }
}
