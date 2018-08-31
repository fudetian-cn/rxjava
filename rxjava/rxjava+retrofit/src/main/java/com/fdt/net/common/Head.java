package com.fdt.net.common;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by fudetian by 2018/8/25
 */
public final class Head implements Serializable {
    private String errCode;
    private String digest;
    private String sn;
    private Date fetchDate;

    public Date getFetchDate() {
        return fetchDate;
    }

    public void setFetchDate(Date fetchDate) {
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
