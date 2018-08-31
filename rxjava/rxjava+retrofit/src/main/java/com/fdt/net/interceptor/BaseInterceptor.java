package com.fdt.net.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by fudetian on 2018/8/27.
 */

public class BaseInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        okhttp3.Request request = chain.request();

        request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "text/json")
                .build();

        return chain.proceed(request);
    }
}
