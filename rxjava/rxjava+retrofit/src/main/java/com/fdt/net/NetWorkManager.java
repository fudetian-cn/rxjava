package com.fdt.net;

import com.fdt.net.common.NetConfig;
import com.fdt.net.interceptor.BaseInterceptor;
import com.fdt.net.request.Request;
import com.fdt.util.JsonUtil;
import com.fdt.util.UiUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fudetian on 2018/8/22.
 */

public class NetWorkManager {

    private static NetWorkManager mInstance;
    private static Retrofit retrofit;
    private static volatile Request request = null;

    public static NetWorkManager getInstance() {
        if (mInstance == null) {
            synchronized (NetWorkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化必要对象和参数
     */
    public void init() {
        HttpLoggingInterceptor logInterceptor = null;
        if (!NetConfig.isDebug) {
            logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    UiUtil.logE("okhttp", message);
                }
            });
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        // 初始化okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(25, TimeUnit.SECONDS)   //连接超时时间
                .readTimeout(25, TimeUnit.SECONDS)      //读取超时时间
                .writeTimeout(25, TimeUnit.SECONDS)     //写入超时时间
                .addInterceptor(new BaseInterceptor())  //常规拦截器
                .addInterceptor(logInterceptor)         //log日志拦截器
                .build();

        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .client(client)                     //添加内置okhttp常规属性
                .baseUrl(NetConfig.HOST)            //添加主地址
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //添加rejava与retrofit关联适配器
                .addConverterFactory(GsonConverterFactory.create(JsonUtil.gson))         //添加gson解析器
                .build();
    }

    /**
     * 获取请求接口实例
     */
    public static Request getRequest() {
        if (request == null) {
            synchronized (Request.class) {
                request = retrofit.create(Request.class);
            }
        }
        return request;
    }
}
