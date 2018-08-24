package com.fdt.rxjavaretrofit;

import com.fdt.rxjavaretrofit.bean.Head;

import java.io.Serializable;

/**
 * Created by fudetian on 2018/8/2.
 */

public class User implements Serializable{
    class Body {
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

    private Head head;
    private Body body;

    public Head getHead() {
        return head;
    }

    public Body getBody() {
        return body;
    }
}
