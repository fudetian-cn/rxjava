package com.fdt.rxjavaretrofit;


import com.fdt.rxjavaretrofit.bean.Translation;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by fudetian on 2018/8/1.
 */

public interface API {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<Translation> getCall();

//    @Headers({"Content-Type: application/json","Accept: text/json"})
//    @POST("clerk/loginAccount/login")
//    Call<ResponseBody> doLogin(@Body RequestBody route);

    @Headers({"Content-Type: application/json","Accept: text/json"})
    @POST("clerk/loginAccount/login")
    Observable<User> doLogin(@Body RequestBody route);
}
