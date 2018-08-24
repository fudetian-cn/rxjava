package com.fdt.rxjavaretrofit;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.util.Log;

import com.fdt.MyApplication;
import com.fdt.agency.DynamicProxy;
import com.fdt.agency.Sell;
import com.fdt.agency.Vendor;
import com.fdt.rxjavaretrofit.bean.Translation;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.reactivestreams.Subscription;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private String TAG = "RXJAVA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DynamicProxy dynamicProxy = new DynamicProxy(new Vendor());
//
//        Sell sell = (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[]{Sell.class}, dynamicProxy);
//
//        sell.sell();
//
//        sell.ad();

//        Observable.interval(2,1, TimeUnit.SECONDS)
//                .doOnNext(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.e(TAG, "第" + aLong + "次轮询");
//
//                        Retrofit retrofit = new Retrofit.Builder()
//                                .baseUrl("http://fy.iciba.com/")
//                                .addConverterFactory(GsonConverterFactory.create())
//                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                                .build();
//                        API api = retrofit.create(API.class);
//                       api.getCall()
//                               .subscribeOn(Schedulers.io())
//                               .observeOn(AndroidSchedulers.mainThread())
//                               .subscribe(new Consumer<Translation>() {
//                                   @Override
//                                   public void accept(Translation translation) throws Exception {
//                                       translation.show();
//                                   }
//                               }, new Consumer<Throwable>() {
//                                   @Override
//                                   public void accept(Throwable throwable) throws Exception {
//                                       Log.e(TAG, "请求失败");
//                                   }
//                               });
//                    }
//                }).subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//
//            }
//        });

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("okhttp", message);
            }
        });
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient builder = new OkHttpClient.Builder().addInterceptor(logInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-b.imeiyebang.com/")
                .client(builder)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Map<String, Map<String, Object>> paramCount = new HashMap<>();
        Map<String, Object> head = new HashMap<>();
        Map<String, Object> body = new HashMap<>();

        head.put("appType", "ANDROID_B_PAD");
        head.put("appVersion", getVersion().versionCode);
        head.put("apiVersion", "2.5.1");
        head.put("timestamp", "ef46b966f2e2e827fc7af4f84c76b4a5d957090bba066eebd301d2e0404fc40a");
        head.put("deviceToken", "");
        head.put("token", "");
        head.put("digest", MD5.GetMD5Code(new Date().toString()));

        body.put("mobile", "13233333333");
        body.put("password", "123456");
        body.put("isNotAuto", false);

        paramCount.put("head", head);
        paramCount.put("body", body);

        final String s = JsonUtil.toJson(paramCount);
        Log.e("123", s);

        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), s);
//        Call<ResponseBody> userDetailCall = api.doLogin(requestBody);
//        userDetailCall.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                byte[] bytes = new byte[0];
//                try {
//                    bytes = response.body().bytes();
//                    String s1 = new String(bytes);
//                    showLogE(TAG, s1);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                showLogE(TAG, "fail");
//                showLogE("Throwable", t.toString());
//            }
//        });

        api.doLogin(requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        Log.e(TAG,user.getBody().getCode());
                    }
                });


//        api.doLogin(requestBody)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<UserDetail>() {
//            @Override
//            public void accept(UserDetail s) throws Exception {
//                showLogE(TAG, s.toString());
//            }
//        });

    }

    public static void showLogE(String Tag, String log) {
        if (log != null)
            if (log.length() > 3000) {
                for (int i = 0; i < log.length(); i += 3000) {
                    if (i + 3000 < log.length())
                        Log.e(Tag + i, log.substring(i, i + 3000));
                    else
                        Log.e(Tag + i, log.substring(i, log.length()));
                }
            } else
                Log.e(Tag, log);
    }


    public PackageInfo getVersion() {
        // 得到包管理器
        PackageManager pm = getPackageManager();
        try {
            PackageInfo infop = pm.getPackageInfo(getPackageName(), 0);

            return infop;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            // 不可能发生
            return null;
        }
    }
}
