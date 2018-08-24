package com.fdt.rxjavaretrofit.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wuchao on 15/11/18.
 */
public class Head implements Serializable {
    private String errCode;
    private String digest;
    private String sn;
    private String fetchDate;

    public String getFetchDate() {
        return fetchDate;
    }

    public void setFetchDate(String fetchDate) {
        this.fetchDate = fetchDate;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

}
