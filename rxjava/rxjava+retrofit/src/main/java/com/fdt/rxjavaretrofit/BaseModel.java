package com.fdt.rxjavaretrofit;

import com.fdt.rxjavaretrofit.bean.Head;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;


/**
 * Created by wuchao on 15/11/18.
 */
public class BaseModel implements Serializable {
    protected Head head;
    protected Integer errCode;
    protected String errMsg;
    private String erroBody;

    public Integer getErrCode() {
        return errCode;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
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

    public static Head getHead(String jsonObject) {
        String str = "";
        Head h;
        try {
            str = getString(new JSONObject(jsonObject), "head");
            h = JsonUtil.fromJson(str, Head.class);
        } catch (JSONException e) {
            return null;
        }
        return h;
    }

    public static String getBody(String jsonObject) {
        String body;
        try {
            body = getString(new JSONObject(jsonObject), "body");
        } catch (JSONException e) {
            return null;
        }
        return body;
    }

    public String getErroBody() {
        return this.erroBody;
    }

    public void setErroBody(String body) {
        this.erroBody = body;
    }

    public static BaseModel getFormBaseModel(String jsonObject) {
        BaseModel baseModel = new BaseModel();
        baseModel.setHead(getHead(jsonObject));
        String body = getBody(jsonObject);
        try {
            baseModel.setErrMsg(getString(new JSONObject(getBody(jsonObject)), "errMsg"));
            baseModel.setErroBody(body);
        } catch (JSONException e) {

        }
        return baseModel;
    }

    public static String getString(JSONObject json, String member) {
        String v = "";
        try {
            v = json.getString(member);
        } catch (JSONException e) {
        }

        if ("null".equals(v)) v = "";

        return v;
    }

}
