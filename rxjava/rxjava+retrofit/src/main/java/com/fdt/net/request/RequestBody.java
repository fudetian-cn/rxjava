package com.fdt.net.request;


import com.fdt.util.JsonUtil;
import com.fdt.util.MD5Util;
import com.fdt.util.SystemUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fudetian on 2018/8/27.
 */

public class RequestBody {
    Map<String, Map<String, Object>> param = new HashMap<>();
    Map<String, Object> head = new HashMap<>();
    Map<String, Object> body = new HashMap<>();

    public RequestBody() {
        head.put("appType", "ANDROID_B_PAD");
        head.put("appVersion", SystemUtil.getVersion().versionCode);
        head.put("apiVersion", "2.5.1");
        head.put("digest", MD5Util.GetMD5Code(new Date().toString()));
        head.put("timestamp", "ef46b966f2e2e827fc7af4f84c76b4a5d957090bba066eebd301d2e0404fc40a");
        head.put("deviceToken", "");
        head.put("token", "");
    }

    public String createJson() {
        param.put("head", head);
        param.put("body", body);
        return JsonUtil.toJson(param);
    }

    public static class Builder {
        RequestBody requestBody;

        public Builder() {
            requestBody = new RequestBody();
        }

        public Builder addBodyParam(String key, Object obj) {
            requestBody.body.put(key, obj);
            return this;
        }

        public okhttp3.RequestBody create() {
            return okhttp3.RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), requestBody.createJson());
        }
    }

}
