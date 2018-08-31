package com.fdt.net;


import com.fdt.net.common.BaseBean;

/**
 * Created by fudetian on 2018/8/2.
 */

public class User extends BaseBean {
    private String code;
    private String clerkCode;
    private String clerkStatus;
    private String shopCode;
    private String companyCode;
    private String companyName;

    public String getCode() {
        return code;
    }

    public String getClerkCode() {
        return clerkCode;
    }

    public String getClerkStatus() {
        return clerkStatus;
    }

    public String getShopCode() {
        return shopCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }
}
